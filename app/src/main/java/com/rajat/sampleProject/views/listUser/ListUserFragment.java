package com.rajat.sampleProject.views.listUser;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rajat.sampleProject.MainApplication;
import com.rajat.sampleProject.R;
import com.rajat.sampleProject.presenters.listUser.ListUserPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListUserFragment extends Fragment implements ListUserView  {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.user_list)
    RecyclerView recyclerView;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Inject
    ListUserPresenter presenter;



    public ListUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainApplication) getActivity().getApplication()).getAppComponent().inject(this);
        View view =  inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this,view);
        //presenter = new ListUserPresenterImpl();

        presenter.onCreate(this);
        return  view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        recyclerView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showSuccess() {
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ListUserRecyclerAdapter(getActivity().getApplication());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showError() {
        Toasty.error(getContext(), "Something went wrong", Toast.LENGTH_LONG, true).show();
    }

}
