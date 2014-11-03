package com.example.test.tenettorchapplication;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RemoteViews;

import com.example.test.tenettorchapplication.R;

public class Main extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int i = 0; i < appWidgetIds.length; i++)
        {
            int appWidgetId = appWidgetIds[i];

            Intent intent = new Intent(context, Widgetservice.class);
            PendingIntent pendingIntent = PendingIntent.getService(context, 0,
                    intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.activity_main);
            views.setOnClickPendingIntent(R.id.Site, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }


    }



}
