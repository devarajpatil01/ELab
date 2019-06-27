package com.example.shruthi.elab.Admin;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shruthi.elab.Admin.Model.AddTechniciansModule;
import com.example.shruthi.elab.FireBase.FireBaseUtils;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.model.BookAppointment;

import java.util.ArrayList;
import java.util.List;

public class ViewTechnicians extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<AddTechniciansModule> techniciansModuleList;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_technicians);

        recyclerView = findViewById(R.id.recycler_view);
        techniciansModuleList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(ViewTechnicians.this);
        recyclerView.setLayoutManager(layoutManager);

        FireBaseUtils oFirebaseUtils = new FireBaseUtils();
        ProgressDialog pDialog = new ProgressDialog(ViewTechnicians.this); //Your Activity.this
        pDialog.setMessage("Loading...!");
        pDialog.setCancelable(false);
        pDialog.show();
        oFirebaseUtils.listGetTecchnicians(recyclerView, ViewTechnicians.this);
        pDialog.dismiss();

    }
}
