package com.shakil.ni_khoj.utils;

import android.content.Context;
import com.shakil.ni_khoj.R;
import com.shakil.ni_khoj.models.NewFeedModel;
import java.util.ArrayList;

public class DataDump {
    private Context context;

    public DataDump(Context context) {
        this.context = context;
    }

    public ArrayList<NewFeedModel> dumpNewsFeedData(){

        ArrayList<NewFeedModel> newFeedLists = new ArrayList<>();
        newFeedLists.add(new NewFeedModel("Sakhawat Hossain","20-Feb-2019","Dhaka,Bangladesh",
                context.getResources().getString(R.string.dummy_description_1),0));
        newFeedLists.add(new NewFeedModel("Rifat Hossain","10-Jan-2019","Mumbai,India",
                context.getResources().getString(R.string.dummy_description_2),0));
        newFeedLists.add(new NewFeedModel("David Hangh","11-Jul-2020","Barisal,Dhaka,Bangladesh",
                context.getResources().getString(R.string.dummy_description_3),0));
        newFeedLists.add(new NewFeedModel("Rashed Hossain","02-Sep-2018","Las vegas, New York",
                context.getResources().getString(R.string.dummy_description_4),0));
        newFeedLists.add(new NewFeedModel("Foysal Arman","03-Aug-2019","Comilla,Dhaka,Bangladesh",
                context.getResources().getString(R.string.dummy_description_5),0));
        newFeedLists.add(new NewFeedModel("Jig Jag","10-Jan-2015","Chittagong,Dhaka,Bangladesh",
                context.getResources().getString(R.string.dummy_description_6),0));

        return newFeedLists;
    }
}
