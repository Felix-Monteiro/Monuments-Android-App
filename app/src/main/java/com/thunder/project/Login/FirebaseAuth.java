/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 22/02/20 19:15                                               -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.Login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.thunder.project.R;
import com.thunder.project.view.post.PostsActivity;

import java.util.Arrays;
import java.util.List;

public class FirebaseAuth extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 1424 ; //Any Number
    List<AuthUI.IdpConfig> providers;
    Button btn_sign_out;
    Button open_activity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebase_auth);

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

        open_activity_button = (Button)findViewById(R.id.open_activity_button);
        open_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirebaseAuth.this, PostsActivity.class));
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
    }

    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).setTheme(R.style.MyTheme).build(),MY_REQUEST_CODE
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==MY_REQUEST_CODE){
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode==RESULT_OK){
                //get user
                FirebaseUser user = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();
                //show email on Toast
                Toast.makeText(this,""+user.getEmail(),Toast.LENGTH_SHORT).show();
                //Set Button Signout
                btn_sign_out.setEnabled(true);
                open_activity_button.setEnabled(true);

            }
            else {
                Toast.makeText(this, ""+response.getError().getMessage(), Toast.LENGTH_SHORT).show();
            }

        }

    }

}
