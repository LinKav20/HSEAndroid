#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>

int main() {
    char *array;
    int shmid;
    char pathname[] = "07-1a.c";
    key_t key;

    int *start_of_my_file;
    FILE *my_file = fopen(pathname, "r");

    fseek(my_file, 0L, SEEK_END);
    int my_size  = ftell(my_file);
    rewind(my_file);

    if ((key = ftok(pathname, 0)) < 0) {
        printf("Can\'t generate key\n");
        exit(-1);
    }

    if ((shmid = shmget(key, sizeof(int) + my_size * sizeof(char), 0666 | IPC_CREAT | IPC_EXCL)) < 0) {
        if (errno != EEXIST) {
            printf("Can\'t create shared memory\n");
            exit(-1);
        } else {
            if ((shmid = shmget(key, 2579, 0)) < 0) {
                printf("Can\'t find shared memory\n");
                exit(-1);
            }
        }
    }
    if ((start_of_my_file = (int *) shmat(shmid, NULL, 0)) == (int *) (-1)) {
        printf("Can't attach shared memory\n");
        exit(-1);
    }
    *start_of_my_file = my_size;
    array = (char *) (start_of_my_file + 1);

    for (int i = 0; i < my_size; ++i) {
        array[i] = fgetc(my_file);
    }
    fclose(my_file);

    if (shmdt(start_of_my_file) < 0) {
        printf("Can't detach shared memory\n");
        exit(-1);
    }
    printf("File read successfully.\n");
    return 0;
}