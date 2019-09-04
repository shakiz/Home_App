package com.shakil.homeapp.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.model.RoomModel;
import java.util.ArrayList;

public class RecyclerRoomListAdapter extends RecyclerView.Adapter<RecyclerRoomListAdapter.ViewHolder> {

    private ArrayList<RoomModel> arrayList;
    private Context context;

    public RecyclerRoomListAdapter(ArrayList<RoomModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout_room_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.roomName.setText("Name : "+arrayList.get(position).getRoomName());
        holder.ownerName.setText("Owner : "+arrayList.get(position).getOwnerName());
        holder.startDate.setText("Start date : "+arrayList.get(position).getStartDate());
        holder.lastPaid.setText("Last Paid : "+arrayList.get(position).getLastPaidMonth());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView roomName, ownerName, startDate, lastPaid;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roomName = itemView.findViewById(R.id.roomName);
            ownerName = itemView.findViewById(R.id.roomOwner);
            startDate = itemView.findViewById(R.id.startMonth);
            lastPaid = itemView.findViewById(R.id.lastPaid);
        }
    }
}