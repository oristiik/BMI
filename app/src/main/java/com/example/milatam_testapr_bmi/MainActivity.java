package com.example.milatam_testapr_bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_vaha, editText_vyska, editText_jmeno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_vaha = (EditText) findViewById(R.id.editText_vaha);
        editText_vyska = (EditText) findViewById(R.id.editText_vyska);
        editText_jmeno = (EditText) findViewById(R.id.editText_jmeno);
    }

    public void buttonVyhodnotit(View view) {
        try {
            int vaha = Integer.parseInt(editText_vaha.getText().toString());
            int vyska = Integer.parseInt(editText_vyska.getText().toString());
            String jmeno = editText_jmeno.getText().toString();

            double bmi = bmiCalc(vaha, vyska);

            if(bmi < 18.5) {
                Toast.makeText(getApplicationContext(), "podváha", Toast.LENGTH_LONG).show();
            }
            if (bmi < 25 && bmi > 18.5) {
                Toast.makeText(getApplicationContext(), "ideální váha", Toast.LENGTH_LONG).show();
            }
            if(bmi > 30) {
                        Toast.makeText(getApplicationContext(), "nadváha", Toast.LENGTH_LONG).show();
                    }

        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "chyba", Toast.LENGTH_LONG).show();
        }

    }

    private double bmiCalc(int vaha, int vyska){
        return vaha / Math.pow(vyska * 0.01, 2);
    }


}
