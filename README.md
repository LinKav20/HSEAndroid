# HSEAndroid
## Задание 1. 
Скачать Android SDK + Eclipse (Eclipse ADT Bundle) / Android Studio http://developer.android.com/sdk/index.html, а также последню версию java (JDK) http://www.oracle.com/technetwork/java/index-jsp-138363.html (или просто набрать в yandex "JDK" и пройти по ссылке на oracle.com). Установить всё это. Создать новый проект, зайти в Android SDK и скачать какую-нибудь версию Android SDK (например, lollipop - 5.0.1), выделив все инструменты для работы с ней; сконфигурировать эмулятор (желательно эмулировать своё собственное мобильное устройство, включая версию андроид на нём в качестве Target SDK). Изменить TextView с надписью "Hello world" на свои ФИО и группу (далее этот TextView должен появляться в реализации каждого задания вплоть до 16). Запустить проект на эмуляторе и убедиться, что всё работает.

## Задание 2.
Создать новый проект, написать программу, которая выводит в элемент TextView надпись, введённую пользователем в текстовом поле EditText после нажатия на кнопку Button. Помимо этого в Activity должен быть TextView с ФИО студента и группой. Запустить на эмуляторе и убедиться, что всё работает.

## Задание 3. 
Создать приложение, которое состоит из нескольких activities. Первое activity содержит элемент TextView с названием или номером activity, текстовое поле EditText для ввода какой-то информации, кнопку Button с названием "Next" или "Перейти на 2 activity/экран/окно" или просто "2". Помимо этого в 1 activity должен быть TextView с ФИО студента и группой. После нажатия на эту кнопку происходит переход на второе activity, где содержится TextView с названием или номером activity, TextView с надписью что-то вроде "В первом окне вы напечатали:" и под ним - ещё один TextView с содержимым EditText с первого activity, и, разумеется, кнопка "1" или "Вернуться на 1 экран" или "Вернуться к вводу текста", нажав на которую пользователь может перейти обратно к 1 activity. Запустить на эмуляторе и убедиться, что всё работает.

## Задание 4. 
В новом проекте написать приложение, работающее с разными темами/стилями. Сначала создать свой стиль и применить его к какому-нибудь интерфейсному элементу, затем - свою тему, которая применяется ко всем интерфейсным элементам. Приложение при этом должно выглядеть нестандартно. запустить на эмуляторе и убедиться, что всё работает. При возникновении ошибок открыть лог (CatLog) внизу, найти первую красную надпись и породить свою тему от той, которая требуется в этом красном сообщении.

## Задание 5. 
Создать пользовательский (свой) список. Например, получить доступ в приложении к контактам (Permissions-закладка в AndroidManifest.xml) и скопировать контакты телефона в свой список, который отобразить после запуска приложения. Или создать свой список в виде твиттера (картинка+текст), элементы которого просто статически задать в массиве (как и картинки).

## Задание 6.  
Создать приложение, содержащее анимированные интерфейсные элементы (например, увеличивающиеся при клике на них кнопки, вращающиеся TextView и т.д.).

## Задание 7. 
Создать приложение, отображающее после запуска карты Google или какие-нибудь другие карты.

## Задание 8. 
Создать собственный виджет с настройками. Например, виджет, который открывает какой-то сайт (по лекции), адрес которого можно поменять в настройках.

## Задание 9.  
Создать приложение, использующее опциональное меню (меню настроек) и контекстное меню для какого-нибудь интерфейсного элемента. Естественно, выбор пунктов меню должен что-то менять в интерфейсных элементах или их отображении! Например, очистить поле ввода через контекстное меню, или отобразить невидимые интерфейсные элементы через установку галок в опциональном меню.

## Задание 10. 
Создать приложение, отображающее после некоторых действий (нажатия на кнопку, например, или проверки корректности ввода текста в EditText) диалоговое окно, свидетельствующее об ошибке/информирующее/предупреждающее пользователя о чём-то.

## Задание 11. 
Создать приложение, помещающее по нажатию на кнопку какое-то сообщение со звуком в панель уведомлений/статус-панель на эмуляторе.

## Задание 12.  
Создать приложение, по нажатию кнопки в котором проигрывается какой-то звук.

## Задание 13. 
Создать приложение, при запуске которого проигрывается какое-то видео.

## Задание 14. 
Создать приложение, при запуске которого активируется фотокамера телефона, производится снимок, и этот снимок помещается в ImageView интерфейса приложения.

## Задание 15.  
Создать приложение, работающее с SharedPreferences и сохраняющее настройки, а также работающее с БД SQLite - заполняющее БД по нажатию кнопки 1 с помощью EditText, и выводящее все записи этой БД в какой-нибудь интерфейсный элемент ниже с помощью кнопки 2 (в виде списка, datagrid или просто правильно настроенного TextView).

## Задание 16.  
Создать простейшее облачное мобильное приложение, используя Firebase, App Engine и Android Studio. (https://cloud.google.com/solutions/mobile/)

## Задание 17.
Разработать приложение, в котором есть распознавание всех поддерживаемых жестов. Приложение содержит одно activity, одно информационное поле (textView) для вывода информации о распознанном жесте. Приложение работает следующим образом: пользователь выполняет один из поддерживаемых сенсорных жестов, в информационном поле отображается информация о распознанном жесте. Источник - лекция14.ppt

## Задание 18.
Разработать приложение, помогающее понять принципы работы с вводимыми пользователем жестами и использующее результаты построения жестов с помощью Gesture Builder. В приложении должны распознаваться построенные ранее жесты, в textView выводится информация о том, что за жест был только что использован.Источник - лекция15.ppt

## Задание 19.
Разработать приложение, работающее со сторонними библиотеками. Пусть сторонней библиотекой будет библиотека для построения графиков AChartEngine (https://github.com/ddanny/achartengine). Сторонней библиотекой также может быть любая другая библиотека. необходимо в приложении использовать эту библиотеку (в данном случае - построить какой-то график с её помощью) и показать полученный результат. Источник - лекция16.ppt

## Задание 20.
Разработать приложение, получающее GPS-координаты устройства и отслеживающее их изменение. Приложение состоит из трёх textView: 2 отображают широту и долготу устройства, третье - статус подключения GPS датчика (GPS датчик включён, GPS датчик выключен).Источник - лекция2.ppt (там есть пример исходного кода)

## Задание 21.
Разработать собственную галерею, содержащую отображение общего числа фотографий в папке и текущего номера фотографии, саму текущую фотографию и навигацию по фотографиям (кнопки вперёд + назад, или стрелки в виде imageButton, или что-то ещё). Можно дополнить этот убогий интерфейс дополнительными возможностями: линейкой маленьких фотографий под большой просматриваемой, возможностью зума просматриваемой фотографии и т.д.Источник - лекция17.ppt

## Задание 22.
Разработать приложение-записную книжку, где можно добавлять, удалять или редактировать новые контакты (имя, телефон, комментарий) и звонить им или отправлять sms. основная идея приложения - как можно быстрее (в минимум тэпов по экрану) позвонить или отправить sms определённому контакту, т.е. главное окно приложения содержит список контактов и 2 кнопки справа (в виде картинок) - звонок, sms. Источник - лекция19.ppt

## Задание 23.
Разработать приложение, работающее с распознаванием звука с помощью голосового движка (Google). Приложение содержит кнопку и textView, кнопка активирует голосовой ввод, textView отображает результат распознавания. В textView должны сохраняться результаты предыдущих распознаваний (сколько раз нажали кнопку, столько и результатов на экране). Источник - лекция20.ppt
