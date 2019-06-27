package com.example.shruthi.elab.Admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;

import com.example.shruthi.elab.FireBase.FireBaseUtils;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.model.BookAppointment;


import java.util.ArrayList;
import java.util.List;

public class AdminDashBoard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button btn_add_appointment, btn_view_appointment;

    private RecyclerView appointmentRv;
    private List<BookAppointment> reportList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        appointmentRv = findViewById(R.id.appointmentRv);

        reportList = new ArrayList<>();
        appointmentRv.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AdminDashBoard.this);
        appointmentRv.setLayoutManager(layoutManager);

        FireBaseUtils oFirebaseUtils = new FireBaseUtils();
        ProgressDialog pDialog = new ProgressDialog(AdminDashBoard.this); //Your Activity.this
        pDialog.setMessage("Loading...!");
        pDialog.setCancelable(false);
        pDialog.show();
        oFirebaseUtils.listPatients(appointmentRv,AdminDashBoard.this);
        pDialog.dismiss();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_sendReport) {
            startActivity(new Intent(AdminDashBoard.this, SendReport.class));

        } else if (id == R.id.nav_appointments) {

        } else if (id == R.id.nav_profile) {
            // yet to do

        } else if (id == R.id.nav_logout) {

            // logout yet
        }

        else if(id == R.id.nav_reports)
        {
            startActivity(new Intent(AdminDashBoard.this, ViewReportHistory.class));
        }
        else  if(id == R.id.nav_addTechnicians)
        {
            startActivity(new Intent(AdminDashBoard.this,AddTechnicians.class));
        }
        else if(id == R.id.nav_viewTechnicians)
        {
            startActivity(new Intent(AdminDashBoard.this,ViewTechnicians.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
