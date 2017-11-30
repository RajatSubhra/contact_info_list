package com.rajat.sampleProject.presenters.listUser;


import android.content.Context;

import com.rajat.sampleProject.models.DataManager.RestResponseManager;
import com.rajat.sampleProject.models.DataManager.RestResponseManagerImpl;
import com.rajat.sampleProject.models.User;
import com.rajat.sampleProject.views.listUser.UserRowView;

import java.util.List;

public class UserViewPresenterImpl implements UserViewPresenter{

    private final List<User> users;
    RestResponseManager sharedInstance;
    UserRowView rowView;

    // Production
    public UserViewPresenterImpl(Context context) {
        sharedInstance = RestResponseManagerImpl.getInstance(context);
        this.users = sharedInstance.getUsers();
    }

    // Test
    public UserViewPresenterImpl(RestResponseManager instance, List<User> demoUsers) {
        this.sharedInstance = instance;
        this.users = demoUsers;
    }

    @Override
    public int getUsersCount() {
        if (users!=null)
            return users.size();
        else
            return 0;
    }

    @Override
    public void setClickedUser(int index) {
        sharedInstance.setSelectedUser(index);
        rowView.goToDetailFragment();
    }

    @Override
    public void onBindUserRowViewAtPosition(int position, UserRowView userRowView) {
        if(users!=null && users.size()>position) {
            User user = users.get(position);
            this.rowView = userRowView;
            this.rowView.setUserName(user.getName());
            this.rowView.setUserEmail(user.getEmail());
        }
    }
}
