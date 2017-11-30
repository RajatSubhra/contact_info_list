package com.rajat.sampleProject.models.DataManager;


import android.content.Context;

import com.rajat.sampleProject.MainApplication;
import com.rajat.sampleProject.apis.Api;
import com.rajat.sampleProject.models.User;
import com.rajat.sampleProject.presenters.listUser.ListUserPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RestResponseManagerImpl implements RestResponseManager {

    private List<User> users;
    private User selectedUser;
    private static RestResponseManagerImpl sharedInstance;
    private ListUserPresenter callBack;

    @Inject
    Api restClientAPI;

    public static RestResponseManagerImpl getInstance(Context context) {
        if (sharedInstance == null){
            sharedInstance = new RestResponseManagerImpl(context);
        }
        return sharedInstance;
    }

    private RestResponseManagerImpl(Context context) {
        ((MainApplication) context.getApplicationContext()).getAppComponent().inject(this);
    }

    // Fetch all users from http://jsonplaceholder.typicode.com/users
    @Override
    public void fetchUsers(final ListUserPresenter callBack){

        this.callBack = callBack;
        restClientAPI.getAllUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResults,this::handleFailure);
    }

    private void handleFailure(Throwable throwable) {
        callBack.onFailure();
    }

    private void handleResults(List<User> users) {
        if (users!=null){
            sharedInstance.setUsers(users);
            callBack.onSuccess();
        }
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(int position) {
        this.selectedUser = users.get(position);
    }
}
