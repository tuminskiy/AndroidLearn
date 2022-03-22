package ru.mirea.tuminskiy.dialog;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class DatePickerDialogFragment extends DatePickerDialog {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public DatePickerDialogFragment(@NonNull Context context) {
        super(context);
    }
}
