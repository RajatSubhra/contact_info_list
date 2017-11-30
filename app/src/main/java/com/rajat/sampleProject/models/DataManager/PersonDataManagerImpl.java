package com.rajat.sampleProject.models.DataManager;


import com.rajat.sampleProject.models.Person;

import java.util.ArrayList;
import java.util.List;


// Creating a singleton class that will manage Data.
public class PersonDataManagerImpl implements PersonDataManager {
    private static PersonDataManagerImpl sharedInstance;
    private final List<Person> persons = new ArrayList<>();
    private Person selectedPerson;
    private PersonDataManagerImpl(){
        initPersons();
    }

    public static PersonDataManagerImpl getSharedInstance(){
        if (sharedInstance == null) {
            sharedInstance = new PersonDataManagerImpl();
        }
        return  sharedInstance;

    }

    private void initPersons() {
        persons.add(new Person("Rajat", "Chatterjee", 27, "111-222-3337", "https://i1.wp.com/turntotech.io/wp-content/uploads/2017/03/RAJAT_bio-photo-color-corrected_edited_v2_03.20.17.jpg", false));
        persons.add(new Person("Aditya", "Narayan", 42, "111-222-3337", "https://i0.wp.com/turntotech.io/wp-content/uploads/2015/05/aditya.png?zoom=2&fit=568%2C568", false));
        persons.add(new Person("Kaushik", "Biswas", 42, "111-222-3337", "https://i1.wp.com/turntotech.io/wp-content/uploads/2015/12/kaushik-biswas.jpg?zoom=2&fit=398%2C398", true));
        persons.add(new Person("Teddy", "Angelous", 53, "111-222-3337", "https://i1.wp.com/turntotech.io/wp-content/uploads/2015/05/teddy-square.png?zoom=2&fit=466%2C466", false));
        persons.add(new Person("Jesse", "Shali", 27, "111-222-3333", "https://i1.wp.com/turntotech.io/wp-content/uploads/2016/08/jesse-photo_466x466.jpg?zoom=2&fit=466%2C466", false));
        persons.add(new Person("Patrick", "Sanders", 30, "111-222-3353", "https://i1.wp.com/turntotech.io/wp-content/uploads/2016/07/patrick-sanders-1.png", false));
        persons.add(new Person("Harish", "Shadadpuri", 60, "111-232-3353", "https://i0.wp.com/turntotech.io/wp-content/uploads/2015/05/harish.png", false));
        persons.add(new Person("Carlos", "Ramirez", 51, "121-232-3353", "https://i1.wp.com/turntotech.io/wp-content/uploads/2015/05/carlos.png?zoom=2&fit=400%2C400", false));
        persons.add(new Person("Patricia", "Vega", 44, "141-232-3353", "https://i0.wp.com/turntotech.io/wp-content/uploads/2016/08/facepatty.jpg?zoom=2&fit=200%2C200", false));
        persons.add(new Person("Will", "Larche", 39, "151-232-3353", "https://i0.wp.com/turntotech.io/wp-content/uploads/2017/03/WLarche_Advisory_001_photo_466x466.jpg?zoom=2&fit=466%2C466", false));
    }


    @Override
    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public Person getSelectedPerson() {
        return selectedPerson;
    }

    @Override
    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }
}
