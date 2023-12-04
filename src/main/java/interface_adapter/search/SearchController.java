package interface_adapter.search;

import use_case.search.SearchInputBoundary;
import use_case.search.SearchInputData;

public class SearchController {
    final SearchInputBoundary searchUseCaseInteractor;
    public SearchController(SearchInputBoundary searchUseCaseInteractor) {
        this.searchUseCaseInteractor = searchUseCaseInteractor;
    }

    public void execute(String title) {
        SearchInputData searchInputData = new SearchInputData(
                title);

       // pass in the name of the title, invoking the interactor
       searchUseCaseInteractor.execute(searchInputData);
    }
}

