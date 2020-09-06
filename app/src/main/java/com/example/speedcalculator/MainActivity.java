package com.example.speedcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calButton = findViewById(R.id.botton_cal);
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Distence = findViewById(R.id.text_Meter);
                EditText Time = findViewById(R.id.text_Time);
                String DDistence = Distence.getText().toString();
                String DTime = Time.getText().toString();
                TextView Text_Answer = findViewById(R.id.text_Answers);


                if(DDistence.isEmpty() || DTime.isEmpty()){
                    Toast t = Toast.makeText(MainActivity.this, R.string.Distance_and_time_are_required,Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    double S = Double.parseDouble(DDistence);
                    double T = Double.parseDouble(DTime);
                    if(T==0){
                        Toast t = Toast.makeText(MainActivity.this, R.string.TimeZero,Toast.LENGTH_LONG);
                        t.show();
                    }
                    else {
                        double ANS = (S / 1000)*(3600/T);
                        Text_Answer.setText(String.format("%.2f", ANS));
                        if(ANS>80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage(R.string.OverLimit);
                            dialog.setPositiveButton("OK",null);
                            dialog.show();}
                    }
                }
            }
        });
        Button button_Clear = findViewById(R.id.button_clear);
        button_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ET_dis = findViewById(R.id.text_Meter);
                EditText ET_Time = findViewById(R.id.text_Time);
                TextView Text_Ans = findViewById(R.id.text_Answers);
                ET_dis.setText("");
                ET_Time.setText("");
                Text_Ans.setText("");
            }
            });
        }
    }
