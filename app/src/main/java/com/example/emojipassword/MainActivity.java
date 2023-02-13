package com.example.emojipassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void emojiOnly(View view) {
        Intent i = new Intent(MainActivity.this,emojiActivity.class); //切换窗口
        startActivity(i);
    }
    public void Mix(View view) {
        Intent i = new Intent(MainActivity.this,Mix.class); //切换窗口
        startActivity(i);
    }
}