package com.rajat.sampleProject.presenters.person;

import com.rajat.sampleProject.views.person.PersonRowView;


public interface PersonViewPresenter {
    int getPersonsCount();
    void onBindPersonRowViewAtPosition(int position, PersonRowView personRowView);
    void setCurrentPerson(int position);
}
