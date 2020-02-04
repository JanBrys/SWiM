package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView bmi;
    TextView bmiResultInfo;
    TextView resultDetails;
    TextView resultDetailsAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String bmiResult = intent.getStringExtra(MainActivity.EXTRA_RESULT);

         bmi = findViewById(R.id.text_result);
        bmiResultInfo = findViewById(R.id.text_result_info);
        resultDetails = findViewById(R.id.text_result_details_);
        resultDetailsAge = findViewById(R.id.text_result_details_age);
        bmi.setText(bmiResult);
        int bmiNumber = Integer.valueOf(bmi.getText().toString());

        String resultStringBMI = setResultInfo(bmiNumber);

        resultDetailsAge.setText("Pozadany BMI zalezy od wieku i wynosi odpowiednio: 19-23 lata: 19 - 24 / 25-34 lata: 20-25 / 35 - 44 lata: 21 - 26 / 45 - 54 lata: 22 - 27 / 55 - 64 lata: 23 - 28 / ponad 64 lata: 24 - 29");
        bmiResultInfo.setText(resultStringBMI);
        setResultDetails(resultStringBMI);
    }

    public String setResultInfo(int bmiNumber)
    {
        if(bmiNumber < 16)
        {
            return "wyglodzenie";
        }
        else if(bmiNumber >=16 && bmiNumber <= 17)
        {
            return "wychudzenie";
        }
        else if(bmiNumber > 17 && bmiNumber < 19)
        {
            return "niedowaga";
        }
        else if(bmiNumber >= 19 && bmiNumber <=25)
        {
            return "pozadana masa ciala";
        }
        else if(bmiNumber >=25 && bmiNumber <= 30)
        {
            return "nadwaga";
        }
        else if(bmiNumber > 30)
        {
            return "otylosc";
        }
        else
        {
            return "";
        }
    }

    public void setResultDetails(String result)
    {
        if(result == "wyglodzenie")
        {
            resultDetails.setText("minimalnie zwiekszony poziom wystapienia innych problemow zdrowotnych.");
        }
        else if(result == "wychudzenie")
        {
            resultDetails.setText("minimalnie zwiekszony poziom wystapienia innych problemow zdrowotnych.");
        }
        else if(result == "niedowaga")
        {
            resultDetails.setText("minimalnie zwiekszony poziom wystapienia innych problemow zdrowotnych.");
        }
        else if(result == "pozadana masa ciala")
        {
            resultDetails.setText("minimalne ryzyko chorob.");
        }
       else if(result == "nadwaga")
        {
            resultDetails.setText("srednie ryzyko chorob.");
        }
       else
        {
            resultDetails.setText("wysokie (<35) bardzo wysokie (<40) ekstremalnie wysokie (>40) ryzyko zachorowania.");
        }
    }
}
