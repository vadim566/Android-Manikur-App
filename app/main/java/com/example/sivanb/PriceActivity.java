package com.example.sivanb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class PriceActivity extends AppCompatActivity {


    public String [] price=new String[]{"80","100","150","200"};
    public String [] mssg=new String[]{"איזה כיף זה רק ב","השלמות עולה רק ","פינוק ב","אמאלה רק ב"};
    int lengMssg =mssg.length;
    Random rand=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price2);


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PriceActivity.this, mssg[rand.nextInt(lengMssg)]+price[0], Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PriceActivity.this, mssg[rand.nextInt(lengMssg)]+price[3], Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PriceActivity.this, mssg[rand.nextInt(lengMssg)]+price[2], Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PriceActivity.this, mssg[rand.nextInt(lengMssg)]+price[1], Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PriceActivity.this, mssg[rand.nextInt(lengMssg)]+price[1], Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PriceActivity.this, mssg[rand.nextInt(lengMssg)]+price[0], Toast.LENGTH_SHORT).show();
            }
        });


    }
}