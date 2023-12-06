package use_case.progessTracker;

import entity.Profile;

public class ProgressTrackerInteractor implements  ProgressTrackerInputBoundary{
    final ProgressTrackerDataAccessInterface progtrackDataAccessObject;
    final ProgressTrackerOutputBoundary progtrackPresenter;

    public ProgressTrackerInteractor(ProgressTrackerDataAccessInterface progtrackDataAccessInterface,
                                     ProgressTrackerOutputBoundary progtrackOutputBoundary) {
        this.progtrackDataAccessObject = progtrackDataAccessInterface;
        this.progtrackPresenter = progtrackOutputBoundary;
    }
    @Override
    public void execute(ProgressTrackerInputData inputData) {
        Profile profile = inputData.getProfile();

        if (inputData.getStatus().equals("Watchlist")) {
            // error if the media is already in the In Progress list
            if(progtrackDataAccessObject.existsinInProgress(profile, inputData.getMedia())) {
                progtrackPresenter.prepareFailView("This title is already in your In-Progress list.");
            }
            // the status in the input is the current status, so if the current status is Watchlist
            // its next status should be inprogress
            progtrackDataAccessObject.changeStatustoinProgress(profile, inputData.getMedia());
        }
        else if (inputData.getStatus().equals("In Progress")) {
            if(progtrackDataAccessObject.existsinWatchHistory(profile, inputData.getMedia())) {
                progtrackPresenter.prepareFailView("This title is already in your WatchHistory.");
            }
            // if the current status is In Progress then the next status should be Completed
            progtrackDataAccessObject.changeStatustoFinished(profile, inputData.getMedia());
        }

        ProgressTrackerOutputData progtrackOutputData = new ProgressTrackerOutputData(inputData.getUser(), false);
        progtrackPresenter.prepareSuccessView(progtrackOutputData);

    }

}
