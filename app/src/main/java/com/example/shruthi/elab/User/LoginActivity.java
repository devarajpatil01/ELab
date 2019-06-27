package com.example.shruthi.elab.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shruthi.elab.R;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin,Btn_Reset;
    EditText edtUserName,edtPassword;
    TextView tv_Login;
    String strUsername, strPassword;
    boolean isValidate=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFields();
                if(isValidate)
                {
                    startActivity(new Intent(LoginActivity.this,BootAppointment.class));
                }
            }
        });

    }

    private void  init()
    {
       edtUserName = findViewById(R.id.EDIT_Username) ;
       edtPassword = findViewById(R.id.edit_password);
       btnLogin = findViewById(R.id.btn_submit);

    }

    private void validateFields() {

        strUsername= edtUserName.getText().toString();
        strPassword = edtPassword.getText().toString();

        if (TextUtils.isEmpty(strUsername)) {
            edtUserName.setError("Please Enter Username");
            return;
        }

        if (TextUtils.isEmpty(strPassword)) {
            edtPassword.setError("Please Enter Password");
            return;
        }
        if(strUsername.equals("123456")&& strPassword.equals("123456"))
        {
            Toast.makeText(LoginActivity.this, "Login Successful",Toast.LENGTH_LONG).show();
            startActivity(new Intent(LoginActivity.this,BootAppointment.class));
        }
        else{
              Toast.makeText(LoginActivity.this,"Invalid Username and Password",Toast.LENGTH_LONG).show();
        }
    }
}
