/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 3/17/19 5:24 AM                                              -                       -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.thunder.project.Login.FirebaseAuth;
import com.thunder.project.R;
import com.thunder.project.Utils;
import com.thunder.project.adapter.RecyclerViewHomeAdapter;
import com.thunder.project.adapter.ViewPagerHeaderAdapter;
import com.thunder.project.model.Locations;
import com.thunder.project.model.Places;
import com.thunder.project.view.detail.DetailActivity;
import com.thunder.project.view.location.LocationActivity;
import com.thunder.project.view.post.PostsActivity;

import java.io.Serializable;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        presenter=new HomePresenter(this);

        presenter.getPlaces();
        presenter.getLocations();



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
