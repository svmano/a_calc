package com.homefinch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    String op = "";
    String oldNumber = "";
    boolean isNew = true;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.text);
    }

    public void numberEvent(View view) {
        if(isNew) {
            ed1.setText("");
        }
        isNew = false;
        String number = ed1.getText().toString();

        switch(view.getId()) {
            case R.id.bu1:
                number += ("1");
                break;
            case R.id.bu2:
                number += "2";
                break;
            case R.id.bu3:
                number += "3";
                break;
            case R.id.bu4:
                number += "4";
                break;
            case R.id.bu5:
                number += "5";
                break;
            case R.id.bu6:
                number += "6";
                break;
            case R.id.bu7:
                number += "7";
                break;
            case R.id.bu8:
                number += "8";
                break;
            case R.id.bu9:
                number += "9";
                break;
            case R.id.bu0:
                number += "0";
                break;
        }

        ed1.setText(number);

    }

    public void DotEvent(View view) {
        if(isNew) {
            ed1.setText("");
        }
        isNew = false;
        String number = ed1.getText().toString();
        switch(view.getId()) {
             case R.id.budot:

                if(number.isEmpty())
                    number = "0";
                if(number.contains("."))
                    break;
                number += ".";
                break;

        }

        ed1.setText(number);

    }
    public void PlusMinusEvent(View view)
    {
        String number = ed1.getText().toString();
        switch(view.getId()) {
            case R.id.buplusminus:
                if (number.contains("-")) {
                    number = number.substring(1);
                }
                else if(number.compareTo("0") == 0)
                    break;
                else {
                    number = "-" + number;
                }
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view)
    {
        isNew = true;
        oldNumber = ed1.getText().toString();
        switch(view.getId())
        {
            case R.id.buplus:
                op = "+";
                break;
            case R.id.buminus:
                op = "-";
                break;
            case R.id.budivide:
                op = "/";
                break;
            case R.id.bumultiply:
                op = "X";
                break;
        }
        //ed1.setText("");
    }

    public void EqualEvent(View view) {
        isNew = true;
        String newNumber = ed1.getText().toString();
        try {
                Double result = Double.parseDouble(newNumber);

                switch (op) {
                    case "+":
                        result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                        break;
                    case "-":
                        result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                        break;
                    case "X":
                        result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                        break;
                    case "/":
                        result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                        break;
                    default:

                }

                String temp = result.toString();
                if(temp.endsWith("0"))
                    ed1.setText(temp.substring(0,temp.length()-2));
                else {
                    if (temp.contains(".")) {
                        DecimalFormat myDecimalFormat = new DecimalFormat("0.00");
                        temp = myDecimalFormat.format(result);
                        ed1.setText(temp);
                    }
                }

            } catch (NumberFormatException e) {
                ed1.setText("");
            }
            newNumber = "";
            oldNumber = "";
            op = "";

    }

    public void ACEvent(View view) {
        ed1.setText("0");
        isNew = true;
    }

    public void percentEvent(View view) {
        double percent = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(percent+"");
        isNew = true;
    }
}