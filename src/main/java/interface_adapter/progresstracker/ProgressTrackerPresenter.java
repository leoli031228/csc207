package interface_adapter.progresstracker;

import entity.Media;
import interface_adapter.ViewManagerModel;
import use_case.progessTracker.ProgressTrackerOutputBoundary;
import use_case.progessTracker.ProgressTrackerOutputData;

import java.util.List;
import java.util.Map;

public class ProgressTrackerPresenter implements ProgressTrackerOutputBoundary {
    private final ProgressTrackerViewModel progressTrackerViewModel;
    private ViewManagerModel viewManagerModel;

    public ProgressTrackerPresenter(ViewManagerModel viewManagerModel,
                                    ProgressTrackerViewModel progressTrackerViewModel){
        this.viewManagerModel = viewManagerModel;
        this.progressTrackerViewModel = progressTrackerViewModel;
    }

    @Override
    public void prepareSuccessView(ProgressTrackerOutputData user) {
        List<Media> watchlist = user.getWatchlist();
        List<Media> inprogress = user.getInProgress();
        List<Media> watchhistory = user.getWatchHistory();
        Map<String, List<Media>> statuses = user.getResults();

        ProgressTrackerState progressTrackerState = progressTrackerViewModel.getState();

        progressTrackerState.setWatchlist(watchlist);
        progressTrackerState.setInProgress(inprogress);
        progressTrackerState.setWatchHistory(watchhistory);
        progressTrackerState.setStatuses(statuses);

        this.progressTrackerViewModel.setState(progressTrackerState);
        progressTrackerViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(progressTrackerViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        ProgressTrackerState progressTrackerState = progressTrackerViewModel.getState();
        progressTrackerState.setError(error);
        progressTrackerViewModel.firePropertyChanged();
    }
}
