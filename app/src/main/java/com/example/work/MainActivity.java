package com.example.work;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Button button;
    boolean notEmpty=false;

    protected String editString;
    protected String editString2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.edit1);
        editText2=findViewById(R.id.edit2);
        button=findViewById(R.id.button);
        editString=editText1.getText().toString();
        editString2 = editText2.getText().toString();



        editText2.addTextChangedListener(
                new TextWatcher(){

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        button.setBackgroundColor(Color.YELLOW);
                        button.setEnabled(true);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                       if(s == null){
                           button.setBackgroundColor(Color.GRAY);
                       }

                        }


                }
        );


        if (notEmpty){
            button.setBackgroundColor(Color.YELLOW);
        }


        button.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText1.getText().toString()) && !TextUtils.isEmpty(editText2.getText().toString())){
                    button.setBackgroundColor(Color.BLUE);
                }
            }
        });
    }

}
