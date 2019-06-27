package com.example.shruthi.elab.FireBase;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.example.shruthi.elab.Admin.Adapter.TechniciansAdapter;
import com.example.shruthi.elab.Admin.Adapter.ViewAppointmentsAdapter;
import com.example.shruthi.elab.Admin.Model.AddTechniciansModule;
import com.example.shruthi.elab.R;
import com.example.shruthi.elab.User.Adapter.ViewReportImage;
import com.example.shruthi.elab.User.model.BookAppointment;
import com.example.shruthi.elab.User.model.GetReports;
import com.example.shruthi.elab.utils.UploadImageCallback;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Shruthi on 27-04-2019.
 */

public class FireBaseUtils {

    private DatabaseReference m_oDatabase;
    String IMAGE_STORAGE_PATH = "images/";
    private FirebaseStorage mStorageRef;

    public FireBaseUtils() {
        m_oDatabase = FirebaseDatabase.getInstance().getReference();
        mStorageRef = FirebaseStorage.getInstance();
    }


    public interface CallbackUpdateReport {
        public void reportUpdateresponse(boolean value);
    }

    public void insertAppointment(final Context oContext, BookAppointment oBookAppointment) {

        m_oDatabase.child("book_appointment").child(oBookAppointment.getNodeId()).setValue(oBookAppointment)
                .addOnSuccessListener(new OnSuccessListener<Void>() {

                  /*  DatabaseReference m_oDatabase = FirebaseDatabase.getInstance().getReference();
                    String keyLcl = m_oDatabase.child("book_appointment").push().getKey();
                  //  BookAppointment bookAppointment = new BookAppointment();
                 //    BookAppointment task = m_oDatabase.child("book_appointment").child(keyLcl).setValue(hashLcl);
                   BookAppointment bookAppointment = m_oDatabase.child("book_appointment").child(keyLcl).child("statusupdate").setValue(status);
*/
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(oContext, "Appointment added Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(oContext, "Failed to add Appointment!!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void updateAppointment(final Context oContext, BookAppointment oBookAppointment) {

        m_oDatabase.child("book_appointment").child(oBookAppointment.getNodeId()).child("statusupdate").setValue(oBookAppointment.getStatusupdate())
                .addOnSuccessListener(new OnSuccessListener<Void>() {

                    /*  DatabaseReference m_oDatabase = FirebaseDatabase.getInstance().getReference();
                      String keyLcl = m_oDatabase.child("book_appointment").push().getKey();
                    //  BookAppointment bookAppointment = new BookAppointment();
                   //    BookAppointment task = m_oDatabase.child("book_appointment").child(keyLcl).setValue(hashLcl);
                     BookAppointment bookAppointment = m_oDatabase.child("book_appointment").child(keyLcl).child("statusupdate").setValue(status);
  */
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(oContext, "Appointment added Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(oContext, "Failed to add Appointment!!", Toast.LENGTH_SHORT).show();
                    }
                });
    }



    public void insertTechnicians(final Context oContext, AddTechniciansModule addTechniciansModule) {
        m_oDatabase.child("Technicians").child(getRandomKey()).setValue(addTechniciansModule)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(oContext, "Technicians added Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(oContext, "Failed to add Technicians!!", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public String getRandomKey() {
        return m_oDatabase.push().getKey();
    }

    List<BookAppointment> getPatientDetails = new ArrayList<>();

    public void listPatients(final RecyclerView listView, final Context oContext) {

        DatabaseReference BookAppointmentReference = m_oDatabase.child("book_appointment");
        BookAppointmentReference.orderByChild("strName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    BookAppointment getPatientDetails1 = postSnapshot.getValue(BookAppointment.class);
                    getPatientDetails.add(getPatientDetails1);
                }
                ViewAppointmentsAdapter serviceOwnerAdapter = new ViewAppointmentsAdapter(oContext, R.layout.card_patient_view_report, getPatientDetails);
                listView.setAdapter(serviceOwnerAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    List<BookAppointment> getSinglePatient = new ArrayList<>();

    public void listSInglePatients(final RecyclerView listView, final Context oContext) {
        DatabaseReference BookAppointmentReference = m_oDatabase.child("book_appointment");
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        BookAppointmentReference.orderByChild("userID").equalTo(currentuser).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    BookAppointment getPatientDetails = postSnapshot.getValue(BookAppointment.class);
                    getSinglePatient.add(getPatientDetails);
                }
                ViewAppointmentsAdapter serviceOwnerAdapter = new ViewAppointmentsAdapter(oContext, R.layout.card_patient_view_report, getSinglePatient);
                listView.setAdapter(serviceOwnerAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    List<AddTechniciansModule> gettechnicians = new ArrayList<>();

    public void listGetTecchnicians(final RecyclerView listView, final Context context) {
        DatabaseReference Addtechnicians = m_oDatabase.child("Technicians");
        Addtechnicians.orderByChild("strMobileNumber").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    AddTechniciansModule gettechniciansList = postSnapshot.getValue(AddTechniciansModule.class);
                    gettechnicians.add(gettechniciansList);
                }
                TechniciansAdapter serviceOwnerAdapter = new TechniciansAdapter(context, R.layout.card_view_technicians, gettechnicians);
                listView.setAdapter(serviceOwnerAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void uploadpicture(final KProgressHUD progressBar, Uri imageUri, final Context context) {

        final UploadImageCallback callback = (UploadImageCallback) context;
        if (!progressBar.isShowing()) progressBar.show();

        String imgUrl = IMAGE_STORAGE_PATH + System.currentTimeMillis() + "." + getImageExten(imageUri, context);
        final StorageReference photoStorageReference = mStorageRef.getReference().child(imgUrl);

        photoStorageReference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @UiThread
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                if (progressBar.isShowing()) progressBar.dismiss();
                Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                String downloadUrl = urlTask.getResult().toString();
                callback.uploadResponse(downloadUrl);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (progressBar.isShowing()) progressBar.dismiss();
                        callback.uploadResponse("Failure");
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    }
                });


    }


    public String getImageExten(Uri uri, Context context) {

        ContentResolver contentResolver = context.getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    List<GetReports> getPatientReport = new ArrayList<>();

    public void listreports(final RecyclerView listView, final Context oContext) {
        m_oDatabase.orderByChild("pId").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    GetReports getReports = postSnapshot.getValue(GetReports.class);
                    getPatientReport.add(getReports);
                }
                ViewReportImage viewReportImage = new ViewReportImage(oContext, R.layout.card_view_report_image, getPatientReport);
                listView.setAdapter(viewReportImage);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    GetReports getReports1 = postSnapshot.getValue(GetReports.class);
                    getPatientReport.add(getReports1);
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void updateReprtToAppointment(final Context context, final KProgressHUD loader, final String imageUri, final String date, String name, final String phoneNum, final CallbackUpdateReport callback) {

        loader.show();


        final DatabaseReference BookAppointmentReference = m_oDatabase.child("book_appointment");
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        BookAppointmentReference.orderByChild("strMobileNumber").equalTo(phoneNum).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    BookAppointment getPatientDetails = postSnapshot.getValue(BookAppointment.class);
                    if (getPatientDetails.getStrMobileNumber().equalsIgnoreCase(phoneNum)) {
                        getPatientDetails.setReportPath(imageUri);
                        getPatientDetails.setReportedGenerationDate(date);
                        BookAppointmentReference.child(postSnapshot.getKey()).setValue(getPatientDetails);
                        callback.reportUpdateresponse(true);
                        return;
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callback.reportUpdateresponse(false);

            }
        });


    }


}
