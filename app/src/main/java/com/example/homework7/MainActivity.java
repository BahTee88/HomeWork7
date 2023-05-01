package com.example.homework7;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private  Double first, second, result;
    View  nextMenu;
    private Boolean isOperationClick;
    private String operation;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        nextMenu = findViewById(R.id.next_menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        nextMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            String result = ((TextView) findViewById(R.id.text_view)).getText().toString();
            intent.putExtra("result",result);
            startActivity(intent);

        });
    }

    private void appendNumber(String number) {
        if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
    }

    public void onNumberClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_one) {
            nextMenu.setVisibility(View.INVISIBLE);
            appendNumber("1");
        } else if (id == R.id.btn_two) {
            appendNumber("2");
        } else if (id == R.id.btn_three) {
            appendNumber("3");
        } else if (id == R.id.btn_four) {
            appendNumber("4");
        } else if (id == R.id.btn_five) {
            appendNumber("5");
        } else if (id == R.id.btn_six) {
            appendNumber("6");
        } else if (id == R.id.btn_seven) {
            appendNumber("7");
        } else if (id == R.id.btn_eight) {
            appendNumber("8");
        } else if (id == R.id.btn_nine) {
            appendNumber("9");
        } else if (id == R.id.btn_zero) {
            appendNumber("0");
        } else if (id == R.id.btn_clear) {
            textView.setText("0");
            first = 0.0;
            second = 0.0;
        } else if (id == R.id.dot) {
            appendNumber(".");
        }
        isOperationClick = false;

    }

    @SuppressLint("NonConstantResourceId")
    public void onOperationClick(View view) {
        int id = view.getId();
        if (id == R.id.plusminus) {
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
            operation = "+/-";

        } else if (id == R.id.procent) {
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
            operation = "%";

        } else if (id == R.id.delenie) {
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
            operation = "/";

        } else if (id == R.id.umnojenie) {
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
            operation = "*";

        } else if (id == R.id.minus) {
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
            operation = "-";

        } else if (id == R.id.plus) {
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
            operation = "+";

        } else if (id == R.id.ravno) {
            if (!isOperationClick) {
                second = Double.parseDouble(textView.getText().toString());

                switch (operation) {
                    case "+/-":
                        result = first + second;
                        break;
                    case "%":
                        result = first % second;
                        break;
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                }
                textView.setText(new DecimalFormat("###.####").format(result));
                nextMenu.setVisibility(view.getVisibility());

            }
            isOperationClick = true;
        }
    }
}