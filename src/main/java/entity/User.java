package entity;


import java.util.List;
import java.util.Map;

public class User {
    private long userId;
    private String username;
    private String email;
    private String password;
    private List<User> friends;
    private List<Media> watchlist;
    private List<Media> inProgress;
    private List<Media> watchHistory;
    private Map<Media, String> statuses;

}
