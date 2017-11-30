# Description 

### Part I 

* Shows a list of people and details.
* Shows name, a heart icon, and an avatar image as a list
* When clicking on an item, all information is displayed in detail with the ability favorite an item
* A "Favorite" button is created on the detail page - this changes the drawable image from one to the other on the main list.
 

### Part II 

Created an Activity to be a fragment container, in which the app displays two different
fragments, Fragment A and Fragment B.
 
* Shows a list of users and their email addresses as a GET API Request to server in Fragment A
Displays the information retrieved from the below endpoint http://jsonplaceholder.typicode.com/users
* Fragment B displays a specific person’s detailed information, including their phone number, their website, and an image of their location on a map.
* Fragment B replaces Fragment A in the container when a user is selected, leaving Fragment A in the back stack.
* In Fragment B:
 o Selecting the user’s phone number, an implicit intent to call that number is launched.
 o Selecting the user’s website, an implicit intent to open the web browser to that URL is launched.
 o Google Static Maps API is used to fetch a maps image link with a latitude and longitude.
 
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
 
### Prerequisites
 
* Android API Level >v14
* Android Build Tools >v25
