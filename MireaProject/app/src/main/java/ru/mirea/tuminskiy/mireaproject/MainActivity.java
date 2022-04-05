package ru.mirea.tuminskiy.mireaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.tuminskiy.mireaproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private Double mLhsValue;
    private Double mRhsValue;
    private String mOp;
    private boolean mIsNextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_browser,
                R.id.nav_calc, R.id.nav_music)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onClickNumber(View v) {
        TextView tvResult = findViewById(R.id.tvResult);

        String value = ((Button)v).getText().toString();

        if (tvResult.getText().toString().equals("0") || mIsNextValue) {
            tvResult.setText(value);
            mIsNextValue = false;
        } else {
            tvResult.append(value);
        }
    }

    public void onClickOperation(View v) {
        TextView tvResult = findViewById(R.id.tvResult);

        String op = ((Button)v).getText().toString();

        switch (op) {
            case "AC": {
                tvResult.setText("0");
                clear();
            } break;
            case "=": {
                if (mLhsValue != null) {
                    mRhsValue = Double.parseDouble(tvResult.getText().toString());
                    calc();
                }
            } break;
            default: {
                mIsNextValue = true;
                mLhsValue = Double.parseDouble(tvResult.getText().toString());
                mOp = op;
            }
        }
    }

    private void calc() {
        TextView tvResult = findViewById(R.id.tvResult);
        Double value = null;
        
        switch (mOp) {
            case "+": value = mLhsValue + mRhsValue; break;
            case "-": value = mLhsValue - mRhsValue; break;
            case "*": value = mLhsValue * mRhsValue; break;
            case "/": value = mLhsValue / mRhsValue; break;
        }

        tvResult.setText(value.toString());
        clear();
    }
    
    private void clear() {
        mLhsValue = null;
        mRhsValue = null;
        mOp = null;
    }

    public void onClickPlayMusic(View view) {
        startService(new Intent(MainActivity.this, PlayerService.class));
    }
    public void onClickStopMusic(View view) {
        stopService(new Intent(MainActivity.this, PlayerService.class));
    }
}