package com.example.zengennetwork.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zengennetwork.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    EditText name , email , password , confirmpassword;
    TextView signup;
    String email_pattern = "^[A-Za-z0-9+_.-]+@(.+)$";
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();


        name =  findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirm_password);
        signup = findViewById(R.id.signup);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformAuth();
            }
        });

    }

    private void PerformAuth() {
        String mname = name.getText().toString();
        String memail = email.getText().toString();
        String mpassword = password.getText().toString();
        String mconfirm = confirmpassword.getText().toString();
        String msignup = signup.getText().toString();

        if (!memail.matches(email_pattern))
        {
            email.setError("Email Pattern is not correct");
        }
        else if (mpassword.isEmpty() || mpassword.length()<6)
        {
            password.setError("Password Length should be greater than 6.");
        }

        else if (!mpassword.equals(mconfirm))
        {
            confirmpassword.setError("Password do not match");
        }

        else if (mpassword.equals(mconfirm) && mpassword.length()>6 && memail.matches(email_pattern))
        {
            progressDialog.setMessage("Registring your account");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(memail , mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendusertonextactivity();
                        Toast.makeText(SignupActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(SignupActivity.this, "" +task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendusertonextactivity() {
        Intent intent = new Intent(SignupActivity.this , LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

