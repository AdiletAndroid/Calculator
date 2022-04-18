package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson2_7.R;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.policies);
        button = findViewById(R.id.red_btn);
        button.setOnClickListener(view -> {
            finishAffinity();
        });

        Intent intent = getIntent();
        int result = intent.getIntExtra("result", 0);

        textView.setText(String.valueOf(result));
    }
}