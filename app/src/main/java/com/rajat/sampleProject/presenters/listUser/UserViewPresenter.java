package com.rajat.sampleProject.presenters.listUser;


import com.rajat.sampleProject.views.listUser.UserRowView;

public interface UserViewPresenter {
    int getUsersCount();
    void setClickedUser(int index);
    void onBindUserRowViewAtPosition(int position,UserRowView userRowView);
}
