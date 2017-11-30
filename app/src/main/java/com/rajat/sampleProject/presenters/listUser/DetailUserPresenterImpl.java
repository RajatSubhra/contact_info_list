package com.rajat.sampleProject.presenters.listUser;

import android.content.Context;

import com.rajat.sampleProject.models.DataManager.RestResponseManager;
import com.rajat.sampleProject.models.DataManager.RestResponseManagerImpl;
import com.rajat.sampleProject.views.listUser.DetailUserView;

/**
 * Created by Raj on 15/11/17.
 */

public class DetailUserPresenterImpl implements DetailUserPresenter {

    private DetailUserView detailUserView;
    private RestResponseManager sharedInstance;

    public DetailUserPresenterImpl(Context context){
        sharedInstance = RestResponseManagerImpl.getInstance(context);
    }

    @Override
    public void onCreate(DetailUserView view) {

        this.detailUserView = view;
        detailUserView.setUserName(sharedInstance.getSelectedUser().getName());
        detailUserView.setUserPhoneNumber(sharedInstance.getSelectedUser().getPhone());
        detailUserView.setUserWebSite(sharedInstance.getSelectedUser().getWebsite());


        detailUserView.setPhoto(sharedInstance.getSelectedUser().fetchGoogleMapURL());
    }

    @Override
    public void onDestroy() {
        detailUserView = null;
    }
}
