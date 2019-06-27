package com.example.shruthi.elab.Admin;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shruthi.elab.FireBase.FireBaseUtils;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.Adapter.ViewReportImage;
import com.example.shruthi.elab.User.model.GetReports;

import java.util.ArrayList;
import java.util.List;

public class ViewReportHistory extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ViewReportImage viewReportImage;
    private List<GetReports> reportList;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_patient_report);

        recyclerView = findViewById(R.id.recycler_view);
        reportList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(ViewReportHistory.this);
        recyclerView.setLayoutManager(layoutManager);

        FireBaseUtils oFirebaseUtils = new FireBaseUtils();
        ProgressDialog pDialog = new ProgressDialog(ViewReportHistory.this); //Your Activity.this
        pDialog.setMessage("Loading...!");
        pDialog.setCancelable(false);
        pDialog.show();
        oFirebaseUtils.listreports(recyclerView, ViewReportHistory.this);
        pDialog.dismiss();

    }
}
