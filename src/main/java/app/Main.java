package app;

import data_access.FileProfileDataAccessObject;
import data_access.FileUserDataAccessObject;

import data_access.MediaApiDB;
import interface_adapter.filter.FilterViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;

import interface_adapter.switch_view.SwitchViewController;
import use_case.search.SearchDataAccessInterface;
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

        //CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        //JPanel views = new JPanel(cardLayout);
        //application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        //new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        FilterViewModel filterViewModel = new FilterViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
             userDataAccessObject = new FileUserDataAccessObject("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

// <<<<<<< david
//         ProgressTrackerViewModel progressTrackerViewModel = new ProgressTrackerViewModel();
//         ProgressTrackerState state = new ProgressTrackerState();
//         state.setUser(userDataAccessObject.getUser());
//         state.setWatchlist(userDataAccessObject.getWatchlist());
//         state.setInProgress(userDataAccessObject.getinProgress());
//         state.setWatchHistory(userDataAccessObject.getwatchHistory());
//         state.setStatuses(userDataAccessObject.getStatuses());
//         progressTrackerViewModel.setState(state);

//         ProgressTrackerView progressTrackerView = ProgressTrackerUseCaseFactory.create(
//                 viewManagerModel, progressTrackerViewModel, userDataAccessObject);
// =======
        FileProfileDataAccessObject profileDataAccessObject;
        try {
            profileDataAccessObject = new FileProfileDataAccessObject("./profiles.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // initialize API access object
        MediaApiDB mediaDataAccessObject = new MediaApiDB();
        MediaApiDB filterDataAccessObject = new MediaApiDB();;

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);


//        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
//        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);


//        LoggedInView loggedInView = new LoggedInView(loggedInViewModel, views, cardLayout, userDataAccessObject);
//        views.add(loggedInView, loggedInView.viewName);
  
        SearchView searchView = SearchUseCaseFactory.create(viewManagerModel, searchViewModel, filterViewModel, mediaDataAccessObject, filterDataAccessObject);
        //views.add(searchView, searchView.viewName);

//        /* LoggedInView loggedInView = new LoggedInView(loggedInViewModel, views, cardLayout, userDataAccessObject);
//         views.add(loggedInView, loggedInView.viewName);
//        SearchFriendView searchFriendView = new SearchFriendView(userDataAccessObject, views, cardLayout, loggedInViewModel);
//        views.add(searchFriendView, searchFriendView.viewName);

// <<<<<<< david
//         assert progressTrackerView != null;
//         viewManagerModel.setActiveView(progressTrackerView.viewName);
// =======
        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
