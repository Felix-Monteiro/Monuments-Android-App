/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 03/03/20 10:36                                               -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.post;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.thunder.project.R;
import com.thunder.project.adapter.PostsRecyclerAdapter;
import com.thunder.project.model.Posts;

import java.util.ArrayList;
import java.util.List;

public class ItemsActivity extends AppCompatActivity implements PostsRecyclerAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private PostsRecyclerAdapter mAdapter;
    private ProgressBar mProgressBar;
    private FirebaseStorage mStorage;
    private DatabaseReference mDatabaseRef;
    private ValueEventListener mDBListener;
    private List<Posts> mPosts;
    private FirebaseUser mUser;
    private StorageReference mStorageReff;


    private void openDetailActivity(String[] data){
        Intent intent = new Intent(this,DetailPostActivity.class);
        intent.putExtra("NAME_KEY",data[0]);
        intent.putExtra("DESCRIPTION_KEY",data[1]);
        intent.putExtra("IMAGE_KEY",data[2]);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_items);

        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mProgressBar = findViewById(R.id.DataLoaderProgressBar);
        mProgressBar.setVisibility(View.VISIBLE);

        mPosts = new ArrayList<>();
        mAdapter = new PostsRecyclerAdapter(ItemsActivity.this,mPosts);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(ItemsActivity.this);

        mUser = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();
        mStorage = FirebaseStorage.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("memories_uploads/"+mUser.getUid().toString());

        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
            //Gets all the posts of the logged user
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mPosts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Posts upload = postSnapshot.getValue(Posts.class);
                    upload.setKey(postSnapshot.getKey());
                    mPosts.add(upload);
                }
                mAdapter.notifyDataSetChanged();
                mProgressBar.setVisibility(View.GONE);
            }

            //Error Handling
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ItemsActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    //opens DetailActivity on click
    public void onItemClick (int position){
        Posts clickedPost = mPosts.get(position);
        String[] postData = {clickedPost.getName(),clickedPost.getDescription(),clickedPost.getImageURL()};
        openDetailActivity(postData);
    }

    @Override
    public void onShowItemClick (int position){
        Posts clickedPost = mPosts.get(position);
        String[] postData = {clickedPost.getName(),clickedPost.getDescription(),clickedPost.getImageURL()};
        openDetailActivity(postData);
    }

    //Deletes a Post
    @Override
    public void onDeleteItemClick(int position){
        Posts selectedItem = mPosts.get(position);
        final String selectedKey = selectedItem.getKey();

        StorageReference imageRef = mStorage.getReferenceFromUrl(mUser.getUid()+selectedItem.getImageURL());
        imageRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mDatabaseRef.child(selectedKey).removeValue();
                Toast.makeText(ItemsActivity.this,"Item deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void onDestroy(){
        super.onDestroy();
        mDatabaseRef.removeEventListener(mDBListener);
    }
}
