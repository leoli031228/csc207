package use_case.progessTracker;

public interface ProgressTrackerOutputBoundary {
    void prepareSuccessView(ProgressTrackerOutputData results);

    void prepareFailView(String error);
}
