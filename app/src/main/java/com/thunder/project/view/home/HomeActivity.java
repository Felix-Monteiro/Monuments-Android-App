/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 3/17/19 5:24 AM                                              -                       -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.thunder.project.Login.FirebaseAuth;
import com.thunder.project.R;
import com.thunder.project.Utils;
import com.thunder.project.adapter.RecyclerViewHomeAdapter;
import com.thunder.project.adapter.SearchAdapter;
import com.thunder.project.adapter.ViewPagerHeaderAdapter;
import com.thunder.project.model.Locations;
import com.thunder.project.model.Places;
import com.thunder.project.view.detail.DetailActivity;
import com.thunder.project.view.location.LocationActivity;
import com.thunder.project.view.post.PostsActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity implements HomeView {

    public static final String EXTRA_LOCATION="location";
    public static final String EXTRA_POSITION="position";
    public static final String EXTRA_DETAIL = "detail";

    @BindView(R.id.viewPagerHeader) ViewPager viewPagerPlace;
    @BindView(R.id.recycleLocation) RecyclerView recyclerViewLocation;

    HomePresenter presenter;
    //search
    EditText search_edit_text;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    ArrayList<String> strPlaceList;
    ArrayList<String> strLocationList;
    ArrayList<String> strImageList;
    SearchAdapter searchAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        presenter=new HomePresenter(this);

        //search bar
        search_edit_text= (EditText) findViewById(R.id.searchView);
        recyclerView= (RecyclerView) findViewById(R.id.rv);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseUser = com.google.firebase.auth.FirebaseAuth.getInstance().getCurrentUser();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        strPlaceList = new ArrayList<>();
        strLocationList = new ArrayList<>();
        strImageList = new ArrayList<>();

        search_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()){
                    setAdapter(s.toString());

                }else {
                    strLocationList.clear();
                    strPlaceList.clear();
                    strImageList.clear();
                    recyclerView.removeAllViews();
                }

            }
        });


        //close search bar

        presenter.getPlaces();
        presenter.getLocations();

        navigationBar();


    }

    //search
    public void setAdapter(final String searchString){

        databaseReference.child("Monuments").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                strLocationList.clear();
                strPlaceList.clear();
                strImageList.clear();
                recyclerView.removeAllViews();

                int counter = 0;

                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String monumentid=snapshot.getKey();//if I can send this to placeName in DetailPresenter
                    String strPlace=snapshot.child("/places/0/strPlace").getValue(String.class);
                    String strLocation=snapshot.child("/places/0/strLocation").getValue(String.class);
                    String strImage=snapshot.child("/places/0/strPlaceThumb").getValue(String.class);


                    if (strPlace.toLowerCase().contains(searchString.toLowerCase())){
                        strPlaceList.add(strPlace);
                        strLocationList.add(strLocation);
                        strImageList.add(strImage);
                        counter++;

                    }
                    else if (strLocation.toLowerCase().contains(searchString.toLowerCase())){
                            strPlaceList.add(strPlace);
                            strLocationList.add(strLocation);
                            strImageList.add(strImage);
                            counter++;

                        }

                    if (counter == 15){
                        break;
                    }

                }
                searchAdapter = new SearchAdapter(HomeActivity.this,strPlaceList,strLocationList,strImageList);
                recyclerView.setAdapter(searchAdapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //close search


    public void navigationBar(){
        //Navigation barView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);
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



    @Override
    public void showLoading() {
    findViewById(R.id.shimmerPlace).setVisibility(View.VISIBLE);
    findViewById(R.id.shimmerLocation).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerPlace).setVisibility(View.GONE);
        findViewById(R.id.shimmerLocation).setVisibility(View.GONE);
    }

    @Override
    public void setPlace(List<Places.Place> place) {
        ViewPagerHeaderAdapter headerAdapter = new ViewPagerHeaderAdapter(place,this);
        viewPagerPlace.setAdapter(headerAdapter);
        viewPagerPlace.setPadding(20,0,150,0);
        headerAdapter.notifyDataSetChanged();



        headerAdapter.setOnItemClickListener((view, position) -> {
         //Toast.makeText(this,place.get(position).getStrPlace(), Toast.LENGTH_SHORT).show();
            TextView placeName = view.findViewById(R.id.placeName);
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(EXTRA_DETAIL, placeName.getText().toString());
            startActivity(intent);

        });

    }

    @Override
    public void setLocation(List<Locations.Location> location) {
        RecyclerViewHomeAdapter homeAdapter = new RecyclerViewHomeAdapter(location,this);
        recyclerViewLocation.setAdapter(homeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3, GridLayoutManager.VERTICAL, false);
        recyclerViewLocation.setLayoutManager(layoutManager);
        recyclerViewLocation.setNestedScrollingEnabled(true);
        homeAdapter.notifyDataSetChanged();

        homeAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent(this, LocationActivity.class);
            intent.putExtra(EXTRA_LOCATION,(Serializable) location);
            intent.putExtra(EXTRA_POSITION,position);
            startActivity(intent);

        });

    }

    @Override
    public void onErrorLoading(String message) {

        Utils.showDialogMessage(this,"Title",message);
    }

}
