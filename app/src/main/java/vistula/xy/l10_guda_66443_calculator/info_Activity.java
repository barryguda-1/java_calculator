package vistula.xy.l10_guda_66443_calculator;

import androidx.appcompat.app.AppCompatActivity;
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

public class info_Activity extends AppCompatActivity {

    private TextView fnameVw, lnameVw;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        fnameVw = findViewById(R.id.fname_to_view_id);
        lnameVw = findViewById(R.id.lname_to_vw_id);
        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_intent = new Intent(info_Activity.this, MainActivity.class);
                startActivity(main_intent);

            }

        });

        readFromFile();
    }

    private void readFromFile() {
        try {
            String data_from_file;
            // Create a FileInputStream to read from the file
            FileInputStream fis = openFileInput("user_Data.txt");

            //Create an InputStreamReader to handle character encoding
            InputStreamReader isr = new InputStreamReader(fis);

            BufferedReader br = new BufferedReader(isr);

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            fis.close();
            data_from_file = stringBuilder.toString();
            String[] dataArray = data_from_file.split(" ");
            fnameVw.setText(data_from_file);
            if(dataArray.length != 0){
                String variable1 = dataArray[0].trim();
                //System.out.println(variable1);
                fnameVw.setText(variable1);
                String variable2 = dataArray[1].trim();
                //System.out.println(variable2);
                lnameVw.setText(variable2);
            }else {
                Toast.makeText(this, "Data Length less than 3", Toast.LENGTH_SHORT).show();
            }
            //fnameVw.setText(stringBuilder.toString());

            //Toast.makeText(this, "Data read from file successfully", Toast.LENGTH_SHORT).show();


        } catch (IOException e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}