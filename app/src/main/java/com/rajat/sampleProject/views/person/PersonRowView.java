package com.rajat.sampleProject.views.person;


public interface PersonRowView {
    void setPersonName(String personName);
    void setLikeImage(boolean isLiked);
    void setPhotoURL(String photoURL);
    void showDetailActivity();
}
