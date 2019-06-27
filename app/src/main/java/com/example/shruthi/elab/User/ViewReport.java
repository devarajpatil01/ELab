package com.example.shruthi.elab.User;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shruthi.elab.FireBase.FireBaseUtils;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.Adapter.ViewReportImage;
import com.example.shruthi.elab.User.model.GetReports;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class ViewReport extends Fragment {

    private RecyclerView recyclerView;
    private ViewReportImage viewReportImage;
    private List<GetReports> reportList;
    private RecyclerView.LayoutManager layoutManager;

    public ViewReport() {
        this.getContext();
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_view_report, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        reportList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        FireBaseUtils oFirebaseUtils = new FireBaseUtils();
        ProgressDialog pDialog = new ProgressDialog(getContext()); //Your Activity.this
        pDialog.setMessage("Loading...!");
        pDialog.setCancelable(false);
        pDialog.show();
        oFirebaseUtils.listreports(recyclerView,getContext());
        pDialog.dismiss();

        return view;


    }

}
