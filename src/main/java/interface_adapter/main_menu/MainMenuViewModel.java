package interface_adapter.main_menu;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainMenuViewModel extends ViewModel {

    public static final String LOGIN_LABEL = "Already have an account?";
    public static final String LOGIN_BUTTON_LABEL = "Login";
    public static final String TITLE_LABEL = "Create Your Account";
    public static final String USERNAME_LABEL = "Choose username";
    public static final String EMAIL_LABEL = "Enter your Email";
    public static final String PASSWORD_LABEL = "Choose password";
    public static final String REPEAT_PASSWORD_LABEL = "Enter password again";

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";

    public MainMenuViewModel() {
        super("main menu");
    }


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View


}