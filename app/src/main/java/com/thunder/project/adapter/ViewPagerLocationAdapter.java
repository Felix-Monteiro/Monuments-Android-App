/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 28/10/19 11:17                                               -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.thunder.project.model.Locations;
import com.thunder.project.view.location.LocationFragment;

import java.util.List;

public class ViewPagerLocationAdapter extends FragmentPagerAdapter {

    private List<Locations.Location> locations;

    public ViewPagerLocationAdapter(FragmentManager fm, List<Locations.Location>locations){
        super(fm);
        this.locations=locations;
    }

    @Override
    public Fragment getItem(int i){
        LocationFragment fragment=new LocationFragment();
        Bundle args= new Bundle();
        args.putString("EXTRA_DATA_NAME", locations.get(i).getStrLocation());
        args.putString("EXTRA_DATA_DESC", locations.get(i).getStrLocationDescription());
        args.putString("EXTRA_DATA_IMAGE", locations.get(i).getStrLocationThumb());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return locations.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return locations.get(position).getStrLocation();
    }
}
