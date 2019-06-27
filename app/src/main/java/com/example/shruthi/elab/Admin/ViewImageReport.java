package com.example.shruthi.elab.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.model.GetReports;
import com.google.firebase.storage.StorageReference;

public class ViewImageReport extends AppCompatActivity {

    private ImageView imageView;
    private AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image_report);

        imageView = findViewById(R.id.reportImage);

        try {
            GetReports details = (GetReports) getIntent().getSerializableExtra("P-DETAILS");
          //  Glide.with().load(upload.getUrl()).into(holder.imageView);
            Glide.with(activity).load(details.getImageURL()).into(imageView);

        }catch (Exception w){
            w.printStackTrace();
        }

    }
}
