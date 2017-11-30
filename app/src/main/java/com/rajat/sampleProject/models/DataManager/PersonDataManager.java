package com.rajat.sampleProject.models.DataManager;


import com.rajat.sampleProject.models.Person;

import java.util.List;

public interface PersonDataManager {
    List<Person> getPersons();
    Person getSelectedPerson();
    void setSelectedPerson(Person selectedPerson);
}
