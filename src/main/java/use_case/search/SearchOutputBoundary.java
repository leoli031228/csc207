package use_case.search;

public interface SearchOutputBoundary {
    void prepareResultsView(SearchOutputData results);
    void prepareFailView(String noResults);
}
