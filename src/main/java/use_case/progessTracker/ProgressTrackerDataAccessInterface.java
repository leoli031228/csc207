package use_case.progessTracker;

import entity.Media;
import entity.Profile;

public interface ProgressTrackerDataAccessInterface {
    void changeStatustoinProgress(Profile profile, Media title);
    boolean existsinInProgress(Profile profile,Media title);
    void changeStatustoFinished(Profile profile,Media title);

    boolean existsinWatchHistory(Profile profile, Media media);
}
