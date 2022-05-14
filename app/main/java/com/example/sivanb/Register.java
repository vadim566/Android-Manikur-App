package com.example.sivanb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText mFullName, mPassword, mPhone, mEmail;
    Button mRegisterBtn;
    TextView mAlreadyreg;
    FirebaseAuth fAuthReg;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullNameReg);
        mPassword = findViewById(R.id.passwordReg);
        mEmail = findViewById(R.id.emailReg);
        mPhone = findViewById(R.id.phoneNumReg);
        mRegisterBtn = findViewById(R.id.RegBut);
        mAlreadyreg = findViewById(R.id.alreadyReg1);

        fAuthReg = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar2);




        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String pass = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    mPassword.setError("password is required");
                    return;
                }

                if (pass.length() < 6) {
                    mPassword.setError("password must be >=6 Characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuthReg.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this,"User Created",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(Register.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        mAlreadyreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));

            }
        });
    }
}

