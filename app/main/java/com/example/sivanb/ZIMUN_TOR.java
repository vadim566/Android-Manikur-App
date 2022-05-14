package com.example.sivanb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class ZIMUN_TOR extends AppCompatActivity {


    private EditText tPhone;
    private EditText fName;
    private TimePickerDialog picker;
    private EditText eText;
    private Button btnGet;
    private TextView tvw;
    private static final String TAG = "ZIMUN_TOR";
    private TextView theDate;
    private Button btnGoCalendar;
    private int hourAp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zimun_tor);
        tPhone=(EditText)findViewById(R.id.phoneNumReg2);
        fName=(EditText)findViewById(R.id.fullNameReg2);
        theDate = (TextView)findViewById(R.id.Date);
        btnGoCalendar = (Button) findViewById(R.id.btnGoCalendar);
        tvw=(TextView)findViewById(R.id.textView_timeP);
        eText=(EditText) findViewById(R.id.editText_timeP);
        eText.setInputType(InputType.TYPE_NULL);



        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        theDate.setText(date);




/**

 **/


        //TODO add reader from dataBase

        btnGoCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZIMUN_TOR.this, CalendarActivity.class);
                startActivity(intent);

            }
        });

        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog

                picker = new TimePickerDialog(ZIMUN_TOR.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                eText.setText(sHour+ ":" + sMinute );//without minute
                                hourAp=sHour;
                            }
                        }, hour, minutes, true);
                picker.show();
            }
        });

        btnGet=(Button)findViewById(R.id.button_timeP);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String val="Time: "+eText.getText()+",Client:"+fName.getText()+ ",Telephone:"+tPhone.getText();
                tvw.setText(val);
                final String valW=tvw.getText().toString();



                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(date+"/"+hourAp);
                myRef.setValue(valW);//write action

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


    }
}