package use_case.searchfriend;

import entity.Anime;
import use_case.search.SearchDataAccessInterface;
import use_case.search.SearchOutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;
public class SearchfriendInteractor implements SearchfriendInputBoundary {
    final SearchfriendDataAccessInterface resultsDataAccessObject;
    final SearchfriendOutputBoundary resultsPresenter;

    public SearchfriendInteractor(SearchfriendDataAccessInterface searchDataAccessObject, SearchfriendOutputBoundary searchOutputBoundary) {
        this.resultsDataAccessObject = searchDataAccessObject;
        this.resultsPresenter = searchOutputBoundary;
    }

    @Override
    public void execute(SearchfriendInputData searchfriendInputData) {

    }
}
