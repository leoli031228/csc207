/*

package app;


import data_access.FileUserDataAccessObject;
import data_access.FileProfileDataAccessObject;

//import data_access.FileUserDataAccessObject;


import data_access.InMemoryFilterDataAccessObject;
import data_access.MockAnimeSearchDataAccessObject;
import interface_adapter.filter.FilterViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;

import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Anime List Tracking Application");
        application.setSize(8000,5000);
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();

        SearchViewModel searchViewModel = new SearchViewModel();

//        FileUserDataAccessObject userDataAccessObject;
//        try {
//            userDataAccessObject = new FileUserDataAccessObject("./users.csv");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


//        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
//        views.add(signupView, signupView.viewName);
//
//        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
//        views.add(loginView, loginView.viewName);


        MockAnimeSearchDataAccessObject mediaDataAccessObject = new MockAnimeSearchDataAccessObject();
        InMemoryFilterDataAccessObject filterDataAccessObject = new InMemoryFilterDataAccessObject();

        SearchView searchView = SearchUseCaseFactory.create(viewManagerModel, searchViewModel, new FilterViewModel(),
                mediaDataAccessObject,
                filterDataAccessObject);


        FileProfileDataAccessObject profileDataAccessObject;
        try {
            profileDataAccessObject = new FileProfileDataAccessObject("./profiles.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);



        LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
        views.add(loggedInView, loggedInView.viewName);

//        SearchView searchView = new SearchView(searchViewModel);
//        views.add(searchView, searchView.viewName);

//        viewManagerModel.setActiveView(signupView.viewName);
//        viewManagerModel.firePropertyChanged();
        viewManagerModel.setActiveView(searchView.viewName);
        viewManagerModel.firePropertyChanged();



        application.pack();
        application.setVisible(true);
    }
}
*/
