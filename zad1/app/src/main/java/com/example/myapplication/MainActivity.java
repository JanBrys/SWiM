package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    public static final String EXTRA_RESULT = "QWERTY";
    int weight,height,bmi;
    boolean isMetric = false;
    EditText weightInput;
    EditText heightInput;
    TextView resultOutput;
    Button confirmResult;
    Switch unitsSwitch;

    String metric = "Ustawiono obliczanie BMI na jednostki metryczne";
    String nonMetric = "Ustawiono obliczanie BMI na jednostki brytyjskie";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = (EditText) findViewById(R.id.edit_weight);
        heightInput = (EditText) findViewById(R.id.edit_height);

        resultOutput = (TextView) findViewById(R.id.text_final_result);

        unitsSwitch = (Switch) findViewById(R.id.switch_units);

        confirmResult = (Button) findViewById(R.id.button_result);

        unitsSwitch.setOnCheckedChangeListener(this);

        confirmResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = Integer.valueOf(weightInput.getText().toString());
                height = Integer.valueOf(heightInput.getText().toString());
                bmi = calculateBMI(weight,height);
                resultOutput.setText(String.valueOf(bmi));
                System.out.print(bmi);
                sendResult();
            }
        });

        resultOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
        {
            isMetric = true;
            Toast.makeText(MainActivity.this,metric,Toast.LENGTH_LONG).show();
        }
        else
        {
            isMetric = false;
            Toast.makeText(MainActivity.this,nonMetric,Toast.LENGTH_LONG).show();
        }
    }


    public int calculateBMI(int weight,int height)
    {
        if(isMetric = true)
        {
            return weight / ( (height*height)/10000 );
        }
        else
        {
            return (weight/((height*height)/10000 ))*703;
        }
    }

    public void sendResult()
    {
        Intent intent = new Intent(this,Result.class);
        String resultToSend = resultOutput.getText().toString();
        intent.putExtra(EXTRA_RESULT,resultToSend);
        startActivity(intent);
    }
}
