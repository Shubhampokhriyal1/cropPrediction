package com.example.agroboost;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView resultTv,solutionTv;
    MaterialButton [] arr=new MaterialButton[20];
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv=findViewById(R.id.result_tv);
        solutionTv=findViewById(R.id.solution_tv);
        assignID(arr[0],R.id.button_0);
        assignID(arr[1],R.id.button_1);
        assignID(arr[2],R.id.button_2);
        assignID(arr[3],R.id.button_3);
        assignID(arr[4],R.id.button_4);
        assignID(arr[5],R.id.button_5);
        assignID(arr[6],R.id.button_6);
        assignID(arr[7],R.id.button_7);
        assignID(arr[8],R.id.button_8);
        assignID(arr[9],R.id.button_9);
        assignID(arr[10],R.id.button_c);
        assignID(arr[11],R.id.button_bracop);
        assignID(arr[12],R.id.button_bracclo);
        assignID(arr[13],R.id.button_eq);
        assignID(arr[14],R.id.button_X);
        assignID(arr[15],R.id.button_Div);
        assignID(arr[16],R.id.button_add);
        assignID(arr[17],R.id.button_sub);
        assignID(arr[18],R.id.button_del);
        assignID(arr[19],R.id.button_dec);
    }
    void assignID(MaterialButton b,int id){
        b=findViewById(id);
        b.setOnClickListener(this);
    }
    String calculate(String str) {
        try {
            // will get all numbers and store it to `numberStr`
            String numberStr[] = str.replaceAll("[+*/()-]+", " ").split(" ");
            // will get all operators and store it to `operatorStr`
            String operatorStr[] = str.replaceAll("[0-9()]+", "").split("");

            Double total = Double.parseDouble(numberStr[0]);

            for (int i = 0; i < operatorStr.length; i++) {
                switch (operatorStr[i]) {
                    case "+":
                        total += Double.parseDouble(numberStr[i + 1]);
                        break;
                    case "-":
                        total -= Double.parseDouble(numberStr[i + 1]);
                        break;
                    case "*":
                        total *= Double.parseDouble(numberStr[i + 1]);
                        break;
                    case "/":
                        total /= Double.parseDouble(numberStr[i + 1]);
                        break;
                }

                if (i + 2 >= operatorStr.length) continue; // if meets the last operands already
                numberStr[i + 1] = String.valueOf(total);

            }
            return String.valueOf(total);
        }
        catch (Exception e){
            return "MATH ERROR";
        }
    }

    @Override
    public void onClick(View view) {
        MaterialButton button=(MaterialButton)  view;
        String btntext=button.getText().toString();

        String calculation= solutionTv.getText().toString();
        if(button.getId() == R.id.button_eq){
            calculation=calculate(calculation);
            solutionTv.setText("0");
            resultTv.setText(calculation);
        }
        else{
            String ac="AC";
            if(button.getId()==R.id.button_c){
                calculation="0";
                solutionTv.setText(calculation);
            }
            else if(button.getId()==R.id.button_del){
                int l=calculation.length();
                calculation=calculation.substring(0,l-1);
                solutionTv.setText(calculation);
            }
            else if(button.getId()==R.id.button_X){
                calculation=calculation+"*";
                solutionTv.setText(calculation);
            }
            else{
                if(calculation.equals("0"))
                    solutionTv.setText(btntext);
                else{
                    solutionTv.setText(calculation+btntext);
                }
            }
        }
    }
}