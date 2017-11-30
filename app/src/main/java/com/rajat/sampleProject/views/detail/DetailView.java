package com.rajat.sampleProject.views.detail;


public interface DetailView {
    void setPersonName(String personName);
    void setPersonAge(int personAge);
    void setPersonPhoneNum(String personPhoneNum);
    void setLikeButton(boolean isLiked);
    void setPhotoURL(String photoURL);
}
