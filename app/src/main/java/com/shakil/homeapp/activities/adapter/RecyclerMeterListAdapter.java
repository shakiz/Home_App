package com.shakil.homeapp.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.model.MeterModel;
import java.util.ArrayList;

public class RecyclerMeterListAdapter extends RecyclerView.Adapter<RecyclerMeterListAdapter.ViewHolder> {

    private ArrayList<MeterModel> arrayList;
    private Context context;

    public RecyclerMeterListAdapter(ArrayList<MeterModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout_meter_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.meterName.setText("Name : "+arrayList.get(position).getMeterName());
        holder.roomName.setText("Room : "+arrayList.get(position).getAssociateRoom());
        holder.meterType.setText("Meter Type : "+arrayList.get(position).getMeterType());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView meterName, roomName, meterType;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meterName = itemView.findViewById(R.id.meterName);
            roomName = itemView.findViewById(R.id.roomName);
            meterType = itemView.findViewById(R.id.meterType);
        }
    }
}
