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
    private Profile profile;

    public User(String username, String email, String password, LocalDateTime creationTime, Profile profile) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.creationTime = creationTime;
        this.profile = profile;
    }

    // Getters

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public Profile getProfile(){ return profile; }

    public void setProfile(Profile profile){ this.profile = profile; }

    @Override
    public String toString() {
        return "{" +
                "\"username\":" + '\"' + username + '\"' +
                ", \"email\":" + '\"' + email + '\"' +
               /* ", password='" + password + '\'' +
                ", creationTime=" + creationTime + '\'' +
                ", profile=" + profile.toString() +*/
                '}';
    }
}
