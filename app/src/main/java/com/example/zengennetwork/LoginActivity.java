package com.example.zengennetwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText email , password;
    TextView login;
    String email_pattern = "^[A-Za-z0-9+_.-]+@(.+)$";
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);
        login = findViewById(R.id.login);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        TextView textView = (TextView) findViewById(R.id.signup_on_login);
        textView.setOnClickListener(signup_page);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformAuth();
            }
        });


    }

    private void PerformAuth() {

        String memail = email.getText().toString();
        String mpassword = password.getText().toString();


        if (!memail.matches(email_pattern))
        {
            email.setError("Email is not correct");
        }

        else if (memail.isEmpty())
        {
            email.setError("Enter your email address");
        }
        else if (mpassword.isEmpty() || mpassword.length()<6)
        {
            password.setError("Password Length should be greater than 6");
        }


        else
        {
            progressDialog.setMessage("Logging into your account");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            firebaseAuth.signInWithEmailAndPassword(memail , mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendusertonextactivity();
                        Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "" +task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendusertonextactivity() {
        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    private View.OnClickListener signup_page = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        }
    };

}