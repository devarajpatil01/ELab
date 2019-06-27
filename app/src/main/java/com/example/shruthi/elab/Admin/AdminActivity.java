package com.example.shruthi.elab.Admin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shruthi.elab.R;

public class AdminActivity extends Activity {

    private EditText edtUserNam,edtPassword;
    private Button btnLogin,btnCnacel;
    private String strUserName,strPassword;

    boolean isValidate=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               validateFields();
               if(isValidate)
               {
                   startActivity(new Intent(AdminActivity.this,AdminDashBoard.class));
               }
            }
        });

        btnCnacel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtUserNam.setText(" ");
                edtPassword.setText("");
            }
        });
    }


    private void init()
    {
        edtUserNam=findViewById(R.id.EDIT_Username);
        edtPassword=findViewById(R.id.EDIT_Password);
        btnLogin=findViewById(R.id.BTN_LOGIN);
        btnCnacel = findViewById(R.id.BTN_RESET);

    }

    private void validateFields() {

        strUserName= edtUserNam.getText().toString();
        strPassword = edtPassword.getText().toString();

        if (TextUtils.isEmpty(strUserName)) {
            edtUserNam.setError("Please Enter Username");
            return;
        }

        if (TextUtils.isEmpty(strPassword)) {
            edtPassword.setError("Please Enter Password");
            return;
        }
        if(strUserName.equals("admin")&& strPassword.equals("admin"))
        {
            Toast.makeText(AdminActivity.this, "Login Successfull",Toast.LENGTH_LONG).show();
            startActivity(new Intent(AdminActivity.this,SendReport.class));
        }
        else{
             Toast.makeText(AdminActivity.this,"Invalid Username and Password",Toast.LENGTH_LONG).show();
        }
    }

}
