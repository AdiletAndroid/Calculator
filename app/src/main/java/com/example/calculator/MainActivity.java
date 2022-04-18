package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson2_7.R;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer firstVar, secondVar;
    private boolean isOperationClick;
    private String operation;
    private Integer result;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.appearing_btn);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("result", result);
            startActivity(intent);
        });
    }

    public void onNumberClick(View view) {
        button.setVisibility(View.GONE);
        switch (view.getId()) {
            case R.id.one:
                updateNumber("1");
                break;
            case R.id.two:
                updateNumber("2");
                break;
            case R.id.three:
                updateNumber("3");
                break;
            case R.id.four:
                updateNumber("4");
                break;
            case R.id.five:
                updateNumber("5");
                break;
            case R.id.six:
                updateNumber("6");
                break;
            case R.id.seven:
                updateNumber("7");
                break;
            case R.id.eight:
                updateNumber("8");
                break;
            case R.id.nine:
                updateNumber("9");
                break;
            case R.id.zero:
                updateNumber("0");
                break;
            case R.id.clear:
                textView.setText("0");
                firstVar = 0;
                secondVar = 0;
                break;

        }
    }

    private void updateNumber(String newNumber) {
        if (textView.getText().toString().equals("0")) {
            textView.setText(newNumber);
        } else if (isOperationClick) {
            textView.setText(newNumber);
        } else {
            textView.append(newNumber);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                updateOperation("+");
                button.setVisibility(View.GONE);
                break;
            case R.id.minus:
                updateOperation("-");
                button.setVisibility(View.GONE);
                break;
            case R.id.division:
                updateOperation("/");
                button.setVisibility(View.GONE);
                break;
            case R.id.multiplication:
                updateOperation("*");
                button.setVisibility(View.GONE);
                break;

            case R.id.equals:
                secondVar = Integer.parseInt(textView.getText().toString());
                result = 0;
                calculate();
                isOperationClick = true;
                button.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void calculate() {
        if (operation == null) {
            return;
        }
        switch (operation) {
            case "+":
                result = firstVar + secondVar;
                textView.setText(result.toString());
                break;
            case "-":
                result = firstVar - secondVar;
                textView.setText(result.toString());
                break;
            case "*":
                result = firstVar * secondVar;
                textView.setText(result.toString());
                break;
            case "/":
                result = firstVar / secondVar;
                textView.setText(result.toString());
        }
    }

    private void updateOperation(String newOperation) {
        operation = newOperation;
        firstVar = Integer.parseInt(textView.getText().toString());
        isOperationClick = true;
    }
}