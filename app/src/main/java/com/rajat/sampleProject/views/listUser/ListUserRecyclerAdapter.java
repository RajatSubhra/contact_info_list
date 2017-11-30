package com.rajat.sampleProject.views.listUser;


import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rajat.sampleProject.MainApplication;
import com.rajat.sampleProject.R;
import com.rajat.sampleProject.presenters.listUser.UserViewPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListUserRecyclerAdapter extends RecyclerView.Adapter<ListUserRecyclerAdapter.UserViewHolder>{
    Context context;

    @Inject
    UserViewPresenter presenter;

    ListUserRecyclerAdapter(Application application){
        ((MainApplication) application).getAppComponent().inject(this);
//        presenter = new UserViewPresenterImpl();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();



        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_user, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(v);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        presenter.onBindUserRowViewAtPosition(position,holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getUsersCount();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements UserRowView{

        @BindView(R.id.userName)
        TextView userNameTextField;

        @BindView(R.id.email)
        TextView emailTextField;


        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @OnClick(R.id.userRowView)
        void clickRow(){
            presenter.setClickedUser(getAdapterPosition());
        }


        @Override
        public void setUserName(String userName) {
            userNameTextField.setText(userName);
        }

        @Override
        public void setUserEmail(String email) {
            emailTextField.setText(email);
        }

        @Override
        public void goToDetailFragment() {
            ((ListUserActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, new DetailFragment()).addToBackStack(null).commit();
        }
    }
}
