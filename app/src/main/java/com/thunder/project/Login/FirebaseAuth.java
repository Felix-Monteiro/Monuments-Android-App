/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 22/02/20 19:15                                               -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.Login;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.thunder.project.R;
import com.thunder.project.view.home.HomeActivity;
import com.thunder.project.view.post.PostsActivity;

import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FirebaseAuth extends AppCompatActivity {

    FirebaseUser user;
    private TextView userName, userProfName , userEmail ;
    private CircleImageView userProfileImage;

    private String currentUserId;

    private static final int MY_REQUEST_CODE = 1424 ; //Any Number
    List<AuthUI.IdpConfig> providers;
    Button btn_sign_out;
    Button open_activity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        
        btn_sign_out = (Button)findViewById(R.id.btn_sign_out);
        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Logout
                AuthUI.getInstance().signOut(FirebaseAuth.this).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        btn_sign_out.setEnabled(false);
                        showSignInOptions();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(FirebaseAuth.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        //Init provider
        providers= Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),//Email Builder
                new AuthUI.IdpConfig.PhoneBuilder().build(),//Phone Builder
                new AuthUI.IdpConfig.FacebookBuilder().build(),//Facebook Builder
                new AuthUI.IdpConfig.GoogleBuilder().build() //Google Builder
        );


        showSignInOptions();



        //Navigation barView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Set profile Selected
        bottomNavigationView.setSelectedItemId(R.id.profile);
        //Perform Item SelectListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), FirebaseAuth.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.memories:
                        startActivity(new Intent(getApplicationContext(), PostsActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


    }

    private void displayUser(){

        //Set up display places
        userName = (TextView) findViewById(R.id.my_username);
        userProfName = (TextView) findViewById(R.id.my_profile_name);
        userEmail = (TextView) findViewById(R.id.my_email);
        userProfileImage = (CircleImageView) findViewById(R.id.my_profile_pic);


        user = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                String providerId = profile.getProviderId();

                // UID specific to the provider
                String uid = profile.getUid();

                // Name, email address, and profile photo Url
                String name = profile.getDisplayName();
                String email = profile.getEmail();
                Uri photoUrl = profile.getPhotoUrl();

                //Display Information
                userName.setText(name);
                userProfName.setText(name);
                userEmail.setText("Email :"+email);
                userProfileImage.setImageURI(photoUrl);




            }

        }

    }


    private void showSignInOptions() {

        user = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();

        if (user!=null) {
            Toast.makeText(this,""+user.getEmail(),Toast.LENGTH_SHORT).show();
            displayUser();
            btn_sign_out.setEnabled(true);


        }else  {
            startActivityForResult(

                    AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).setTheme(R.style.MyTheme).build(), MY_REQUEST_CODE

            );


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==MY_REQUEST_CODE){
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode==RESULT_OK)
            {
                //get user
                FirebaseUser user = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();
                //show email on Toast
                Toast.makeText(this,"Logged as :"+user.getEmail(),Toast.LENGTH_SHORT).show();
                //Set Button Signout
                btn_sign_out.setEnabled(true);
                //finish();
                startActivity(getIntent());

            }
            else {
                Toast.makeText(this, ""+response.getError().getMessage(), Toast.LENGTH_SHORT).show();

            }


        }

    }


}
