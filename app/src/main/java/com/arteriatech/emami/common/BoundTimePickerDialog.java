package com.arteriatech.emami.common;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

/**
 * Created by e10526 on 6/28/2017.
 */

public class BoundTimePickerDialog extends TimePickerDialog {

    private int minHour = -1, minMinute = -1, maxHour = 100, maxMinute = 100;

    private int currentHour, currentMinute;

    public BoundTimePickerDialog(Context context, OnTimeSetListener callBack, int hourOfDay, int minute, boolean is24HourView) {
        super(context, callBack, hourOfDay, minute, is24HourView);
    }

    public void setMin(int hour, int minute) {
        minHour = hour;
        minMinute = minute;
    }

    public void setMax(int hour, int minute) {
        maxHour = hour;
        maxMinute = minute;
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        super.onTimeChanged(view, hourOfDay, minute);

        boolean validTime;
        if (hourOfDay < minHour) {
            validTime = false;
        } else if (hourOfDay == minHour) {
            validTime = minute >= minMinute;
        } else if (hourOfDay == maxHour) {
            validTime = minute <= maxMinute;
        } else {
            validTime = true;
        }

        if (validTime) {
            currentHour = hourOfDay;
            currentMinute = minute;
        } else {
            updateTime(currentHour, currentMinute);
        }
    }
}
