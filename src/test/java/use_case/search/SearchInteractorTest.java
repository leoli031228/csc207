package use_case.search;

import data_access.MockAnimeSearchDataAccessObject;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchInteractorTest extends TestCase {

    @Test
    void resultsSuccessTest() {
        SearchInputData inputTitle = new SearchInputData("Naruto");
        SearchDataAccessInterface animeRepository = new MockAnimeSearchDataAccessObject();

        SearchOutputBoundary successPresenter = new SearchOutputBoundary() {
            @Override
            public void prepareResultsView(SearchOutputData results) {
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
        SearchInputBoundary interactor = new SearchInteractor(animeRepository, successPresenter);
        interactor.execute(inputTitle);
    }

    @Test
    void noResultsTest(){
        SearchInputData inputTitle = new SearchInputData("not an anime");
        SearchDataAccessInterface animeRepository = new MockAnimeSearchDataAccessObject();

        SearchOutputBoundary failurePresenter = new SearchOutputBoundary() {
            @Override
            public void prepareResultsView(SearchOutputData results) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String noResults) {
                assertEquals("No results found.", noResults);

            }
        };
    }
}