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
import retrofit2.http.Query;

public interface MonumentApi {

    @GET("?idPlace=52966")
    Call<Places> getPlace();


    @GET("?idLocation=52933")
    Call<Locations> getLocations();

    @GET("?idmain=p")//it is not getting the api
    Call<Places> getPlaceByLocation(@Query("p")String location);

}
