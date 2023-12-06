package use_case.filter;

import data_access.InMemoryFilterDataAccessObject;
import data_access.MockAnimeSearchDataAccessObject;
import junit.framework.TestCase;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterInteractorTest extends TestCase {

    void filterActionTest() {
        ArrayList<Integer> genreIDs = new ArrayList<>();
        genreIDs.add(1);
        FilterInputData inputTitle = new FilterInputData(genreIDs);
        FilterDataAccessInterface animeRepository = new InMemoryFilterDataAccessObject();

        FilterOutputBoundary successPresenter = new FilterOutputBoundary() {
            @Override
            public void prepareResultsView(FilterOutputData results) {
                // check if output data is correct
                Map<String, List<Object>> expectedResults = new HashMap<>();
                expectedResults.put("Naruto", List.of("Naruto",
                        "https://upload.wikimedia.org/wikipedia/en/9/94/NarutoCoverTankobon1.jpg", 2));
                assertEquals(expectedResults, results.getResults());
            }

            @Override
            public void prepareFailView(String noResults) {
                fail("Use case failure is unexpected");

            }
        };
        FilterInputBoundary interactor = new FilterInteractor(animeRepository, successPresenter);
        interactor.execute(inputTitle);
    }


}