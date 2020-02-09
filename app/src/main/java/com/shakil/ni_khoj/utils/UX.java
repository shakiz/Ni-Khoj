package com.shakil.ni_khoj.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.shakil.ni_khoj.R;
import java.util.ArrayList;

public class UX {
    private Context context;
    public Dialog loadingDialog;
    private ArrayAdapter arrayAdapter;

    public UX(Context context) {
        this.context = context;
        loadingDialog = new Dialog(context);
    }

    public void getLoadingView(){
        loadingDialog.setContentView(R.layout.loading_layout);
        loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        loadingDialog.setCanceledOnTouchOutside(false);
        loadingDialog.show();
    }

    public void removeLoadingView(){
        if (loadingDialog.isShowing()) loadingDialog.cancel();
    }

    public void setSpinnerAdapter(Spinner spinner, ArrayList<String> spinnerItemList) {
        arrayAdapter = new ArrayAdapter<>(context,R.layout.spinner_drop,spinnerItemList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    public void setSpinnerAdapter(Spinner spinner, String[] spinnerItemList) {
        arrayAdapter = new ArrayAdapter<>(context, R.layout.spinner_drop,spinnerItemList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }
}
