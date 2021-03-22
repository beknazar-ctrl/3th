package com.example.work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    TextView txtFirst, txtSecond, txtThird;
    Button b1, b2;
    Button plus;
    Button equally;
    int number;
    int second;

    boolean plusOperation = false;

    private boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        txtFirst = findViewById(R.id.txtFirst);
        txtSecond = findViewById(R.id.txtSecond);
        txtThird = findViewById(R.id.txtThird);
        b1 = findViewById(R.id.first);
        b2 = findViewById(R.id.second);
        plus = findViewById(R.id.plus);
        equally = findViewById(R.id.equally);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isClicked) {
                    txtFirst.setText(txtFirst.getText().toString() + b1.getText().toString());
                } else if (isClicked) {
                    txtThird.setText(txtThird.getText().toString() + b1.getText().toString());
//                     }

                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClicked = true;
                plusOperation = true;
                txtSecond.setText(plus.getText().toString());
            }
        });


        equally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Integer.parseInt(txtFirst.getText().toString());
                second = Integer.parseInt(txtThird.getText().toString());


                if (plusOperation) {
                    txtThird.setText("" + (number + second));


                }


            }
        });


    }


}
