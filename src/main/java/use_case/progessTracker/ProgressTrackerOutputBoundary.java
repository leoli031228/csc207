package use_case.progessTracker;

import use_case.login.LoginOutputData;

public interface ProgressTrackerOutputBoundary {
    void prepareSuccessView(ProgressTrackerOutputData results);

    void prepareFailView(String noResults);
}
