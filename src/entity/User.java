package entity;


import java.util.List;

public class User {
    private long userId;
    private String username;
    private String email;
    private String password;

    private List<Media> watchlist;
    private List<Media> inProgress;
    private List<Media> watchHistory;

}
