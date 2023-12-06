package use_case.progessTracker;

import entity.Media;
import entity.Profile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressTrackerOutputData {
    private final Profile profile;
    private boolean useCaseFailed;

    public ProgressTrackerOutputData(Profile profile, boolean useCaseFailed) {
        this.profile = profile;
        this.useCaseFailed = useCaseFailed;
    }


    public List<Media> getWatchlist() {
        return profile.getWatchlist();
    }
    public List<Media> getInProgress() {
        return profile.getInProgress();
    }
    public List<Media> getWatchHistory() {
        return profile.getWatchHistory();
    }
    public Map<String, List<Media>> getResults() {
        return profile.getStatuses();
    }
 }
