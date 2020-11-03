package com.example.realtimecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    TextView textViewResult, textViewHistory;
    Button zero, one, two, three, four, five, six, seven, eight, nine,
            addition, subtraction, multiplication, division, decimalPoint,
            root, square, clear , equal;

    double resutl =0;
    String temp="0";
    String operator = "" ;
    String historyText ="" ;
    boolean decimalPointUsed = false;
    boolean firstInput = true;
    boolean arithAttempted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewRESULT);
        textViewHistory = findViewById(R.id.textViewResulHistory);

        zero = findViewById(R.id.buttonZEOR);
        zero.setOnClickListener(this);
        one = findViewById(R.id.buttonONE);
        one.setOnClickListener(this);
        two = findViewById(R.id.buttonTWO);
        two.setOnClickListener(this);
        three = findViewById(R.id.buttonThree);
        three.setOnClickListener(this);
        four = findViewById(R.id.buttonFOUR);
        four.setOnClickListener(this);
        five = findViewById(R.id.buttonFIVE);
        five.setOnClickListener(this);
        six = findViewById(R.id.buttonSIX);
        six.setOnClickListener(this);
        seven = findViewById(R.id.buttonSEVEN);
        seven.setOnClickListener(this);
        eight = findViewById(R.id.buttonEIGHT);
        eight.setOnClickListener(this);
        nine = findViewById(R.id.buttonNINE);
        nine.setOnClickListener(this);

        addition = findViewById(R.id.buttonAddition);
        addition.setOnClickListener(this);
        subtraction = findViewById(R.id.buttonMin);
        subtraction.setOnClickListener(this);
        multiplication = findViewById(R.id.buttonMULTI);
        multiplication.setOnClickListener(this);
        division = findViewById(R.id.buttonDIV);
        division.setOnClickListener(this);
        decimalPoint = findViewById(R.id.buttonPoint);
        decimalPoint.setOnClickListener(this);

        root = findViewById(R.id.buttonROOT);
        root.setOnClickListener(this);
        square = findViewById(R.id.buttonSQUARE);
        square.setOnClickListener(this);
        clear = findViewById(R.id.buttonClear);
        clear.setOnClickListener(this);
        equal = findViewById(R.id.buttonEqual);
        equal.setOnClickListener(this);

    }

    double getResutl(String historyText){

        Log.i(TAG, "getResutl: "+ historyText);
        String num="";
        double sum=0;
        for (int i=0; i< historyText.length(); i++){
            char c =historyText.charAt(i);

            switch (c){
                case '+':
                    if (num.length()==0) continue;;
                    i+=1;
                    sum+=Double.parseDouble(num);
                    num="";
                    break;
                case '-':
                    if (num.length()==0) continue;;
                    i+=1;
                    sum-=Double.parseDouble(num);
                    num="";
                    break;
                case '*':
                    if (num.length()==0) continue;;
                    i+=1;
                    sum*=Double.parseDouble(num);
                    num="";
                    break;

                case '/':
                    if (num.length()==0) continue;;
                    i+=1;
                    sum/=Double.parseDouble(num);
                    num="";
                    break;

                default:
                    num+=""+c;
                    Log.i(TAG, "getResutl: num"+ num);

            }
        }

        return  sum;
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id ==R.id.buttonClear){
            textViewHistory.setText("");
            historyText ="";
            temp = "";
            firstInput =true;
            resutl =0;
            textViewResult.setText("");
        }

        else if (id ==R.id.buttonEqual || id == R.id.buttonAddition || id== R.id.buttonMin || id == R.id.buttonMULTI || id == R.id.buttonDIV){
             if (!temp.isEmpty() ) {

                 if(firstInput) {
                     resutl = Double.parseDouble(temp);
                     firstInput = false;
                 }
                else if(operator.equals("+"))
                    resutl += Double.parseDouble(temp);
                else if(operator.equals("-"))
                    resutl -= Double.parseDouble(temp);
               else if(operator.equals("*"))
                    resutl *= Double.parseDouble(temp);
                else if(operator.equals("/"))
                    resutl /= Double.parseDouble(temp);
                else if (operator.equals("=")){

                }
                historyText = textViewHistory.getText().toString();
                historyText += temp;
                Log.i(TAG, "onClick: "+ historyText + "operator" +operator);
                operator= "";
            }

            if(id ==R.id.buttonAddition ){
                operator ="+";
            }
            else if(id == R.id.buttonMin){
                operator ="-";
            }
            else if(id == R.id.buttonMULTI ){
                operator = "*";
            }
            else if(id == R.id.buttonDIV){
                operator = "/";
            }
            else if(id== R.id.buttonEqual){
                operator="=";
            }
            textViewHistory.setText(historyText+operator);
            textViewResult.setText(resutl+"");
            temp="";
        }
        else{
            if (id== R.id.buttonONE) temp+="1";
            else if (id== R.id.buttonTWO) temp+="2";
            else if (id== R.id.buttonThree) temp +="3";
            else if (id == R.id.buttonFOUR) temp +="4";
            else if (id == R.id.buttonFIVE) temp +="5";
            else if (id == R.id.buttonSIX) temp +="6";
            else if (id == R.id.buttonSEVEN) temp += "7";
            else if (id == R.id.buttonEIGHT) temp += "8";
            else if (id == R.id.buttonNINE) temp +="9";
            else  if (id == R.id.buttonZEOR) temp +="0";
            else if (id ==R.id.buttonPoint) temp +=".";

            textViewResult.setText(temp+"");
        }

    }

}