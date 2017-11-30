package com.rajat.sampleProject.presenters.person;


import com.rajat.sampleProject.views.person.PersonView;

public interface PersonPresenter {
    void onCreate(PersonView view);
    void onDestroy();
}
