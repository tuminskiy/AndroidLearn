package ru.mirea.tuminskiy.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity {
    private EditText etUniversity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        etUniversity = (EditText) findViewById(R.id.etUniversity);
    }

    public void onClickSend(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", etUniversity.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}