package com.rajat.sampleProject.presenters.person;

import com.rajat.sampleProject.models.DataManager.PersonDataManager;
import com.rajat.sampleProject.models.DataManager.PersonDataManagerImpl;
import com.rajat.sampleProject.models.Person;
import com.rajat.sampleProject.views.person.PersonView;

import java.util.ArrayList;

public class PersonPresenterImpl implements PersonPresenter {

    private PersonView personView;
    ArrayList<Person> personArrayList;
    PersonDataManager personDataManager;

    // For actual implementation
    public PersonPresenterImpl(){
        personDataManager = PersonDataManagerImpl.getSharedInstance();
    }

    // For test
    public PersonPresenterImpl(PersonDataManager dataManager){
        personDataManager = dataManager;
    }

    @Override
    public void onCreate(PersonView view) {
        personView = view;
        personArrayList = (ArrayList<Person>) personDataManager.getPersons();
        personView.loadData();
    }

    @Override
    public void onDestroy() {
        personView = null;
    }
}
