package com.example.sivanb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //help toast
        Button toastButton = findViewById(R.id.button5);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context activitycontext  = getApplicationContext();
                String text = "1.אם ברצונך להזמין תור אנא לחצי על כפתור זימון תור ולאחר מכן בחרי בתאריך ובשעה הרצויה ולאחר מכן אישור.\n" +
                        "2.אם ברצונך להסתכל בתעריפים אנא לחצי על צפיה במחירון ושם תוכלי לצפות בשלל האופציות.\n" +
                        "3. אם ברצונך לצפות בעבודות שנעשו אנא לחצי על הכפתור תצוגת עבודות.\n" +
                        "4. אם הינך מעוניינת לצפות בדף העסקי שלנו באינסטגרם אנא לחצי על דף עסקי והקליקי על הקישור המצורף.\n";

                int duration = (Toast.LENGTH_LONG)*3;
                Toast toast = Toast.makeText(activitycontext , text , duration);
                toast.show();
            }
        }

        );

        //move to price list activity
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this , PriceActivity.class);
                startActivity(intent);
            }
        });
        //move to ZIMUN_TOR activity
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this , ZIMUN_TOR.class);
                startActivity(intent);
            }
        });

        //move to business activity
        findViewById(R.id.button12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this , BusinessActivity.class);
                startActivity(intent);
            }
        });

        //move to Gallery activity
        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this , GalleryActivity.class);
                startActivity(intent);
            }
        });

        //move to Register activity
        findViewById(R.id.button13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this ,Register.class);
                startActivity(intent);
            }
        });

        //move to Login activity
        findViewById(R.id.button14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this , Login.class);
                startActivity(intent);
            }
        });
    }
}