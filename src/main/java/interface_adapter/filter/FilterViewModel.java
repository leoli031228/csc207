package interface_adapter.filter;

import interface_adapter.ViewModel;
import interface_adapter.signup.SignupState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class FilterViewModel extends ViewModel {
    public static final String FILTER_DROPDOWN_LABEL = "Genres";
    public static final String TITLE_LABEL = "Filter by genre";


    private FilterState state = new FilterState();

    private PropertyChangeSupport support = new PropertyChangeSupport((this));

    public FilterViewModel() {
        super("filter");
    }

//    public void updateAnimeList() {
//        // Get selected genres from the view
//        String selectedGenre = view.getSelectedGenre();
//
//        // Update the model with the selected genre
//        // Call model methods to fetch and filter anime based on the selected genre
//
//        // Get the updated anime list from the model
//        List<String> updatedAnimeList = model.getAnimeList();
//
//        // Fire property change event before updating the view
//        propertyChangeSupport.firePropertyChange("animeList", null, updatedAnimeList);
//
//        // Update the view with the new anime list
//        view.updateAnimeList(updatedAnimeList);
//    }




    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public FilterState getState() {
        return state;
    }
}
