/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 13/03/20 20:36                                               -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thunder.project.R;
import com.thunder.project.view.detail.DetailActivity;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    Context context;
    ArrayList<String> strPlaceList;
    ArrayList<String> strLocationList;
    ArrayList<String> strImageList;

    class SearchViewHolder extends RecyclerView.ViewHolder{

        ImageView monumentImage;
        TextView monName, monLocation;


        public SearchViewHolder(View itemView){
            super(itemView);
            monumentImage = (ImageView) itemView.findViewById(R.id.monImage);
            monName = (TextView) itemView.findViewById(R.id.monName);
            monLocation = (TextView) itemView.findViewById(R.id.monLocation);



        }
    }


    public SearchAdapter(Context context, ArrayList<String> strPlaceList, ArrayList<String> strLocationList, ArrayList<String> strImageList) {
        this.context = context;
        this.strPlaceList = strPlaceList;
        this.strLocationList = strLocationList;
        this.strImageList = strImageList;
    }

    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.search_list_items,parent,false);
        return new SearchAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        holder.monName.setText(strPlaceList.get(position));
        holder.monLocation.setText(strLocationList.get(position));
        Glide.with(context).asBitmap().load(strImageList.get(position)).placeholder(R.mipmap.ic_launcher_round).into(holder.monumentImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (strPlaceList != null){


                    Intent intent= new Intent(context,DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_DETAIL_SEARCHED, strPlaceList.get(position));
                    context.startActivity(intent);
                }

            } });

    }



    @Override
    public int getItemCount() {
        return strPlaceList.size();
    }

}
