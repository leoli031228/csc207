package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary {
    private final SearchViewModel searchViewModel;
    private ViewManagerModel viewManagerModel;

    public SearchPresenter(SearchViewModel searchViewModel,
                           ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
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
