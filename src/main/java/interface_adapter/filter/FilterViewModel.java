package interface_adapter.filter;

import interface_adapter.ViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.signup.SignupState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class FilterViewModel extends ViewModel {
    public static final String FILTER_DROPDOWN_LABEL = "Genres";
    public static final String TITLE_LABEL = "Filter by genre";


    private FilterState state = new FilterState();

    public FilterViewModel() {
        super("filter");
    }
    public void setState(FilterState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);



    public void firePropertyChanged() {
        support.firePropertyChange("filter state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public FilterState getState() {
        return state;
    }
}
