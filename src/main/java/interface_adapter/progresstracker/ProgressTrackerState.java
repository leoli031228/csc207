package interface_adapter.progresstracker;

import entity.Media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressTrackerState {
    private List<Media> watchlist = new ArrayList<Media>();
    private List<Media> inProgress = new ArrayList<Media>();
    private List<Media> watchHistory = new ArrayList<Media>();

    private Map<String, List<Media>> statuses = new HashMap<>();

    private String error = null;
    public ProgressTrackerState(ProgressTrackerState copy) {
        watchlist = copy.watchlist;
        inProgress = copy.inProgress;
        watchHistory = copy.watchHistory;
        statuses = copy.statuses;
        error = copy.error;
    }
    public ProgressTrackerState(){
    }

    public void setWatchlist(List<Media> watchlist) {
        this.watchlist = watchlist;
    }

    public void setInProgress(List<Media> inProgress) {
        this.inProgress = inProgress;
    }

    public void setWatchHistory(List<Media> watchHistory) {
        this.watchHistory = watchHistory;
    }

    public void setStatuses(Map<String, List<Media>> statuses) {
        this.statuses = statuses;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Media> getWatchlist() {
        return watchlist;
    }
    public List<Media> getinProgress() {
        return inProgress;
    }
    public List<Media> getwatchHistory() {
        return watchHistory;
    }
    public Map<String, List<Media>> getStatuses() {
        return statuses;
    }

    public String getError() {
        return error;
    }
}
