package com.shakil.ni_khoj.utils;

import android.content.Context;

import com.shakil.ni_khoj.models.NewFeedModel;

import java.util.ArrayList;

public class DataDump {
    private Context context;

    public DataDump(Context context) {
        this.context = context;
    }

    public ArrayList<NewFeedModel> dumpNewsFeedData(){
        ArrayList<NewFeedModel> newFeedLists = new ArrayList<>();
        newFeedLists.add(new NewFeedModel("","","","",0));
        newFeedLists.add(new NewFeedModel("","","","",0));
        newFeedLists.add(new NewFeedModel("","","","",0));
        newFeedLists.add(new NewFeedModel("","","","",0));
        newFeedLists.add(new NewFeedModel("","","","",0));
        newFeedLists.add(new NewFeedModel("","","","",0));
        newFeedLists.add(new NewFeedModel("","","","",0));
        return newFeedLists;
    }
}
