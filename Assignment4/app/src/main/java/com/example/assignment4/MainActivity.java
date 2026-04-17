package com.example.assignment4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton device;
    CheckBox ch1,ch2,ch3,ch4;
    Button btn;
    TextView outputfeature,outputdevice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            rg = findViewById(R.id.device);
            btn = findViewById(R.id.submit);
            ch1 = findViewById(R.id.notify);
            ch2 = findViewById(R.id.loc);
            ch3 = findViewById(R.id.cb);
            ch4 = findViewById(R.id.dm);
            outputfeature = findViewById(R.id.outputfeature);
            outputdevice = findViewById(R.id.outputdevice);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int selectedId = rg.getCheckedRadioButtonId();
                    device = findViewById(selectedId);
                    String deviceOutput = device.getText().toString();
                    outputdevice.setText("Selected device: "+deviceOutput);
                    String feature = "";
                    if(ch1.isChecked() == true)
                        feature = ch1.getText().toString();
                    if(ch2.isChecked() == true)
                        feature = feature +" "+ ch2.getText().toString();
                    if(ch3.isChecked() == true)
                        feature = feature + " " + ch3.getText().toString();
                    if(ch4.isChecked() == true)
                        feature = feature + " " + ch4.getText().toString();
                    outputfeature.setText("Selected Feature: " + " " + feature);
                }
            });
            return insets;
        });
    }
}