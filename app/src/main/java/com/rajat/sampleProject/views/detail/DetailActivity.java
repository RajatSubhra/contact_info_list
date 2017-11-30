package com.rajat.sampleProject.views.detail;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rajat.sampleProject.MainApplication;
import com.rajat.sampleProject.R;
import com.rajat.sampleProject.presenters.detail.DetailPresenter;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;


public class DetailActivity extends AppCompatActivity implements DetailView {

    @BindView(R.id.ivAvatar)
    ImageView avatarImageView;

    @BindView(R.id.btnLike)
    Button buttonLike;

    @BindView(R.id.personName)
    TextView personNameTextView;

    @BindView(R.id.personAge)
    TextView personAgeTextView;

    @BindView(R.id.personPhone)
    TextView personPhoneTextView;

    @Inject
    DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);
        ((MainApplication) getApplication()).getAppComponent().inject(this);
        //presenter = new DetailPresenterImpl();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onCreate(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onDestroy();
    }

    @Override
    public void setPersonName(String personName) {
        Toasty.success(this, personName, Toast.LENGTH_SHORT, true).show();
        setTitle(personName);
        personNameTextView.setText(personName);
    }

    @Override
    public void setPersonAge(int personAge) {
        personAgeTextView.setText(Integer.toString(personAge));
    }

    @Override
    public void setPersonPhoneNum(String personPhoneNum) {
        personPhoneTextView.setText(personPhoneNum);
    }



    @Override
    public void setLikeButton(boolean isLiked) {
        GradientDrawable background = (GradientDrawable) buttonLike.getBackground();
        if(isLiked){

            buttonLike.setText("Liked");
            buttonLike.setTextColor(Color.WHITE);
            background.setColor(getResources().getColor(R.color.red));
        }else{
            buttonLike.setText("Like");
            buttonLike.setTextColor(Color.BLACK);
            background.setColor(getResources().getColor(R.color.light_yellow));
        }
    }

    @Override
    public void setPhotoURL(String photoURL) {
        Picasso.with(this)
                .load(photoURL)
                .placeholder(R.drawable.ic_action_account_circle_40)
                .into(avatarImageView);
    }

    @OnClick(R.id.btnLike)
    void likeButtonClick(){
        presenter.onLikeButtonClick();
    }
}
