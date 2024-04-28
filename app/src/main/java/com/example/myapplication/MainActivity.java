package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    ImageView button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    ImageView button_c, button_dot, button_sub, button_plus, button_per, button_mod, button_equal, button_mul;
    TextView inputTxt, outputTxt;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputTxt=findViewById(R.id.outputTxt);
        inputTxt=findViewById(R.id.inputTxt);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        button_c=findViewById(R.id.button_c);
        button_dot=findViewById(R.id.button_dot);
        button_sub=findViewById(R.id.button_sub);
        button_plus=findViewById(R.id.button_plus);
        button_per=findViewById(R.id.button_per);
        button_mod=findViewById(R.id.button_mod);
        button_equal=findViewById(R.id.button_equal);
        button_mul=findViewById(R.id.button_mul);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"9");
            }
        });



        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText("");
                outputTxt.setText("");
            }
        });
        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+".");
            }
        });
        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"-");
            }
        });
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"+");
            }
        });
        button_per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"/");
            }
        });
        button_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"%");
            }
        });
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"*");
            }
        });
        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                data=inputTxt.getText().toString();
                data=data.replaceAll("=","*");
                data=data.replaceAll("%","/100");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";

                Scriptable scriptable=rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"Javsscript",1,null).toString();
                outputTxt.setText(finalResult);
            }
        });



    }

}
