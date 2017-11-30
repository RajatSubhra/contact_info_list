package com.rajat.sampleProject.dagger;

/**
 * Created by Raj on 25/11/17.
 */


import com.rajat.sampleProject.models.DataManager.RestResponseManagerImpl;
import com.rajat.sampleProject.views.detail.DetailActivity;
import com.rajat.sampleProject.views.listUser.DetailFragment;
import com.rajat.sampleProject.views.listUser.ListUserFragment;
import com.rajat.sampleProject.views.listUser.ListUserRecyclerAdapter;
import com.rajat.sampleProject.views.person.PersonActivity;
import com.rajat.sampleProject.views.person.PersonRecyclerAdapter;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class,PresenterModule.class,NetworkModule.class})
public interface AppComponent {
    void inject(ListUserFragment target);
    void inject(ListUserRecyclerAdapter target);
    void inject(DetailFragment target);
    void inject(RestResponseManagerImpl target);
    void inject(PersonActivity target);
    void inject(PersonRecyclerAdapter target);
    void inject(DetailActivity target);
}
