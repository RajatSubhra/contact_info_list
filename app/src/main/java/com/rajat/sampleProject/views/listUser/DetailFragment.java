package com.rajat.sampleProject.views.listUser;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajat.sampleProject.MainApplication;
import com.rajat.sampleProject.R;
import com.rajat.sampleProject.presenters.listUser.DetailUserPresenter;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements DetailUserView {


    @BindView(R.id.selectedUserName)
    TextView selectedUserName;

    @BindView(R.id.selectedUserWebsite)
    TextView selectedUserWebSite;

    @BindView(R.id.selectedUserPhoneNumber)
    TextView selectedUserPhoneNumber;

    @BindView(R.id.imageView3)
    ImageView mapView;

    @Inject
    DetailUserPresenter presenter;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainApplication) getActivity().getApplication()).getAppComponent().inject(this);

        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this,view);
        //presenter = new DetailUserPresenterImpl();
        presenter.onCreate(this);
        return  view;
    }

    @OnClick(R.id.selectedUserPhoneNumber)
    void callToPhoneNumber(){
        Intent phoneNumberIntent = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel", selectedUserPhoneNumber.getText().toString(), null));
        getActivity().startActivity(phoneNumberIntent);
    }

    @OnClick(R.id.selectedUserWebsite)
    void goToWebSite(){
        Intent webIntent = new Intent();
        webIntent.setAction(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse("http://www."+selectedUserWebSite.getText().toString()));
        getActivity().startActivity(webIntent);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
    }

    @Override
    public void setUserName(String userName) {
        selectedUserName.setText(userName);
    }

    @Override
    public void setUserPhoneNumber(String userPhoneNumber) {
        selectedUserPhoneNumber.setText(userPhoneNumber.split("x")[0]);
    }

    @Override
    public void setUserWebSite(String webSite) {
        selectedUserWebSite.setText(webSite);
    }

    @Override
    public void setPhoto(String url) {
        Picasso.with(getContext())
                .load(url)
                .placeholder(R.drawable.ic_warning_outline_white)
                .into(mapView);
    }
}
