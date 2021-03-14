package com.learning.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.learning.tictactoe.MainActivity;

public class splash extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemClock.sleep(1000);
        startActivity(new Intent(this, MainActivity.class));
    }
}
