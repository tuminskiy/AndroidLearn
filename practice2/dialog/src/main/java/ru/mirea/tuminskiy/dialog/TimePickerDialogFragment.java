package ru.mirea.tuminskiy.dialog;

import android.app.TimePickerDialog;
import android.content.Context;

public class TimePickerDialogFragment extends TimePickerDialog {
    public TimePickerDialogFragment(Context context,
                                    OnTimeSetListener listener,
                                    int hourOfDay,
                                    int minute,
                                    boolean is24HourView) {
        super(context, listener, hourOfDay, minute, is24HourView);
    }
}
