package com.example.work;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Button button;
    boolean notEmpty = false;

    protected String editString;
    protected String editString2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText1 = findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit2);
        button = findViewById(R.id.button_log);
        editString = editText1.getText().toString();
        editString2 = editText2.getText().toString();

        editText2.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        button.setBackgroundColor(Color.YELLOW);

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (s.toString().isEmpty()) {
                            button.setBackgroundColor(Color.GRAY);
                            notEmpty = false;
                        } else {
                            notEmpty = true;
                            button.setEnabled(true);
                        }
                    }
                });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (notEmpty) {
                    if (!TextUtils.isEmpty(editText1.getText().toString()) && !TextUtils.isEmpty(editText2.getText().toString())) {
                        Intent intent = new Intent(LoginActivity.this, Calculator.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
