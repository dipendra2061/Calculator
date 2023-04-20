package com.example.calculatorusingfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    Button sum;

    Button diff;

    Button product;

    Button fraction;
    ResultFragment fragComp;

    int a;
    int b;

    int ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        fragComp = new ResultFragment();

        if(savedInstanceState==null){
            Bundle bundle = new Bundle();
            bundle.putInt("key" , ans);
            getSupportFragmentManager().beginTransaction().replace(R.id.resultfragment,fragComp).commit();
        }


        sum = findViewById(R.id.add);
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(num1.getText().toString());
                b = Integer.parseInt(num2.getText().toString());
                ans=a+b;
                fragComp.getData(String.valueOf(ans));
                InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(num1.getWindowToken(),0);

            }
        });

        diff = findViewById(R.id.sub);
        diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(num1.getText().toString());
                b = Integer.parseInt(num2.getText().toString());
                ans=a-b;
                fragComp.getData(String.valueOf(ans));
            }
        });

        product = findViewById(R.id.mul);
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(num1.getText().toString());
                b = Integer.parseInt(num2.getText().toString());
                ans=a*b;
                fragComp.getData(String.valueOf(ans));
            }
        });

        fraction = findViewById(R.id.div);
        fraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Integer.parseInt(num1.getText().toString());
                float b = Integer.parseInt(num2.getText().toString());
                float ans=a/b;
                fragComp.getData(String.valueOf(ans));
            }
        });



    }
}