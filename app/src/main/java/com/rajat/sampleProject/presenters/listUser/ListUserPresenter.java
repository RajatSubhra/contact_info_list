package com.rajat.sampleProject.presenters.listUser;


import com.rajat.sampleProject.views.listUser.ListUserView;

public interface ListUserPresenter {

    void onSuccess();
    void onFailure();
    void onCreate(ListUserView view);
    void onDestroy();
}
