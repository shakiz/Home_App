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
        holder.meterOwner.setText("Owner : "+arrayList.get(position).getOwner());
        holder.presentUnit.setText("Present unit : "+arrayList.get(position).getPresent());
        holder.pastUnit.setText("Past unit : "+arrayList.get(position).getPast());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView meterName, meterOwner, presentUnit, pastUnit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meterName = itemView.findViewById(R.id.meterName);
            meterOwner = itemView.findViewById(R.id.meterOwner);
            presentUnit = itemView.findViewById(R.id.presentUnit);
            pastUnit = itemView.findViewById(R.id.pastUnit);
        }
    }
}
