package com.rajat.sampleProject;

import android.app.Application;

import com.rajat.sampleProject.dagger.AppComponent;
import com.rajat.sampleProject.dagger.AppModule;
import com.rajat.sampleProject.dagger.DaggerAppComponent;

/**
 * Created by Raj on 25/11/17.
 */

public class MainApplication extends Application {
    private AppComponent appComponent;
    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(MainApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

}
