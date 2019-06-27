package com.example.shruthi.elab.Admin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shruthi.elab.Admin.PatientReport;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.model.BookAppointment;

import java.util.List;

/**
 * Created by Shruthi on 28-04-2019.
 */

public class ViewAppointmentsAdapter extends RecyclerView.Adapter<ViewAppointmentsAdapter.ContactViewHolder> {

    private Context context;
    private List<BookAppointment> contactList;
    private int res;

   /* public ViewReportAd(List<GetReport> contactList) {
        this.contactList = contactList;
    }*/

    public ViewAppointmentsAdapter(Context context, int resource, List<BookAppointment> arrServiceOwner) {
        // super(context, resource, arrServiceOwner);
        this.context = context;
        this.contactList = arrServiceOwner;
        this.res = resource;
    }

    @Override
    public ViewAppointmentsAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_patient_view_report, parent, false);

        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewAppointmentsAdapter.ContactViewHolder holder, int position) {


        final BookAppointment ci = contactList.get(position);
        holder.txtPName.setText(ci.getStrName());
        holder.txtDate.setText(ci.getStrDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent patientReport = new Intent(context, PatientReport.class);
                patientReport.putExtra("P-DETAILS", ci);
                context.startActivity(patientReport);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView txtPName,txtDate;

        public ContactViewHolder(View itemView) {
            super(itemView);

            txtPName = itemView.findViewById(R.id.txtname);
            txtDate = itemView.findViewById(R.id.txtDate);

        }

    }
}