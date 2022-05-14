package com.example.sivanb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class appoitment extends AppCompatActivity {
    private ArrayAdapter adapter;
    private ListView list;
    private Button btnGoCalendar;
    private TextView theDate;
    private static final String TAG = "appoitment";
    private ArrayList<String> meetingsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoitment);
        theDate=(TextView)findViewById(R.id.date_appointment) ;
        btnGoCalendar = (Button) findViewById(R.id.btnGoCalendar2);
        //List view with adapter
        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        list=(ListView)findViewById(R.id.listView1);
        meetingsList=new ArrayList<String>();

        Intent incomingIntent = getIntent();

        String date = incomingIntent.getStringExtra("date");
        theDate.setText(date);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef;
        try{
            myRef = database.getReference(date+"/1");//default db enetry
        }
        catch (Exception e){
            myRef = database.getReference();//if somthing went wrong
        }

        for(int i=8;i<20;i++){//time of working
            try{
                myRef = database.getReference(date);
            }
             catch (Exception e){
                //pass over coz null value
             }

        }



// Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//add all values between the hours of work
                for(DataSnapshot d : dataSnapshot.getChildren()) {

                    int hour_of_work=Integer.valueOf(d.getKey());
                    if(hour_of_work>8 && hour_of_work<21){
                        adapter.add(d.getValue(String.class));
                    }



                }
                list.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError error) {
// Failed to read value
                Toast.makeText(getApplicationContext(), "Failed to read value." +
                        error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        btnGoCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appoitment.this, calendarRead.class);
                startActivity(intent);

            }

        });
    }
}