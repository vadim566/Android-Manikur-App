package com.example.sivanb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class calendarRead extends AppCompatActivity {
    private static final String TAG = "calendarRead";
    private CalendarView mCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_read);

        mCalendarView = (CalendarView) findViewById(R.id.calendarView_read);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1+1) + "/" + i2 + "/" + i;
                Log.d(TAG,"onSelectedDayChange: mm/dd/yyyy:" + date);

                Intent intent = new Intent(calendarRead.this , appoitment.class );
                intent.putExtra("date",date);
                startActivity(intent);
            }
        });

    }
}