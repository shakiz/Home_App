package com.shakil.homeapp.activities.utils;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.homeapp.activities.adapter.RecyclerMeterListAdapter;
import com.shakil.homeapp.activities.adapter.RecyclerRoomListAdapter;

public class RecyclerAdapter {
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private Context context;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setMeterRecyclerAdapter(RecyclerView recyclerView , int orientation, RecyclerMeterListAdapter recyclerMeterListAdapter){
        layoutManager = new LinearLayoutManager(context,orientation,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerMeterListAdapter);
        recyclerMeterListAdapter.notifyDataSetChanged();
    }

    public void setRoomRecyclerAdapter(RecyclerView recyclerView , int orientation, RecyclerRoomListAdapter recyclerRoomListAdapter){
        layoutManager = new LinearLayoutManager(context,orientation,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerRoomListAdapter);
        recyclerRoomListAdapter.notifyDataSetChanged();
    }
}
