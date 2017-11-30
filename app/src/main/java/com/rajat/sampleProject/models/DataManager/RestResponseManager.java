package com.rajat.sampleProject.models.DataManager;


import com.rajat.sampleProject.models.User;
import com.rajat.sampleProject.presenters.listUser.ListUserPresenter;

import java.util.List;

public interface RestResponseManager {
    List<User> getUsers();
    void setUsers(List<User> users);
    void setSelectedUser(int index);
    User getSelectedUser();
    void fetchUsers(ListUserPresenter callBack);
}
