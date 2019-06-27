package com.example.shruthi.elab.Admin;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.shruthi.elab.FireBase.FireBaseUtils;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.AddAppointmentActivity;
import com.example.shruthi.elab.utils.Imageutils;
import com.example.shruthi.elab.utils.UploadImageCallback;
import com.kaopiz.kprogresshud.KProgressHUD;
import java.io.File;
import java.util.Calendar;

public class SendReport extends Activity implements View.OnClickListener,
        Imageutils.ImageAttachmentListener, UploadImageCallback, FireBaseUtils.CallbackUpdateReport {

    private Imageutils imageutils;
    private static final int RC_CAMERA_PIC = 0;
    private static final int RC_GALLERY_PIC = 1;
    private Bitmap bitmap;
    private String file_name, file_path;
    private Uri imageUri;
    private String stredtDate,strName,strPhonenumber;
    private ImageView capturedImg;
    private Button BrowseBtn;
    public KProgressHUD loader;
    private EditText edtDate,edtPhoneNumber,edtName;


    private  DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_send_report);

        imageutils = new Imageutils(this);
        capturedImg = (ImageView)this.findViewById(R.id.capturedImg);
        BrowseBtn = (Button) this.findViewById(R.id.BrowseBtn);
        edtDate = (EditText) this.findViewById(R.id.edtdate);
        edtPhoneNumber = (EditText) this.findViewById(R.id.editTextNumber);
        edtName = (EditText) this.findViewById(R.id.editTextName);
        BrowseBtn.setText(getResources().getString(R.string.browseBtnTxt));
        BrowseBtn.setOnClickListener(this);

        edtPhoneNumber.getText().toString();
        edtName.getText().toString();

        loader = KProgressHUD.create(SendReport.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("uploading picture...")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);


        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(SendReport.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                edtDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        stredtDate = edtDate.getText().toString();
        strName = edtName.getText().toString();
        strPhonenumber = edtPhoneNumber.getText().toString();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_CAMERA_PIC || requestCode == RC_GALLERY_PIC) {
            imageutils.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        imageutils.request_permission_result(requestCode, permissions, grantResults);
    }

    @Override
    public void image_attachment(int from, String filename, Bitmap file, Uri uri) {

        this.bitmap = file;
        this.file_name = filename;
        imageUri = uri;
        capturedImg.setImageBitmap(file);
        this.file_path = Environment.getExternalStorageDirectory() + File.separator + "PIMS" + File.separator;
        imageutils.createImage(bitmap, file_name, file_path, false);
        BrowseBtn.setText(getResources().getString(R.string.uploadBtnTxt));

    }

    @Override
    public void onClick(View v) {
        if(BrowseBtn.getText().toString().equals(getResources().getString(R.string.browseBtnTxt))){
            imageutils.imagepicker(RC_CAMERA_PIC);
        }else if(BrowseBtn.getText().toString().equals(getResources().getString(R.string.uploadBtnTxt))){

            FireBaseUtils db = new FireBaseUtils();
            db.uploadpicture(loader, imageUri, this);
        }
    }

    @Override
    public void uploadResponse(String response) {
        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

        if(!response.equals("Failure")){

            FireBaseUtils db = new FireBaseUtils();
            db.updateReprtToAppointment(getApplicationContext(), loader, response, stredtDate, strName, strPhonenumber, this);
        }
    }

    @Override
    public void reportUpdateresponse(boolean value) {
        if(value)
            Toast.makeText(getApplicationContext(), "Updated Report", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), "Falied To Update report", Toast.LENGTH_LONG).show();
    }
}
