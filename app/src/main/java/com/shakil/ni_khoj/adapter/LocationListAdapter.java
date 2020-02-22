package com.shakil.ni_khoj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.ni_khoj.R;
import com.shakil.ni_khoj.models.location.LocationMaster;
import java.util.ArrayList;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.ViewHolder> {

    private ArrayList<LocationMaster> locationList;
    private Context context;

    public LocationListAdapter(ArrayList<LocationMaster> locationList, Context context) {
        this.locationList = locationList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_recycler_location_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LocationMaster locationMaster = locationList.get(position);
        holder.LocationName.setText(locationMaster.getResult().getName());
        holder.Address.setText(locationMaster.getResult().getFormattedAddress());
        holder.Distance.setText("Dummy");
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView LocationName , Address , Distance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            LocationName = itemView.findViewById(R.id.LocationName);
            Address = itemView.findViewById(R.id.Address);
            Distance = itemView.findViewById(R.id.Distance);
        }
    }
}
