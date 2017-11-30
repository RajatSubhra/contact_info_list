package com.rajat.sampleProject.dagger;

import android.content.Context;

import com.rajat.sampleProject.presenters.detail.DetailPresenter;
import com.rajat.sampleProject.presenters.detail.DetailPresenterImpl;
import com.rajat.sampleProject.presenters.listUser.DetailUserPresenter;
import com.rajat.sampleProject.presenters.listUser.DetailUserPresenterImpl;
import com.rajat.sampleProject.presenters.listUser.ListUserPresenter;
import com.rajat.sampleProject.presenters.listUser.ListUserPresenterImpl;
import com.rajat.sampleProject.presenters.listUser.UserViewPresenter;
import com.rajat.sampleProject.presenters.listUser.UserViewPresenterImpl;
import com.rajat.sampleProject.presenters.person.PersonPresenter;
import com.rajat.sampleProject.presenters.person.PersonPresenterImpl;
import com.rajat.sampleProject.presenters.person.PersonViewPresenter;
import com.rajat.sampleProject.presenters.person.PersonViewPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raj on 25/11/17.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    ListUserPresenter provideListUserPresenter(Context context){
        return new ListUserPresenterImpl(context);
    }

    @Provides
    @Singleton
    DetailUserPresenter provideDetailUserPresenter(Context context){
        return  new DetailUserPresenterImpl(context);
    }

    @Provides
    @Singleton
    UserViewPresenter provideUserViewPresenter(Context context){
        return new UserViewPresenterImpl(context);
    }

    @Provides
    @Singleton
    PersonPresenter providePersonPresenter(){
        return new PersonPresenterImpl();
    }

    @Provides
    @Singleton
    PersonViewPresenter providePersonViewPresenter(){
        return new PersonViewPresenterImpl();
    }

    @Provides
    @Singleton
    DetailPresenter provideDetailPresenter(Context context){
        return new DetailPresenterImpl();
    }
}
