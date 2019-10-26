/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 3/17/19 5:24 AM                                              -                      -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.home;

import com.thunder.project.model.Locations;
import com.thunder.project.model.Places;

import java.util.List;

public interface HomeView {


    void showLoading();
    void hideLoading();
    void setPlace(List<Places.Place> place);
    void setLocation(List<Locations.Location> location);
    void onErrorLoading(String message);

}
