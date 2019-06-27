package com.example.shruthi.elab.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.shruthi.elab.Admin.Model.AddTechniciansModule;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.model.BookAppointment;
import com.google.firebase.database.DatabaseReference;

public class TechnicianReport extends AppCompatActivity {
    private TextView txtName, txtDOB, txtAge, txtAddress,
            txtMobile, txtEmail;


    private DatabaseReference m_oDatabase;
    private AddTechniciansModule addTechniciansModule;
    private boolean isFirstLaunch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician_report);
        init();

        try {
            AddTechniciansModule details = (AddTechniciansModule) getIntent().getSerializableExtra("P-DETAILS");
            txtName.setText(details.getStrName());
            txtAge.setText(details.getStrPAge());
            txtDOB.setText(details.getStrDOB());
            txtEmail.setText(details.getStrEmailId());
            txtAddress.setText(details.getStrAddress());
            txtMobile.setText(details.getStrMobileNumber());


        } catch (Exception w) {
            w.printStackTrace();
        }
    }


    private void init() {
        txtName = findViewById(R.id.txtname);
        txtAge = findViewById(R.id.txtAge);
        txtDOB = findViewById(R.id.txtDOB);
        txtMobile = findViewById(R.id.txtMobileNumber);
        txtEmail = findViewById(R.id.txtEmail);
        txtAddress = findViewById(R.id.txtAddress);

    }
}
