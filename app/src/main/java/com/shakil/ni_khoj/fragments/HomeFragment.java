package com.shakil.ni_khoj.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shakil.ni_khoj.NewsFeedAdapter;
import com.shakil.ni_khoj.R;
import com.shakil.ni_khoj.utils.DataDump;

public class HomeFragment extends Fragment {
    private DataDump dataDump;
    private RecyclerView recyclerView;

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
    }

    private void bindUiWithComponents() {

        NewsFeedAdapter newsFeedAdapter = new NewsFeedAdapter(dataDump.dumpNewsFeedData(), getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsFeedAdapter);
        newsFeedAdapter.notifyDataSetChanged();
    }

}
