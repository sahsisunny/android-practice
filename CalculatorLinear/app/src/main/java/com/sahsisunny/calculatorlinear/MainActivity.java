package com.sahsisunny.calculatorlinear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button add, sub, multi, division, equal;
    TextView result;
    float ans = 0;   // Global Variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        multi = findViewById(R.id.multi);
        division = findViewById(R.id.division);
        equal = findViewById(R.id.equal);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        add.setOnClickListener(v -> {
            String a = num1.getText().toString();
            String b = num2.getText().toString();
            if (a.isEmpty() || b.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter Number", Toast.LENGTH_SHORT).show();
            } else {
                float n1 = Float.parseFloat(a);
                float n2 = Float.parseFloat(b);
                ans = n1 + n2;
                String s = "Result : " + ans;
                result.setText(s);
            }
        });

        sub.setOnClickListener(v -> {
            String a = num1.getText().toString();
            String b = num2.getText().toString();
            if (a.isEmpty() || b.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter Number", Toast.LENGTH_SHORT).show();
            } else {
                float n1 = Float.parseFloat(a);
                float n2 = Float.parseFloat(b);
                ans = n1 - n2;
                String s = "Result : " + ans;
                result.setText(s);
            }
        });

        multi.setOnClickListener(v -> {
            String a = num1.getText().toString();
            String b = num2.getText().toString();
            if (a.isEmpty() || b.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter Number", Toast.LENGTH_SHORT).show();
            } else {
                float n1 = Float.parseFloat(a);
                float n2 = Float.parseFloat(b);
                ans = n1 * n2;
                String s = "Result : " + ans;
                result.setText(s);
            }
        });

        division.setOnClickListener(v -> {
            String a = num1.getText().toString();
            String b = num2.getText().toString();
            if (a.isEmpty() || b.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter Number", Toast.LENGTH_SHORT).show();
            } else {
                float n1 = Float.parseFloat(a);
                float n2 = Float.parseFloat(b);
                if (n2 == 0) {
                    Toast.makeText(getApplicationContext(), "Enter the valid number", Toast.LENGTH_SHORT).show();
                } else {
                    ans = n1 / n2;
                    String s = "Result : " + ans;
                    result.setText(s);
                }
            }
        });

        equal.setOnClickListener(v -> {
            String ans1 = String.valueOf(ans);
            String s = "Result : " + ans1;
            result.setText(s);
            ans = 0;
            // Clear text
            num1.setText("");
            num2.setText("");

        });
    }
}