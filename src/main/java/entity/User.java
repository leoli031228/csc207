package entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

public class User {
    private final String username;
    private final String email;
    private final String password;
    private final LocalDateTime creationTime;


    private List<User> friends = new ArrayList<>();
    private List<Media> watchlist = new ArrayList<>();
    private List<Media> inProgress = new ArrayList<>();
    private List<Media> watchHistory = new ArrayList<>();
    private Map<String, Media> statuses = new HashMap<>();

    public User(String username, String email, String password, LocalDateTime creationTime) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.creationTime = creationTime;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<Media> getWatchlist() {
        return watchlist;
    }

    public List<Media> getInProgress() {
        return inProgress;
    }

    public List<Media> getWatchHistory() {
        return watchHistory;
    }

    public Map<String, Media> getStatuses() {
        return statuses;
    }

    // Setters
    public void setFriends(List<User> friends) {
        this.friends = friends;
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

    public void setStatuses(Map<String, Media> statuses) {
        this.statuses = statuses;
    }

}
