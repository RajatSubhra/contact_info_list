# Full APP demo video link  
https://youtu.be/XQ1rUiEwvBE

# Download apk from 
https://github.com/RajatSubhra/contact_info_list/raw/master/android-sample-fun.apk  

# Description 

### Part I 

<img width="200" alt="screen shot 2017-11-29 at 9 25 39 pm" src="https://user-images.githubusercontent.com/4134043/33410086-9743fe16-d54c-11e7-89a7-e27ade160aa4.png"><img width="201" alt="screen shot 2017-11-29 at 9 26 19 pm" src="https://user-images.githubusercontent.com/4134043/33410087-974f71d8-d54c-11e7-8e9c-74158bb827a6.png"><img width="202" alt="screen shot 2017-11-29 at 9 26 44 pm" src="https://user-images.githubusercontent.com/4134043/33410088-975b86d0-d54c-11e7-9450-d570a6fa6b18.png">

* Shows a list of people and details.
  * Shows name, a heart icon, and an avatar image as a list
  * When clicking on an item, all information is displayed in detail with the ability favorite an item
  * A "Favorite" button is created on the detail page - this changes the drawable image from one to the other on the main list.
 

### Part II 

<img width="200" alt="screen shot 2017-11-29 at 9 27 11 pm" src="https://user-images.githubusercontent.com/4134043/33410089-9786f572-d54c-11e7-92b9-e750c2cb2799.png"><img width="203" alt="screen shot 2017-11-29 at 9 27 27 pm" src="https://user-images.githubusercontent.com/4134043/33410090-97974404-d54c-11e7-94cc-34a5bd500a3f.png">

Created an Activity to be a fragment container, in which the app displays two different
fragments, Fragment A and Fragment B.
 
* Shows a list of users and their email addresses as a GET API Request to server in Fragment A
  * Displays the information retrieved from the below endpoint http://jsonplaceholder.typicode.com/users
* Fragment B displays a specific person’s detailed information, including their phone number, their website, and an image of their location on a map.
* Fragment B replaces Fragment A in the container when a user is selected, leaving Fragment A in the back stack.
* In Fragment B:
  * Selecting the user’s phone number, an implicit intent to call that number is launched.
  * Selecting the user’s website, an implicit intent to open the web browser to that URL is launched.
  * Google Static Maps API is used to fetch a maps image link with a latitude and longitude.

### Prerequisites
 
* Android API Level >v14
* Android Build Tools >v25
 
## Implementation 
 
I used an architecture based on the MVP pattern and for more clean architecture I created a singleton DataManager class (kind of DAO pattern) to manage the Models and to interact with the presenter.
 
I used Daggar2 for Dependency injection, ButterKnife for viewBinding, used RxJava + Retrofit for Network Call, Picasso for image downloading to my imageview, Parse JSON using GSON library, used Ripple effect if click to particular person and used Animation transition when change from one activity to another and lottie animation in start activity. I handled network errors and Used up-to-date animation and transition effects.
 
 
 
## Libraries

* **RxJava**
* **Retrofit**
* **Dagger2**
* **ButterKnife**
* **Gson**
* **Picasso**

