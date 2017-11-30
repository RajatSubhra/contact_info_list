package com.rajat.sampleProject.presenters.detail;


import com.rajat.sampleProject.models.DataManager.PersonDataManager;
import com.rajat.sampleProject.models.DataManager.PersonDataManagerImpl;
import com.rajat.sampleProject.models.Person;
import com.rajat.sampleProject.views.detail.DetailView;

public class DetailPresenterImpl implements DetailPresenter{

    private DetailView detailView;
    Person currentPerson;
    PersonDataManager sharedInstance;

    // for production
    public DetailPresenterImpl(){
        sharedInstance = PersonDataManagerImpl.getSharedInstance();
    }


    // for test
    public DetailPresenterImpl(PersonDataManager personDataManager){
        this.sharedInstance = personDataManager;
    }
    @Override
    public void onCreate(DetailView view) {
        detailView = view;
        currentPerson = sharedInstance.getSelectedPerson();
        detailView.setLikeButton(currentPerson.isLiked());
        detailView.setPersonAge(currentPerson.getAge());
        detailView.setPersonName(currentPerson.getFirstName()+" "+currentPerson.getLastName());
        detailView.setPersonPhoneNum(currentPerson.getPhoneNum());
        detailView.setPhotoURL(currentPerson.getPhotoUrl());
    }

    @Override
    public void onDestroy() {
        detailView = null;
    }

    @Override
    public void onLikeButtonClick() {
        if (currentPerson.isLiked()) {
            currentPerson.setLiked(false);
        }
        else {
            currentPerson.setLiked(true);
        }
        detailView.setLikeButton(currentPerson.isLiked());
    }
}
