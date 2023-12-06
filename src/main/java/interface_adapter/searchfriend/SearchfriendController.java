package interface_adapter.searchfriend;

import use_case.searchfriend.SearchfriendInputBoundary;
import use_case.searchfriend.SearchfriendInputData;

public class SearchfriendController {
    final SearchfriendInputBoundary searchfriendUseCaseInteractor;
    public SearchfriendController(SearchfriendInputBoundary searchfriendUseCaseInteractor) {
        this.searchfriendUseCaseInteractor = searchfriendUseCaseInteractor;
    }

    public void execute(String username) {
        SearchfriendInputData searchfirendInputData = new SearchfriendInputData(
                username);

        // pass in the name of the title, invoking the interactor
        searchfriendUseCaseInteractor.execute(searchfirendInputData);
    }
}
