package ru.mirea.tuminskiy.dialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowDialog(View v) {
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onClickTimerDialog(View v) {
        TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.d("timer", "Time is " + hourOfDay + " hours " + minute + " minutes");
            }
        };

        TimePickerDialogFragment dialogFragment = new TimePickerDialogFragment(
                this, myCallBack, 0,0 ,true);
        dialogFragment.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClickDateDialog(View v) {
        DatePickerDialogFragment dialogFragment = new DatePickerDialogFragment(this);
        dialogFragment.show();
    }

    public void onClickProgressDialog(View v) {
        ProgressDialogFragment dialogFragment = new ProgressDialogFragment(this);
        dialogFragment.show();
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
            Toast.LENGTH_LONG).show();
    }

    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
            Toast.LENGTH_LONG).show();
    }

    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }
}