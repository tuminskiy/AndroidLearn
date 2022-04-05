package ru.mirea.tuminskiy.loadermanager;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyLoader extends AsyncTaskLoader<String> {
    private String text;
    public static final String ARG_WORD = "word";

    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);

        if (args != null)
            text = args.getString(ARG_WORD);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        List<String> letters = Arrays.asList(text.split(""));

        Collections.shuffle(letters);

        String result = "";
        for (String letter : letters) {
            result += letter;
        }

        return result;
    }
}