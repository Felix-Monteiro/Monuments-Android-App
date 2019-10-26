/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 3/17/19 5:24 AM                                              -                       -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.home;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.thunder.project.R;
import com.thunder.project.Utils;
import com.thunder.project.adapter.RecyclerViewHomeAdapter;
import com.thunder.project.adapter.ViewPagerHeaderAdapter;
import com.thunder.project.model.Locations;
import com.thunder.project.model.Places;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity implements HomeView {


    @BindView(R.id.viewPagerHeader)
    ViewPager viewPagerPlace;
    @BindView(R.id.recycleLocation)
    RecyclerView recyclerViewLocation;

    HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        presenter=new HomePresenter(this);
        presenter.getPlaces();
        presenter.getLocations();

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
    }

    @Override
    public void setLocation(List<Locations.Location> location) {
        RecyclerViewHomeAdapter homeAdapter = new RecyclerViewHomeAdapter(location,this);
        recyclerViewLocation.setAdapter(homeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3, GridLayoutManager.VERTICAL, false);
        recyclerViewLocation.setLayoutManager(layoutManager);
        recyclerViewLocation.setNestedScrollingEnabled(true);
        homeAdapter.notifyDataSetChanged();


    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this,"Title",message);
    }

    // TODO 36 Overriding the interface

}
