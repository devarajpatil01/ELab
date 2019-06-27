package com.example.shruthi.elab.User;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shruthi.elab.FireBase.FireBaseUtils;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.model.BookAppointment;
import com.google.firebase.auth.FirebaseAuth;


import java.util.Calendar;

public class AddAppointmentActivity extends Activity
{
    private EditText editName, edtDOB, edtAge, edtFatherName, edtAddress, edtMobile, edtEmail, edtRegarding, edtDate;
    private Button btnAddAppointment;
    private String strName, strDOB, strAge, strAddress1, strFatherName, strMobile, strEmail, strRegards, strDate,strGetRandomky;
    private boolean bIsValidate = true;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        editName = findViewById(R.id.edt_name);
        edtDOB = findViewById(R.id.edt_dob);
        edtAge = findViewById(R.id.edt_age);
        edtFatherName = findViewById(R.id.edit_father_name);
        edtAddress = findViewById(R.id.edt_address);
        edtMobile = findViewById(R.id.edt_mobile_number);
        edtEmail = findViewById(R.id.edt_emailId);
        edtRegarding = findViewById(R.id.edit_regarding);
        btnAddAppointment = findViewById(R.id.btn_add_appointment);
        edtDate = findViewById(R.id.edt_date);
        init();
    }

    private void validate()
    {
        strName = editName.getText().toString();
        strDOB = edtDOB.getText().toString().trim();
        strEmail = edtEmail.getText().toString().trim();
        strAge = edtAge.getText().toString().trim();
        strAddress1 = edtAddress.getText().toString().trim();
        strRegards = edtRegarding.getText().toString();
        strFatherName = edtFatherName.getText().toString();
        strMobile = edtMobile.getText().toString();
        strDate = edtDate.getText().toString();

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

        if (strFatherName.isEmpty()) {
            edtFatherName.setError("Please Enter Father Name");
            bIsValidate = false;
        }

        if (strRegards.isEmpty()) {
            edtRegarding.setError("Please Enter Regards");
            bIsValidate = false;

        }

        if (strDate.isEmpty()) {
            edtDate.setError("Please Select Date");
            bIsValidate = false;
        }

        if(strAddress1.isEmpty())
        {
            edtAddress.setError("Please Enter Address");
            bIsValidate = false;
        }
    }

    private void init() {

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(AddAppointmentActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                edtDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btnAddAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
                if (bIsValidate)
                {
                    FireBaseUtils oFireBaseUtils = new FireBaseUtils();
                    String strName = editName.getText().toString().trim();
                    String strDOB = edtDOB.getText().toString().trim();
                    String strAge = edtAge.getText().toString().trim();
                    String strFatherName = edtFatherName.getText().toString().trim();
                    String strAddress = edtAddress.getText().toString().trim();
                    String strMobile = edtMobile.getText().toString().trim();
                    String strEmail = edtEmail.getText().toString().trim();
                    String strRegards = edtRegarding.getText().toString();
                    String strDate = edtDate.getText().toString();
                    String currentId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String statusVal = "Send Request for Appointment";
                    String strNodeId = oFireBaseUtils.getRandomKey();

                    BookAppointment oBookAppointment = new BookAppointment(currentId, strName, strDOB, strAge, strAddress, strMobile, strFatherName, strEmail, strRegards, strDate, statusVal, strNodeId);
                    oFireBaseUtils.insertAppointment(AddAppointmentActivity.this, oBookAppointment);
                }
            }
        });

    }
}
