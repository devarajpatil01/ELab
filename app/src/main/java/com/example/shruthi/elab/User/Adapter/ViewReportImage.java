package com.example.shruthi.elab.User.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shruthi.elab.Admin.ViewImageReport;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.model.GetReports;
import java.util.List;

public class ViewReportImage extends RecyclerView.Adapter<ViewReportImage.ContactViewHolder> {

    private Context context;
    private List<GetReports> contactList;
    private int res;

    public ViewReportImage(Context context, int resource, List<GetReports> arrServiceOwner) {
        // super(context, resource, arrServiceOwner);
        this.context = context;
        this.contactList = arrServiceOwner;
        this.res = resource;
    }

    @Override
    public ViewReportImage.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_view_report_image, parent, false);

        return new ViewReportImage.ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewReportImage.ContactViewHolder holder, int position) {


        final GetReports ci = contactList.get(position);
        holder.txtPName.setText(ci.getStrName());
        holder.txtDate.setText(ci.getStrDate());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oViewImageReport = new Intent(context, ViewImageReport.class);
                oViewImageReport.putExtra("P-DETAILS", ci);
                context.startActivity(oViewImageReport);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder
    {
        private TextView txtPName,txtDate;
        public ContactViewHolder(View itemView)
        {
            super(itemView);
            txtPName = itemView.findViewById(R.id.txtname);
            txtDate = itemView.findViewById(R.id.txtDate);
        }
   }
}
