package use_case.progessTracker;

import entity.Media;
import entity.Profile;
import entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressTrackerOutputData {
    private final User user;
    private boolean useCaseFailed;

    public ProgressTrackerOutputData(User user, boolean useCaseFailed) {
        this.user = user;
        this.useCaseFailed = useCaseFailed;
    }


    public List<Media> getWatchlist() {
        return user.getProfile().getWatchlist();
    }
    public List<Media> getInProgress() {
        return user.getProfile().getInProgress();
    }
    public List<Media> getWatchHistory() {
        return user.getProfile().getWatchHistory();
    }
    public Map<String, List<Media>> getResults() {
        return  user.getProfile().getStatuses();
    }
 }
