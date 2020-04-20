/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 03/03/20 10:37                                               -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.post;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thunder.project.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DetailPostActivity extends AppCompatActivity {

    TextView nameDetailTextView,descriptionDetailTextView,dateDetailTextView,categoryDetailTextView;
    ImageView postDetailImageView;

    private void initializeWidgets(){
        nameDetailTextView = findViewById(R.id.nameDetailTextView);
        descriptionDetailTextView = findViewById(R.id.descriptionDetailTextView);
        categoryDetailTextView = findViewById(R.id.categoryDetailTextView);
        postDetailImageView = findViewById(R.id.memoryDetailImageView);
        dateDetailTextView = findViewById(R.id.dateDetailTextView);
    }

    private String getDateToday(){
        DateFormat dateFormat=new SimpleDateFormat("yyyy/mm/dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        return today;
    }

    private String getRandomCategory(){
        String[] categories={"What a View!","5 star Visit!","Now that's a monument!!"};
        Random random = new Random();
        int index = random.nextInt(categories.length-1);
        return categories[index];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_details);

        initializeWidgets();

        //Receive data from itemsactivity from API
        Intent i = this.getIntent();
        String name = i.getExtras().getString("NAME_KEY");
        String description =i.getExtras().getString("DESCRIPTION_KEY");
        String imageURL = i.getExtras().getString("IMAGE_KEY");

        //set received data to textviews and image views
        nameDetailTextView.setText(name);
        descriptionDetailTextView.setText(description);
        dateDetailTextView.setText("DATE:"+ getDateToday());
        categoryDetailTextView.setText("CATEGORY: "+ getRandomCategory());
        Picasso.get().load(imageURL).placeholder(R.drawable.placeholder).fit().centerCrop().into(postDetailImageView);
    }
}
