package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.filter.FilterController;
import interface_adapter.filter.FilterPresenter;
import interface_adapter.filter.FilterViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import use_case.filter.FilterDataAccessInterface;
import use_case.filter.FilterInputBoundary;
import use_case.filter.FilterInteractor;
import use_case.filter.FilterOutputBoundary;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchDataAccessInterface;
import view.SearchView;
import view.SearchView;

import javax.swing.*;
import java.io.IOException;

public class SearchUseCaseFactory {

    //prevent instantiation.
    private SearchUseCaseFactory() {}

    public static SearchView create(
            ViewManagerModel viewManagerModel,
            SearchViewModel searchViewModel,
            FilterViewModel filterViewModel,
            SearchDataAccessInterface mediaDataAccessObject,
            FilterDataAccessInterface filterDataAccessObject) {

        try {
            SearchController searchController = createSearchUseCase(viewManagerModel, searchViewModel, mediaDataAccessObject);
            FilterController filterController = createFilterUseCase(viewManagerModel, filterViewModel, filterDataAccessObject);
            return new SearchView(searchController, filterController,
                    searchViewModel, filterViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }



    private static SearchController createSearchUseCase(
            ViewManagerModel viewManagerModel,
            SearchViewModel searchViewModel,
//            LoggedInViewModel loggedInViewModel,
            SearchDataAccessInterface mediaDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(searchViewModel, viewManagerModel);

        SearchInputBoundary searchInteractor = new SearchInteractor(
                mediaDataAccessObject, searchOutputBoundary);

        return new SearchController(searchInteractor);
    }
    private static FilterController createFilterUseCase(ViewManagerModel viewManagerModel,
                                                        FilterViewModel filterViewModel,
                                                        FilterDataAccessInterface filterDataAccessObject) {
        FilterOutputBoundary filterOutputBoundary = new FilterPresenter(filterViewModel, viewManagerModel);
        FilterInputBoundary filterInteractor = new FilterInteractor(filterDataAccessObject, filterOutputBoundary);
        return new FilterController(filterInteractor);
    }
}
