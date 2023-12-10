 package vistula.xy.l10_guda_66443_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.content.Intent;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText fnameEditTxt, lnameEditTxt;
    private Button gotoCalcBtn, infoBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fnameEditTxt = findViewById(R.id.fname_editTxt_ID);
        lnameEditTxt = findViewById(R.id.lname_editTxt_ID);
        gotoCalcBtn = findViewById(R.id.goto_calc_btn);
        infoBtn = findViewById(R.id.info_btn);

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fData = fnameEditTxt.getText().toString();
                String lData = lnameEditTxt.getText().toString();
                writeToFile(fData, lData);
                Intent info_intent = new Intent(MainActivity.this, info_Activity.class);
                startActivity(info_intent);

            }

        });

        gotoCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cal_intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(cal_intent);
            }
        });
    }


    private void writeToFile(String data, String data_2) {
        try {
            FileOutputStream fos = openFileOutput("user_Data.txt", MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(data);
            osw.write(data_2);
            osw.flush();
            osw.close();
            //fos.close();
            Toast.makeText(this, "Data written to file successfully", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }
    }
}