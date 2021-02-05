package com.shakil.homeapp.activities.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.model.dashboard.Dashboard;
import com.shakil.homeapp.activities.activities.room.NewRoomActivity;
import java.util.ArrayList;


public class RecyclerRoomDashboardAdapter extends RecyclerView.Adapter<RecyclerRoomDashboardAdapter.ViewHolder> {

    private ArrayList<Dashboard> dashboardList;
    private Context context;

    public RecyclerRoomDashboardAdapter(ArrayList<Dashboard> dashboardList, Context context) {
        this.dashboardList = dashboardList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout_room_dashboard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.totalRoom.setText(dashboardList.get(position).getTotal_room());
        holder.totalEarnings.setText(dashboardList.get(position).getTotal_earnings());
        holder.adddNewRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, NewRoomActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dashboardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView adddNewRoom;
        TextView totalRoom , totalEarnings;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            adddNewRoom = itemView.findViewById(R.id.mAddMasterRoom);
            totalRoom = itemView.findViewById(R.id.total_rooms);
            totalEarnings = itemView.findViewById(R.id.total_earnings);
        }
    }
}
