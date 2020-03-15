/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 03/03/20 10:16                                               -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.post;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.thunder.project.Login.FirebaseAuth;
import com.thunder.project.R;
import com.thunder.project.view.home.HomeActivity;

public class PostsActivity extends AppCompatActivity {
    private Button openPostsActivityBtn,openUploadActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        openPostsActivityBtn = findViewById(R.id.openMemoriesActivityBtn);
        openUploadActivityBtn = findViewById(R.id.openUploadActivityBtn);

        openPostsActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Intent i= new Intent(PostsActivity.this, ItemsActivity.class);
                startActivity(i);
            }

        });

        openUploadActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i=new Intent(PostsActivity.this,UploadActivity.class);
                startActivity(i);
            }
        });

        navigationBar();

    }


    public void navigationBar(){
        //Navigation barView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.memories);
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
}
