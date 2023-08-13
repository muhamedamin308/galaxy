package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recycleview.databinding.ActivityLuncherScreenBinding;

import java.util.Objects;

public class LuncherScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLuncherScreenBinding binding = ActivityLuncherScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(LuncherScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 2500);
    }
}