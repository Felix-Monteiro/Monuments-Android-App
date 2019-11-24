/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                              -
 - Last modified 3/17/19 5:24 AM                                              -                        -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.api;

import com.thunder.project.model.Locations;
import com.thunder.project.model.Places;
import com.thunder.project.view.location.LocationFragment;
import com.thunder.project.view.location.LocationPresenter;
import com.thunder.project.view.location.LocationView;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MonumentApi {

    @GET("?idPlace")
    Call<Places> getPlace();

    @GET("?idLocation")
    Call<Locations> getLocations();

    @GET("?")
    Call<Places> getPlaceByLocation(@Query("l")String location);

    @GET("?")
    Call<Places> getPlacesByName(@Query("m") String placeName);


}
