package use_case.progessTracker;

import entity.Media;
import entity.Profile;

public class ProgressTrackerInputData {
    final private Profile profile;
    final private Media media;
    final private String current_status;

    public ProgressTrackerInputData(Profile profile, Media media, String current_status) {
        this.profile = profile;
        this.media = media;
        this.current_status = current_status;
    }

    Profile getProfile() {return profile;}
    Media getMedia() {return media;}
    String getStatus() {return current_status;}


}
