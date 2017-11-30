package com.rajat.sampleProject.views.person;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajat.sampleProject.MainApplication;
import com.rajat.sampleProject.R;
import com.rajat.sampleProject.presenters.person.PersonViewPresenter;
import com.rajat.sampleProject.views.detail.DetailActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonRecyclerAdapter.PersonViewHolder> {

    Context context;

    @Inject
    PersonViewPresenter presenter;

    PersonRecyclerAdapter(Application application){
        ((MainApplication) application).getAppComponent().inject(this);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_person_summary, parent, false);
        PersonViewHolder personViewHolder = new PersonViewHolder(v);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        presenter.onBindPersonRowViewAtPosition(position,holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getPersonsCount();
    }


    class PersonViewHolder extends RecyclerView.ViewHolder implements PersonRowView {

        @BindView(R.id.ivAvatarPerson)
        ImageView personAvatar;

        @BindView(R.id.ivIsLiked)
        ImageView isLikeImage;

        @BindView(R.id.name)
        TextView nameOfPerson;

        public PersonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.parent)
        public void onClick() {
            presenter.setCurrentPerson(getAdapterPosition());
        }

        @Override
        public void setPersonName(String personName) {
            nameOfPerson.setText(personName);
        }

        @Override
        public void setLikeImage(boolean isLiked) {
            if(isLiked){
                isLikeImage.setImageResource(R.drawable.ic_heart_filled);
            }
            else{
                isLikeImage.setImageResource(R.drawable.ic_heart_outline);
            }
        }

        @Override
        public void setPhotoURL(String photoURL) {
            Picasso.with(context)
                    .load(photoURL)
                    .placeholder(R.drawable.ic_action_account_circle_40)
                    .into(personAvatar);
        }

        @Override
        public void showDetailActivity() {
            Intent intent = new Intent(context,DetailActivity.class);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        }
    }


}
