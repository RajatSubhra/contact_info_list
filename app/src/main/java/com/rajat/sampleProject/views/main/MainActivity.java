package com.rajat.sampleProject.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rajat.sampleProject.R;
import com.rajat.sampleProject.views.listUser.ListUserActivity;
import com.rajat.sampleProject.views.person.PersonActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.personCardView)
    void goToPersonActivity(){
        startActivity(new Intent(MainActivity.this, PersonActivity.class));
    }

    @OnClick(R.id.userCardView)
    void goToUserActivity(){
        startActivity(new Intent(MainActivity.this, ListUserActivity.class));
    }
}
