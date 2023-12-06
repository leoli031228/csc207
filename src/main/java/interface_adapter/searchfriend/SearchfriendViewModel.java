package interface_adapter.searchfriend;

import interface_adapter.ViewModel;
import interface_adapter.search.SearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchfriendViewModel extends ViewModel {

    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String TITLE_LABEL = "Search Friend View";

    private SearchfriendState state = new SearchfriendState();
    public SearchfriendViewModel() {
        super("search friend");
    }
    public void setState(SearchfriendState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public SearchfriendState getState() {
        return state;
    }
}
