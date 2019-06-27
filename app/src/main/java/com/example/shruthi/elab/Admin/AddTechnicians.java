package com.example.shruthi.elab.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.shruthi.elab.Admin.Model.AddTechniciansModule;
import com.example.shruthi.elab.FireBase.FireBaseUtils;
import com.example.shruthi.elab.R;

public class AddTechnicians extends AppCompatActivity {

    private EditText editName, edtDOB, edtAge, edtFatherName, edtAddress, edtMobile, edtEmail, edtRegarding, edtDate;
    private Button btnAddAppointment;
    private String strName, strDOB, strAge, strAddress1, strFatherName, strMobile, strEmail, strRegards, strDate;
    private boolean bIsValidate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_technicians);

        editName = findViewById(R.id.edt_name);
        edtDOB = findViewById(R.id.edt_dob);
        edtAge = findViewById(R.id.edt_age);
        edtAddress = findViewById(R.id.edt_address);
        edtMobile = findViewById(R.id.edt_mobile_number);
        edtEmail = findViewById(R.id.edt_emailId);
        btnAddAppointment = findViewById(R.id.btn_add_appointment);

        init();
    }

    private void validate() {

        strName = editName.getText().toString();
        strDOB = edtDOB.getText().toString().trim();
        strAge = edtAge.getText().toString().trim();
        strAddress1 = edtAddress.getText().toString().trim();
        strMobile = edtMobile.getText().toString();
        strEmail = edtEmail.getText().toString().trim();


        if (strName.isEmpty()) {
            editName.setError("Please Enter Name");
            bIsValidate = false;
        }
        if (strMobile.isEmpty()) {
            edtMobile.setError("Please Enter Phone Number");
            bIsValidate = false;
        }
        if (strEmail.isEmpty()) {
            edtMobile.setError("Please Enter Email");
            bIsValidate = false;
        }
        if (strDOB.isEmpty()) {
            edtDOB.setError("Please Enter DOB");
            bIsValidate = false;
        }

        if (strAge.isEmpty()) {
            edtAge.setError("Please Enter Age");
            bIsValidate = false;
        }

        if(strAddress1.isEmpty())
        {
            edtAddress.setError("Please Enter Address");
            bIsValidate = false;

        }

    }

    private void init() {

        btnAddAppointment.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                validate();
                if (bIsValidate) {

                    String strName = editName.getText().toString().trim();
                    String strDOB = edtDOB.getText().toString().trim();
                    String strAge = edtAge.getText().toString().trim();
                    String strAddress = edtAddress.getText().toString().trim();
                    String strMobile = edtMobile.getText().toString().trim();
                    String strEmail = edtEmail.getText().toString().trim();

                   /* String currentId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String statusval = "Send Request for Appointment";*/

                    AddTechniciansModule addTechniciansModule = new AddTechniciansModule(strName, strDOB, strAge, strAddress, strMobile,strEmail);
                    FireBaseUtils oFirebaseUtils = new FireBaseUtils();
                    oFirebaseUtils.insertTechnicians(AddTechnicians.this, addTechniciansModule);

                }
            }
        });
    }
}
