package com.sahsisunny.accountinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText accno, bankname, ifsc;
    Button clear, done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accno = findViewById(R.id.accnum);
        bankname = findViewById(R.id.bankname);
        ifsc = findViewById(R.id.ifsccode);
        clear = findViewById(R.id.clear);
        done = findViewById(R.id.done);

        ifsc.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String ifscCode = ifsc.getText().toString();
                if (ifscCode.isEmpty()) {
                    ifsc.setError("IFSC Code is required");
                }
            }
        });
        bankname.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String bankName = bankname.getText().toString();
                if (bankName.isEmpty()) {
                    bankname.setError("Bank name is required");
                }
            }
        });
        accno.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String accNum = accno.getText().toString();
                if (accNum.isEmpty()) {
                    accno.setError("Account Number is required");
                }
            }
        });


        // clear button is to clear all the fields
        clear.setOnClickListener(v -> {
            accno.setText("");
            bankname.setText("");
            ifsc.setText("");
        });

        // done button is to save the data
        done.setOnClickListener(v -> {
            // share the data
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Account Number: " + accno.getText().toString() + "\nBank Name: " + bankname.getText().toString() + "\nIFSC Code: " + ifsc.getText().toString());
            startActivity(Intent.createChooser(intent, "Share Account Info"));
        });
    }
}