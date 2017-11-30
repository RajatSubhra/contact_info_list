package com.rajat.sampleProject.presenters.person;


import com.rajat.sampleProject.models.DataManager.PersonDataManager;
import com.rajat.sampleProject.models.DataManager.PersonDataManagerImpl;
import com.rajat.sampleProject.models.Person;
import com.rajat.sampleProject.views.person.PersonRowView;

import java.util.ArrayList;
import java.util.List;

public class PersonViewPresenterImpl implements PersonViewPresenter {

    private final ArrayList<Person> persons;
    PersonRowView rowView;
    PersonDataManager personDataManager;



    // used for production code
    public PersonViewPresenterImpl() {
        personDataManager = PersonDataManagerImpl.getSharedInstance();
        this.persons = (ArrayList<Person>)personDataManager.getPersons();
    }

    // used for test purpose
    public PersonViewPresenterImpl(PersonDataManager personDataManager, List<Person> personList) {
        this.personDataManager = personDataManager;
        persons = new ArrayList<>(personList);
    }

    @Override
    public int getPersonsCount() {
        return persons.size();
    }

    @Override
    public void onBindPersonRowViewAtPosition(int position, PersonRowView personRowView) {
        Person person = persons.get(position);
        this.rowView = personRowView;
        this.rowView.setLikeImage(person.isLiked());
        this.rowView.setPersonName(person.getFirstName()+" "+person.getLastName());
        this.rowView.setPhotoURL(person.getPhotoUrl());
    }

    @Override
    public void setCurrentPerson(int position){
        personDataManager.setSelectedPerson(persons.get(position));
        this.rowView.showDetailActivity();
    }
}
