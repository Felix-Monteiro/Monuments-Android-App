/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 03/03/20 10:16                                               -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.thunder.project.R;
import com.thunder.project.model.Posts;

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
    }
}
