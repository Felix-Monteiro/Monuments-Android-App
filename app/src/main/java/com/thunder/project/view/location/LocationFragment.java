/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 28/10/19 11:20                                               -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.location;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.thunder.project.R;
import com.thunder.project.model.Places;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationFragment extends Fragment implements LocationView {

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.imageLocation)
    ImageView imageLocation;
    @BindView(R.id.imageLocationBg)
    ImageView imageLocationBg;
    @BindView(R.id.textLocation)
    TextView textLocation;

    AlertDialog.Builder descDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_location,container,false );
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view,@NonNull Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void setPlaces(List<Places.Place> places) {

    }

    @Override
    public void onErrorLoading(String message) {

    }
}
