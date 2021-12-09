package com.example.taskeight

import com.example.taskeight.R
import android.app.Activity
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RemoteViews
import com.example.taskeight.databinding.LinkedWidgetConfigureBinding

/**
 * The configuration screen for the [LinkedWidget] AppWidget.
 */
class LinkedWidgetConfigureActivity : Activity() {
    private lateinit var context: LinkedWidgetConfigureActivity
    private var widgetID: Int = 0

    public override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.linked_widget_configure)
        setResult(RESULT_CANCELED)
        context = this
        val extras = intent.extras

        if (extras != null) {
            widgetID = extras.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
            val widgetManager = AppWidgetManager.getInstance(context)
            val views = RemoteViews(context.packageName, R.layout.linked_widget)
            val editText: EditText = findViewById<View>(R.id.appwidget_text) as EditText
            val button: Button = findViewById<View>(R.id.add_button) as Button

            button.setOnClickListener() {

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(editText.getText().toString())
                )

                val pending: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
                views.setOnClickPendingIntent(R.id.appwidget_text, pending);
                widgetManager.updateAppWidget(widgetID, views);
                val resultValue: Intent = Intent();

                resultValue.putExtra(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    widgetID
                );

                setResult(RESULT_OK, resultValue);
                finish();
            }
        }
    }

}
