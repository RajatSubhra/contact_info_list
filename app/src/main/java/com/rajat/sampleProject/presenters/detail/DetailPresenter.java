package com.rajat.sampleProject.presenters.detail;


import com.rajat.sampleProject.views.detail.DetailView;

public interface DetailPresenter {
    void onCreate(DetailView view);
    void onDestroy();
    void onLikeButtonClick();
}

