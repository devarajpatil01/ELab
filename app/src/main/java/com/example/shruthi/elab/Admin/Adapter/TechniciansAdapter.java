package com.example.shruthi.elab.Admin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shruthi.elab.Admin.Model.AddTechniciansModule;
import com.example.shruthi.elab.Admin.PatientReport;
import com.example.shruthi.elab.Admin.TechnicianReport;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.model.BookAppointment;

import java.util.List;

public class TechniciansAdapter extends RecyclerView.Adapter<TechniciansAdapter.ContactViewHolder> {

    private Context context;
    private List<AddTechniciansModule> contactList;
    private int res;

   /* public ViewReportAd(List<GetReport> contactList) {
        this.contactList = contactList;
    }*/

    public TechniciansAdapter(Context context, int resource, List<AddTechniciansModule> arrServiceOwner) {
        // super(context, resource, arrServiceOwner);
        this.context = context;
        this.contactList = arrServiceOwner;
        this.res = resource;
    }

    @Override
    public TechniciansAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_view_technicians, parent, false);

        return new TechniciansAdapter.ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TechniciansAdapter.ContactViewHolder holder, int position) {


        final AddTechniciansModule ci = contactList.get(position);
        holder.txtPName.setText(ci.getStrName());
        holder.txtMobileNumber.setText(ci.getStrMobileNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent techniciansReport = new Intent(context, TechnicianReport.class);
                techniciansReport.putExtra("P-DETAILS", ci);
                context.startActivity(techniciansReport);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView txtPName, txtMobileNumber;

        public ContactViewHolder(View itemView) {
            super(itemView);

            txtPName = itemView.findViewById(R.id.txtname);
            txtMobileNumber = itemView.findViewById(R.id.txtMobileNumber);

        }

    }
}