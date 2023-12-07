package use_case.progessTracker;

import entity.Media;
import entity.Profile;
import entity.User;

public class ProgressTrackerInputData {
    final private User user;
    final private Media media;
    final private String current_status;

    public ProgressTrackerInputData(User user, Media media, String current_status) {
        this.user = user;
        this.media = media;
        this.current_status = current_status;
    }

    User getUser() {return user;}
    Profile getProfile() {return user.getProfile();}
    Media getMedia() {return media;}
    String getStatus() {return current_status;}


}
