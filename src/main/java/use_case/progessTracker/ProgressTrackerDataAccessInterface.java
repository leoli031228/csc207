package use_case.progessTracker;

import entity.Media;
import entity.User;

public interface ProgressTrackerDataAccessInterface {
    void changeStatustoinProgress(User user, Media title);
    void changeStatustoFinished(User user, Media title);
}
