package com.example.shruthi.elab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shruthi.elab.Admin.AdminActivity;
import com.example.shruthi.elab.User.UserLogin;

public class SelectUser extends AppCompatActivity
{
    Button btnUser, btnAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        btnUser = findViewById(R.id.btn_User);
        btnAdmin = findViewById(R.id.btn_admin);
        btnUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(SelectUser.this, UserLogin.class));
            }
        });

        btnAdmin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(SelectUser.this, AdminActivity.class));
            }
        });
    }
}
