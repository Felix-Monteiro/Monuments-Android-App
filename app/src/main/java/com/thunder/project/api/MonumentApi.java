/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                              -
 - Last modified 3/17/19 5:24 AM                                              -                        -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.api;

import com.thunder.project.model.Locations;
import com.thunder.project.model.Places;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MonumentApi {


    @GET("/%3fidPlace=52966.json?print=pretty")
    Call<Places> getPlace();

    @GET("/%3fidLocation=52933.json?print=pretty")
    Call<Locations> getLocations();

    @GET("/{l}")
    Call<Places> getPlaceByLocation(@Path("l")String location);

    @GET("/{m}")
    Call<Places> getPlacesByName(@Path("m") String placeName);

}
