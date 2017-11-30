package com.rajat.sampleProject.presenters.listUser;


import android.content.Context;
import android.util.Log;

import com.rajat.sampleProject.models.DataManager.RestResponseManager;
import com.rajat.sampleProject.models.DataManager.RestResponseManagerImpl;
import com.rajat.sampleProject.views.listUser.ListUserView;

public class ListUserPresenterImpl implements ListUserPresenter {
    ListUserView listUserView;
    RestResponseManager restResponseManager;

    // For Production
    public ListUserPresenterImpl(Context context){
        restResponseManager = RestResponseManagerImpl.getInstance(context);
    }

    // For Test
    public ListUserPresenterImpl(RestResponseManager restResponseManager){
        this.restResponseManager = restResponseManager;
    }


    @Override
    public void onCreate(ListUserView view) {

        Log.d("Fragment Presenter","onCreate Presenter");
        this.listUserView = view;
        listUserView.showProgress();
        restResponseManager.fetchUsers(this);
    }

    @Override
    public void onDestroy() {
        listUserView = null;
    }



    @Override
    public void onSuccess() {
        if(listUserView!=null) {
            listUserView.hideProgress();
            listUserView.showSuccess();
        }
    }

    @Override
    public void onFailure() {
        if(listUserView!=null) {
            listUserView.hideProgress();
            listUserView.showError();
        }
    }
}
