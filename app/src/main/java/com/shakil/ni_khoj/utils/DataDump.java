package com.shakil.ni_khoj.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.shakil.ni_khoj.R;
import com.shakil.ni_khoj.models.location.LocationMaster;
import com.shakil.ni_khoj.models.location.Result;
import com.shakil.ni_khoj.models.newsfeed.NewFeedModel;
import java.util.ArrayList;

public class DataDump {
    private Context context;
    private ArrayList<LocationMaster> locationList;
    private UX ux;

    public DataDump(Context context) {
        this.context = context;
        ux = new UX(context);
        locationList = new ArrayList<>();
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

    private onLocationComplete onLocationComplete = null;

    public interface onLocationComplete {
        void onComplete();
    }

    public void location(onLocationComplete onLocationComplete){
        this.onLocationComplete = onLocationComplete;
        new BackgroundLocationLoad().execute();
    }

    private class BackgroundLocationLoad extends AsyncTask<String, Void, ArrayList<LocationMaster>> {

        @Override
        protected void onPreExecute() {
            ux.getLoadingView();
        }

        @Override
        protected ArrayList<LocationMaster> doInBackground(String... strings) {
            return doLocationData();
        }

        @Override
        protected void onPostExecute(ArrayList<LocationMaster> locationMasters) {
            if(onLocationComplete != null) {
                setLocationList(doLocationData());
                onLocationComplete.onComplete();
                ux.removeLoadingView();
            }
        }
    }

    private ArrayList<LocationMaster> doLocationData(){
        locationList.add(new LocationMaster(new Result("Rupayan Shelford, 20th Floor, 23/6 Mirpur Rd, Dhaka 1207","DataSoft")));
        locationList.add(new LocationMaster(new Result("House no: 12 Road no: 12, Dhaka 1209","Cefalo Bangladesh Ltd.")));
        locationList.add(new LocationMaster(new Result("A, 4 Rd 10, Dhaka 1212","WebAble Digital")));
        locationList.add(new LocationMaster(new Result("8th floor, Plot-02, Amtoli, Bir Uttam Ak Khandaker Rd, Dhaka 1212","Brain Station 23")));
        locationList.add(new LocationMaster(new Result("Green Grandeur (4th ,10th and 13th floor), Plot 58/E, Kemal Ataturk Avenue, Dhaka","NewsCred")));
        locationList.add(new LocationMaster(new Result("House# 7, Road# 2/C, Block# J, Dhaka 1212","BJIT Limited")));
        return locationList;
    }

    public void setLocationList(ArrayList<LocationMaster> locationList) {
        this.locationList = locationList;
    }

    public ArrayList<LocationMaster> getLocationList() {
        return locationList;
    }
}
