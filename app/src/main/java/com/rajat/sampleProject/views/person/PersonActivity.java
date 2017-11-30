package com.rajat.sampleProject.views.person;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rajat.sampleProject.MainApplication;
import com.rajat.sampleProject.R;
import com.rajat.sampleProject.presenters.person.PersonPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;



public class PersonActivity extends AppCompatActivity implements PersonView {

    @BindView(R.id.messages_list)
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Inject
    PersonPresenter presenter;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onCreate(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_activity);
        ButterKnife.bind(this);
        //presenter = new PersonPresenterImpl();
        ((MainApplication) getApplication()).getAppComponent().inject(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onDestroy();
    }

    @Override
    public void loadData() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PersonRecyclerAdapter(getApplication());
        recyclerView.setAdapter(adapter);
    }
}
