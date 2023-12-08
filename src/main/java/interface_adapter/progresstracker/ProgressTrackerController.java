package interface_adapter.progresstracker;

import entity.Media;
import entity.User;
import use_case.progessTracker.ProgressTrackerInputBoundary;
import use_case.progessTracker.ProgressTrackerInputData;

public class ProgressTrackerController {
    final ProgressTrackerInputBoundary userProgressTrackerInteractor;
    public ProgressTrackerController(ProgressTrackerInputBoundary userProgressTrackerInteractor) {
        this.userProgressTrackerInteractor = userProgressTrackerInteractor;
    }

    public void execute(User user, Media media, String current_status) {
        ProgressTrackerInputData progtrackInputData = new ProgressTrackerInputData(user,
                media, current_status);
        userProgressTrackerInteractor.execute(progtrackInputData);
    }
}
