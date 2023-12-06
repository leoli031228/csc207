package interface_adapter.progresstracker;

import interface_adapter.ViewModel;
import interface_adapter.signup.SignupState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ProgressTrackerViewModel extends ViewModel {

    public static final String WATCHLIST_LABEL = "Watchlist";
    public static final String INPROGRESS_LABEL = "In-Progress";
    public static final String WATCHHISTORY_LABEL = "Watch History";

    public static final String STATUS_LABEL = "Statuses";

    private ProgressTrackerState state = new ProgressTrackerState();

    public ProgressTrackerViewModel() {
        super("progress tracking");
    }
    public void setState(ProgressTrackerState state){
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ProgressTrackerState getState() {
        return state;
    }
}
