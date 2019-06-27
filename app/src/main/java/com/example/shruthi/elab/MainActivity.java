package com.example.shruthi.elab;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.shruthi.elab.User.LoginActivity;
import com.example.shruthi.elab.User.UserLogin;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i=new Intent(MainActivity.this, SelectUser.class);
                startActivity(i);
            }
        },4000);
    }

}
