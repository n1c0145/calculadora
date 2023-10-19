package com.eduardoloza.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    /**
     * Declaracion variables
     */
    private Button buttonCe,buttonC,buttonDash,buttonResult,buttonX,buttonPlus,buttonSlash,buttonPoint,button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    private EditText display;
    private double currentValue = 0;
    private String operation = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/**
 * Evento pasar num de boton a display
 */
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button clickedButton = (Button) view;
                String number = clickedButton.getText().toString();
                addToDisplay(number);
            }
        };

        buttonCe= findViewById(R.id.buttonCe);
        buttonC=findViewById(R.id.buttonC);
        buttonPoint = findViewById(R.id.buttonPoint);
        buttonX= findViewById(R.id.buttonX);
        buttonPlus= findViewById(R.id.buttonPlus);
        buttonDash = findViewById(R.id.buttonDash);
        buttonSlash = findViewById(R.id.buttonSlash);
        buttonResult = findViewById(R.id.buttonResult);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2= findViewById(R.id.button2);
        button3= findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6= findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button9 = findViewById(R.id.button9);
        display = findViewById(R.id.display);

        buttonCe.setOnClickListener(view->resetAll());
        buttonC.setOnClickListener(view->resetDisplay());
        buttonResult.setOnClickListener(view->calculate());
        buttonDash.setOnClickListener(view -> setOPeration("-"));
        buttonSlash.setOnClickListener(view -> setOPeration("/"));
        buttonX.setOnClickListener(view -> setOPeration("*"));
        buttonPlus.setOnClickListener(view -> setOPeration("+"));
        buttonPoint.setOnClickListener(numberClickListener);
        button0.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);
    }
    /**
     * Añade al display el numero que se presiono
     * @param number
     */
    public void addToDisplay(String number){
        String currentVal = this.display.getText().toString();
        if (currentVal.equals("0")){
            this.display.setText(number);
            return;
        }
        if (currentVal.contains(".") && number.equals("."))
            return;
        this.display.setText(currentVal+number);
    }
    /**
     * Guardar operador
     * @param op
     */
    private void setOPeration(String op){
        this.currentValue = Double.parseDouble(this.display.getText().toString());
        this.display.setText("0");
        this.operation=op;
    }

    /**
     * Realizar el calculo segun operador
     */
    private void calculate(){
    double secondValue = Double.parseDouble(this.display.getText().toString());
    double result = 0;
    switch (this.operation){
        case "+":
            result = this.currentValue+secondValue;
            break;
        case "-":
            result = this.currentValue-secondValue;
            break;
        case "*":
            result = this.currentValue*secondValue;
            break;
        case "/":
            result = this.currentValue/secondValue;
            break;
    }
    display.setText(String.valueOf(result));
    this.currentValue=result;
    }
    /**
     * Resetear calculadora
     */
    private void resetAll(){
        display.setText("0");
        currentValue=0;
        operation = "";
    }
    /**
     * Reseteo display
     */
    private void resetDisplay(){
        display.setText("0");
    }
}