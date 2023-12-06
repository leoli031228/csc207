package entity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {
    private final String username;
    private List<User> friends = new ArrayList<>();
    private List<Media> watchlist = new ArrayList<>();
    private List<Media> inProgress = new ArrayList<>();
    private List<Media> watchHistory = new ArrayList<>();
    private Map<String, List<Media>> statuses = new HashMap<>();

    // empty constructor
    public Profile(String username) {
        this.username = username;
    }

    // Getters
    public String getUsername() {
        return username;
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

    public Map<String, List<Media>> getStatuses() {
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

    public void setStatuses(Map<String, List<Media>> statuses) {
        this.statuses = statuses;
    }

    // Add to Lists
    public void addFriend(User user) {
        this.friends.add(user);
    }

    public void addToWatchlist(Media media) {
        this.watchlist.add(media);
    }

    public void addToInProgress(Media media) {
        this.inProgress.add(media);
    }

    public void addToWatchHistory(Media media) {
        this.watchHistory.add(media);
    }

    // TODO: david will implement this
    public void setStatus(String status) {
    }

    // Remove from Lists
    public void removeFriend(User user) {
        this.friends.remove(user);
    }

    public void removeFromWatchlist(Media media) {
        this.watchlist.remove(media);
    }

    public void removeFromInProgress(Media media) {
        this.inProgress.remove(media);
    }

    public void removeFromWatchHistory(Media media) {
        this.watchHistory.remove(media);
    }

    // Lists to Strings
    public String friendsString(){
        StringBuilder friendString = new StringBuilder();
        friendString.append("[");
        for (User user: friends){
            friendString.append(user.toString()).append(",");
        }
        if (!friends.isEmpty()) {
            friendString.setLength(friendString.length() - 1);
        }
        friendString.append("]");
        return friendString.toString();
    }

    // turns a given list of medias to a list of ID integers
    public List<Integer> mediaListToIDs(List<Media> mediaList){
        List<Integer> ids = new ArrayList<>();
        for (Media media: mediaList){
            ids.add(media.getID());
        }
        return ids;
    }

    /*// turns list of media IDs to a String.
    public String mediaListToString(List<Media> mediaList){
        List<Integer> ids = mediaListToIDs(mediaList);

        StringBuilder idsString = new StringBuilder();
        idsString.append("[");
        for (Integer id: ids){
            String stringID = String.valueOf(id);
            idsString.append(stringID).append(",");
        }
        if (!watchlist.isEmpty()) {
            idsString.setLength(idsString.length() - 1);
        }
        idsString.append("]");
        return idsString.toString();
    }*/

    public String mediaListToString(List<Media> mediaList){
        JSONObject medialist = new JSONObject();
        for (Media media: mediaList){
            JSONObject item = new JSONObject();
            item.put("id", media.getID());
            item.put("title", media.getTitle());
            item.put("imageURL", media.getImageURL());
            medialist.put(media.getTitle(), item);
        }
        return medialist.toString();
    }



    // turns statuses to a mapping of Status to
    public String statusesToString(Map<String, List<Media>> statuses){
        StringBuilder statusesString = new StringBuilder();
        statusesString.append("{");
        for (String status: statuses.keySet()){
            String mediaList = mediaListToString(statuses.get(status));
            statusesString.append('\"'+status+'\"').append(":").append(mediaList).append(",");
        }
        statusesString.append("}");
        if (!watchlist.isEmpty()) {
            statusesString.setLength(statusesString.length() - 2);
        }
        return statusesString.toString();
    }

    // NOTE: to String (basically json format of profile)
    @Override
    public String toString() {

        return "Profile{" +
                "username=" + username + '\'' +
                "friends=" + friendsString() + '\'' + // NOTE: friends would be given as string json of Usernames & Emails
                ", watchlist=" + mediaListToString(watchlist) + '\'' + // NOTE: lists would be given as string list of IDs
                ", inProgress=" + mediaListToString(inProgress) + '\'' +
                ", watchHistory=" + mediaListToString(watchHistory) + '\'' +
                ", statuses=" + statusesToString(statuses) + '\'' +
                '}';
    }

    // testing to JSON OBJECT
    public String toJSON(){
        try {
            return "{" +
                    "\"username\":" + '\"' + username + '\"' +
                    ", \"friends\":" + friendsString() +// NOTE: friends would be given as string json of Usernames & Emails
                    ", \"watchlist\":" + '\"' + mediaListToString(watchlist) + '\"' + // NOTE: lists would be given as string list of IDs
                    ", \"inProgress\":" + '\"' + mediaListToString(inProgress) + '\"' +
                    ", \"watchHistory\":" + '\"' + mediaListToString(watchHistory) + '\"' +
                    ", \"statuses\":" + statusesToString(statuses) +
                    '}';

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
