package com.example.shruthi.elab.Admin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.shruthi.elab.Admin.Model.AddTechniciansModule;
import com.example.shruthi.elab.FireBase.FireBaseUtils;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.model.BookAppointment;
import com.google.firebase.database.DatabaseReference;
import java.util.ArrayList;
import java.util.List;

public class PatientReport extends Activity {

    private TextView txtName, txtDOB, txtAge, txtFatherName, txtAddress,
            txtMobile, txtEmail, txtRegarding, txtDate, txtstatusId;
    private Button btnBooked;
    private String strName, strDOB, strAge, strFatherName, strMobile, strEmail, strRegards, strDate, strStatus, currentId, strAddress, getRandomke;

    private DatabaseReference m_oDatabase;
    private BookAppointment bookAppointment;
    private boolean isFirstLaunch = true;
    private Spinner spinner;
    private AddTechniciansModule addTechniciansModule;
    private List<String> listName = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_report);
         final BookAppointment details = (BookAppointment) getIntent().getSerializableExtra("P-DETAILS");

        txtName = findViewById(R.id.txtname);
        txtAge = findViewById(R.id.txtAge);
        txtDOB = findViewById(R.id.txtDOB);
        txtDate = findViewById(R.id.txtDate);
        txtFatherName = findViewById(R.id.txtFname);
        txtMobile = findViewById(R.id.txtMobileNumber);
        txtEmail = findViewById(R.id.txtEmail);
        txtAddress = findViewById(R.id.txtAddress);
        txtRegarding = findViewById(R.id.txtRegards);
        btnBooked = findViewById(R.id.btnUpdate);
        txtstatusId = findViewById(R.id.txtstatusId);
        spinner = findViewById(R.id.spinner);
        txtstatusId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(PatientReport.this);
                alertDialog.setTitle("STATUS");
                alertDialog.setMessage("Enter Status");

                final EditText inputStatus = new EditText(PatientReport.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                inputStatus.setLayoutParams(lp);
                alertDialog.setView(inputStatus);

                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                strStatus = inputStatus.getText().toString();
                                Toast.makeText(getApplicationContext(), strStatus, Toast.LENGTH_LONG).show();
                                BookAppointment oBookAppointment = new BookAppointment();
                                oBookAppointment.setNodeId(details.getNodeId());
                                oBookAppointment.setStatusupdate(strStatus);
                                FireBaseUtils oFirebaseUtils = new FireBaseUtils();
                                oFirebaseUtils.updateAppointment(getApplicationContext(), oBookAppointment);

                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }

        });
        try
        {

            txtName.setText(details.getStrName());
            txtAge.setText(details.getStrPAge());
            txtDOB.setText(details.getStrDOB());
            txtFatherName.setText(details.getStrFatherName());
            txtDate.setText(details.getStrDate());
            txtRegarding.setText(details.getStrRegarding());
            txtEmail.setText(details.getStrEmailId());
            txtAddress.setText(details.getStrAddress());
            txtMobile.setText(details.getStrMobileNumber());
            txtstatusId.setText(details.getStatusupdate());

            AddTechniciansModule list = (AddTechniciansModule) getIntent().getSerializableExtra("P-DETAILS");

            listName.add(list.getStrName().toString());
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listName);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        }
        catch (Exception w)
        {
            w.printStackTrace();
        }
    }
}
