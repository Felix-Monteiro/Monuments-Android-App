/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 03/03/20 10:37                                               -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.post;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.thunder.project.R;
import com.thunder.project.model.Posts;

public class UploadActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Button choosenImageBtn;
    private Button uploadBtn;
    private EditText nameEditText;
    private EditText descriptionEditText;
    private ImageView chosenImageView;
    private ProgressBar uploadProgressBar;

    private FirebaseUser mUser;
    private Uri mImageUri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_up);

        choosenImageBtn = findViewById(R.id.button_choose_image);
        uploadBtn = findViewById(R.id.uploadBtn);
        nameEditText = findViewById(R.id.nameEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        chosenImageView = findViewById(R.id.chosenImageView);
        uploadProgressBar = findViewById(R.id.progress_bar);

        mUser = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();
        mStorageRef = FirebaseStorage.getInstance().getReference("memories_uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("memories_uploads/"+mUser.getUid().toString());

        //Image Button
        choosenImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        //Upload Button
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUploadTask != null && mUploadTask.isInProgress()){
                    Toast.makeText(UploadActivity.this,"An Upload is Still in Progress",Toast.LENGTH_SHORT).show();
                }else {
                    uploadFile();
                }
            }
        });
    }

    //Image choice function
    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode== PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data!=null && data.getData() != null){
            mImageUri = data.getData();

            Picasso.get().load(mImageUri).into(chosenImageView);
        }
    }

    private String getFileExtention(Uri uri){
        ContentResolver cR= getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    //Uploads a Memory to Firebase
    private void uploadFile(){
        if (mImageUri != null){

            //It creates separate directories for each user in the database
            final StorageReference imageRef = mStorageRef.child(mUser.getUid()+"/"+mImageUri.getLastPathSegment());
            uploadProgressBar.setVisibility(View.VISIBLE);
            uploadProgressBar.setIndeterminate(true);

            mUploadTask = imageRef.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            uploadProgressBar.setVisibility(View.VISIBLE);
                            uploadProgressBar.setIndeterminate(false);
                            uploadProgressBar.setProgress(0);

                        }
                    },500);

                    Toast.makeText(UploadActivity.this,"Memory Upload successful",Toast.LENGTH_LONG).show();

                    imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri downloadurl) {
                            Posts upload = new Posts(nameEditText.getText().toString().trim(),downloadurl.toString(),descriptionEditText.getText().toString());
                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(upload);
                        }
                    });

                    uploadProgressBar.setVisibility(View.VISIBLE);
                    openImagesActivity();
                }
            })
             .addOnFailureListener(new OnFailureListener() {
                 @Override
                 public void onFailure(@NonNull Exception e) {
                    uploadProgressBar.setVisibility(View.VISIBLE);
                    Toast.makeText(UploadActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                 }
             })
               .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                   @Override
                   public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                       double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                       uploadProgressBar.setProgress((int) progress);
                   }
               });
        }else{
            Toast.makeText(this,"You haven't Selected any file!",Toast.LENGTH_SHORT).show();
        }
    }
    private void openImagesActivity(){
        Intent intent = new Intent(this,PostsActivity.class);
        startActivity(intent);
    }
}
