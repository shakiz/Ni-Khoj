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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.shakil.ni_khoj.NewsFeedAdapter;
import com.shakil.ni_khoj.R;
import com.shakil.ni_khoj.utils.DataDump;

public class HomeFragment extends Fragment {
    private DataDump dataDump;
    private RecyclerView recyclerView;
    private ImageView newPost;
    private Dialog itemDialog;
    private RelativeLayout dialogLayout;

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
        recyclerView = view.findViewById(R.id.mRecyclerView);
        newPost = view.findViewById(R.id.newPost);
    }

    private void bindUiWithComponents() {
        setAdapter();

        newPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void setAdapter() {
        NewsFeedAdapter newsFeedAdapter = new NewsFeedAdapter(dataDump.dumpNewsFeedData(), getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsFeedAdapter);
        newsFeedAdapter.notifyDataSetChanged();
    }

    private void showDialog() {
        itemDialog = new Dialog(getContext());
        itemDialog.setContentView(R.layout.dialog_popup_new_post);
        customViewInit(itemDialog);
        itemDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Animation a = AnimationUtils.loadAnimation(itemDialog.getContext(), R.anim.push_up_in);
        dialogLayout.startAnimation(a);
        itemDialog.show();
    }

    private void customViewInit(Dialog itemDialog) {
        dialogLayout = itemDialog.findViewById(R.id.dialogLayout);
    }
}
