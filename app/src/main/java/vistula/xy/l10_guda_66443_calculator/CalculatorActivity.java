package vistula.xy.l10_guda_66443_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    public EditText num1Val, num2Val;
    public TextView resultVw, vw1base10, vw2base10, valfrmSpiner1, resultVwbse10, vw_base2, vw_base3, valfromSpiner2, resultVw3;
    public Spinner spinnerBase, spinnerCalculation, spinnerBase2;
    public Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        num1Val = findViewById(R.id.num1_val_id);
        num2Val = findViewById(R.id.num2_val_id);
        resultVw = findViewById(R.id.result1_vw_id);
        vw1base10 = findViewById(R.id.vw1_base_10);
        vw2base10 = findViewById(R.id.vw2_base10_id);
        valfrmSpiner1 = findViewById(R.id.cal_val_from_spinner1_id);
        resultVwbse10 = findViewById(R.id.result_vw_base10);
        spinnerBase = findViewById(R.id.spinner_base_id);
        spinnerCalculation = findViewById(R.id.spinner_calc_id);
        spinnerBase2 = findViewById(R.id.spinner_base_id2);
        vw_base2 = findViewById(R.id.vw1_base_2);
        vw_base3 = findViewById(R.id.vw2_base10_id3);
        valfromSpiner2 = findViewById(R.id.cal_val_from_spinner1_id3);
        resultVw3 = findViewById(R.id.result_vw_base);
        calculate = findViewById(R.id.calculate_btn_id);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
                calculateBase10();
                calculateBase_2();
            }
        });

    }

    private void calculateResult() {
        String operation = spinnerCalculation.getSelectedItem().toString();
        int base = getSelectedBase();
        int num1 = Integer.parseInt((num1Val.getText().toString()), base);
        int num2 = Integer.parseInt((num2Val.getText().toString()), base);
        String result = null;


        switch (operation) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;

            case "-":
                result = String.valueOf(num1 - num2);
                break;

            case "*":
                result = String.valueOf(num1 * num2);
                break;
            case "/":
                if(num2 != 0) {
                    result =  String.valueOf(num1 / num2);
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    break;
                }
        }
        resultVw.setText(result);
    }

    private int getSelectedBase(){
        String selectedBase = spinnerBase.getSelectedItem().toString();


        switch (selectedBase) {
            case "2":
                return 2;
            case "8":
                return 8;
            case "16":
                return 16;
            default:
                return 10;
        }

    }

    private int getSelectedBase2(){
        String selectedBase = spinnerBase2.getSelectedItem().toString();


        switch (selectedBase) {
            case "2":
                return 2;
            case "8":
                return 8;
            case "16":
                return 16;
            default:
                return 10;
        }

    }



    private void calculateBase10(){
        int base = 10;
        int num1 = Integer.parseInt((num1Val.getText().toString()), base);
        int num2 = Integer.parseInt((num2Val.getText().toString()), base);
        vw1base10.setText(String.valueOf(num1));
        vw2base10.setText(String.valueOf(num2));
        String operation = spinnerCalculation.getSelectedItem().toString();
        valfrmSpiner1.setText(operation);
        String result = null;
        switch (operation) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;

            case "-":
                result = String.valueOf(num1 - num2);
                break;

            case "*":
                result = String.valueOf(num1 * num2);
                break;
            case "/":
                if(num2 != 0) {
                    result =  String.valueOf(num1 / num2);
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    break;
                }
        }

        resultVwbse10.setText(result);

    }

    private void calculateBase_2(){
        int base = getSelectedBase2();
        int num1 = Integer.parseInt((num1Val.getText().toString()), base);
        int num2 = Integer.parseInt((num2Val.getText().toString()), base);
        vw_base2.setText(String.valueOf(num1));
        vw_base3.setText(String.valueOf(num2));
        String operation = spinnerCalculation.getSelectedItem().toString();
        valfromSpiner2.setText(operation);
        String result = null;
        switch (operation) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;

            case "-":
                result = String.valueOf(num1 - num2);
                break;

            case "*":
                result = String.valueOf(num1 * num2);
                break;
            case "/":
                if(num2 != 0) {
                    result =  String.valueOf(num1 / num2);
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    break;
                }
        }

        resultVw3.setText(result);

    }



}