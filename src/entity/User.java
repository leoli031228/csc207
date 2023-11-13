package entity;

import java.util.ArrayList;

public class User {
    private long userId;
    private String username;
    private String email;
    private String password;

    private ArrayList<Media> watchList;
    private ArrayList<Media> watchHistory;
    private ArrayList<Media> favourites;
    private ArrayList<Media> inProgress;
}
