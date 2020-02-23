package com.shakil.ni_khoj.fragments;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shakil.ni_khoj.adapter.LocationListAdapter;
import com.shakil.ni_khoj.adapter.NewsFeedAdapter;
import com.shakil.ni_khoj.R;
import com.shakil.ni_khoj.models.location.LocationMaster;
import com.shakil.ni_khoj.models.newsfeed.NewFeedModel;
import com.shakil.ni_khoj.utils.DataDump;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private DataDump dataDump;
    private RecyclerView newFeedRecycler , locationListRecycler;
    private ImageView newPost;
    private Dialog addNewPostDialog , locationDialog;
    private RelativeLayout addNewPostDialogLayout , locationListDialogLayout;
    private TextView Location;
    private ArrayList<LocationMaster> locationList;
    private ArrayList<NewFeedModel> newsFeedList;
    private Button savePost;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        bindUiWithComponents();
    }

    private void init(View view) {
        dataDump = new DataDump(getContext());
        newFeedRecycler = view.findViewById(R.id.mRecyclerView);
        newPost = view.findViewById(R.id.newPost);
    }

    private void bindUiWithComponents() {
        dataDump.newsFeed(new DataDump.onNewFeedComplete() {
            @Override
            public void onComplete() {
                newsFeedList = dataDump.getNewsFeedList();
                setNewsFeedAdapter();
            }
        });

        newPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void setNewsFeedAdapter() {
        NewsFeedAdapter newsFeedAdapter = new NewsFeedAdapter(newsFeedList, getContext());
        newFeedRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        newFeedRecycler.setAdapter(newsFeedAdapter);
        newsFeedAdapter.notifyDataSetChanged();
    }

    private void showDialog() {
        addNewPostDialog = new Dialog(getContext());
        addNewPostDialog.setContentView(R.layout.dialog_popup_new_post);
        addNewPostDialog.setCanceledOnTouchOutside(false);
        customViewInit(addNewPostDialog);
        addNewPostDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Animation a = AnimationUtils.loadAnimation(addNewPostDialog.getContext(), R.anim.push_up_in);
        addNewPostDialogLayout.startAnimation(a);
        addNewPostDialog.show();
    }

    private void customViewInit(Dialog itemDialog) {
        addNewPostDialogLayout = itemDialog.findViewById(R.id.dialogLayout);
        Location = itemDialog.findViewById(R.id.Location);
        savePost = itemDialog.findViewById(R.id.savePost);

        bindUiWithItemDialog();
    }

    private void bindUiWithItemDialog() {
        Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocationDialog();
            }
        });

        savePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewPostDialog.dismiss();
            }
        });
    }

    private void getLocationDialog() {
        locationDialog = new Dialog(getContext());
        locationDialog.setContentView(R.layout.dialog_pop_location_list);
        locationDialog.setCanceledOnTouchOutside(false);
        customInitLocationDialog(locationDialog);
        addNewPostDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Animation a = AnimationUtils.loadAnimation(locationDialog.getContext(), R.anim.push_up_in);
        locationListDialogLayout.startAnimation(a);
        locationDialog.show();
    }

    private void customInitLocationDialog(Dialog locationDialog) {
        locationListDialogLayout = locationDialog.findViewById(R.id.locationDialogLayout);
        locationListRecycler = locationDialog.findViewById(R.id.LocationRecyclerView);
        locationList = new ArrayList<>();

        bindUiWithLocationListDialog();
    }

    private void bindUiWithLocationListDialog() {
        dataDump.location(new DataDump.onLocationComplete() {
            @Override
            public void onComplete() {
                locationList = dataDump.getLocationList();
                setLocationAdapter();
            }
        });

    }

    private void setLocationAdapter() {
        LocationListAdapter locationListAdapter = new LocationListAdapter(locationList, getContext(), new LocationListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(LocationMaster locationMaster) {
                locationDialog.dismiss();
                Location.setText(locationMaster.getResult().getName());
            }
        });
        locationListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        locationListRecycler.setAdapter(locationListAdapter);
        locationListAdapter.notifyDataSetChanged();
    }
}
