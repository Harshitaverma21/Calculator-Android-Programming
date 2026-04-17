package com.example.alarmapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class activity2 extends AppCompatActivity {

TimePicker tp;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            tp = findViewById(R.id.timepicker);
            btn = findViewById(R.id.button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int hour = tp.getHour();
                    int minute = tp.getMinute();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(calendar.HOUR_OF_DAY,hour);
                    calendar.set(calendar.MINUTE, minute);
                    calendar.set(calendar.SECOND,0);
                    Log.d("time", "hour" + hour + "Minute" + minute );
                    Intent intent = new Intent(PackageContext.activity2)

                }
            });

            return insets;
        });
    }
}