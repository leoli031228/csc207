package interface_adapter.searchfriend;

import interface_adapter.ViewManagerModel;
import interface_adapter.search.SearchViewModel;
import use_case.search.SearchOutputData;
import use_case.searchfriend.SearchfriendOutputBoundary;
import use_case.searchfriend.SearchfriendOutputData;

public class SearchfriendPresenter implements SearchfriendOutputBoundary{
    private final SearchfriendViewModel searchfriendViewModel;
    private ViewManagerModel viewManagerModel;
    public SearchfriendPresenter(SearchfriendViewModel searchfriendViewModel,
                           ViewManagerModel viewManagerModel) {
        this.searchfriendViewModel = searchfriendViewModel;
        this.viewManagerModel = viewManagerModel;

    }
    @Override
    public void prepareResultsView(SearchOutputData results) {
        // If title results are found, load resulting titles and their images


    }

    @Override
    public void prepareFailView(String noResults) {
        // If no results are found, show message "No results found"

    }
}
