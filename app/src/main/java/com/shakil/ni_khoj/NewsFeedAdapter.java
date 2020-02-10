package com.shakil.ni_khoj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.ni_khoj.models.NewFeedModel;
import java.util.ArrayList;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {

    private ArrayList<NewFeedModel> newFeedLists;
    private Context context;

    public NewsFeedAdapter(ArrayList<NewFeedModel> newFeedLists, Context context) {
        this.newFeedLists = newFeedLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_recycler_news_feed,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewFeedModel feedModel = newFeedLists.get(position);
        holder.UserName.setText(feedModel.getUserName());
        holder.PostDate.setText(feedModel.getPostDate());
        holder.Description.setText(feedModel.getDescription());
        holder.Location.setText(feedModel.getLocation());
        holder.imageIcon.setImageResource(feedModel.getImageIcon());
    }

    @Override
    public int getItemCount() {
        return newFeedLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView UserName,PostDate,Description,Location;
        ImageView imageIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            UserName = itemView.findViewById(R.id.UserName);
            PostDate = itemView.findViewById(R.id.PostDate);
            Description = itemView.findViewById(R.id.Description);
            Location = itemView.findViewById(R.id.Location);
            imageIcon = itemView.findViewById(R.id.imageIcon);
        }
    }
}
