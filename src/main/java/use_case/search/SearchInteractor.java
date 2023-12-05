package use_case.search;

import entity.Anime;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchInteractor implements SearchInputBoundary {
    final SearchDataAccessInterface resultsDataAccessObject;
    final SearchOutputBoundary resultsPresenter;

    public SearchInteractor(SearchDataAccessInterface searchDataAccessObject, SearchOutputBoundary searchOutputBoundary) {
        this.resultsDataAccessObject = searchDataAccessObject;
        this.resultsPresenter = searchOutputBoundary;
    }
    @Override
    public void execute(SearchInputData searchInputData) {
        // ask DAO to fetch all the data (the entities)
        // input data (the title) specifies witch entities
        if (resultsDataAccessObject.resultsFound(searchInputData.getTitle())){
            // collect results in an Output Data object
            // pass the Output Data invoking the Presenter

            SearchOutputData searchOutputData = new SearchOutputData(
                    resultsDataAccessObject.searchTitle(searchInputData.getTitle()) );
            resultsPresenter.prepareResultsView(searchOutputData);
        }
        resultsPresenter.prepareFailView("No results found.");


    }
}
