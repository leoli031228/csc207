package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    private Profile profile;

    @BeforeEach
    void setup(){
        profile = new Profile("Kelsie");
        User friend = new User("Lys", "mail", "test", LocalDateTime.now(), new Profile("Lys"));
        User friend2 = new User("sean", "email", "test", LocalDateTime.now(), new Profile("Sean"));
        profile.addFriend(friend);
        profile.addFriend(friend2);
        Anime test = new Anime(1, "Naruto", "url.com");
        Anime test2 = new Anime(2, "One Piece", "url.com");
        profile.addToWatchlist(test);
        profile.addToInProgress(test);
        profile.addToInProgress(test2);
        profile.addToWatchHistory(test2);
        //profile.setStatuses({"watchlist": profile.getWatchlist(),"in progress": profile.getInProgress(),});
    }


    @Test
    void friendsString() {
        assertEquals("[" +
                "{" +
                "\"username\":\"Lys\", \"email\":\"mail\"},"+
                "{\"username\":\"sean\", \"email\":\"email\"}]", profile.friendsString());
        //System.out.println(profile.friendsString());
    }

   @Test
    void mediaListToIDs() {
    }


    @Test
    void mediaListToString() {
        assertEquals("{\"Naruto\":{\"imageURL\":\"url.com\",\"id\":1,\"title\":\"Naruto\"},"+
                "\"One Piece\":{\"imageURL\":\"url.com\",\"id\":2,\"title\":\"One Piece\"}}"
                ,profile.mediaListToString(profile.getInProgress()));
        //System.out.println(profile.mediaListToString(profile.getInProgress()));
    }

    @Test
    void statusesToString() {
        //System.out.println(profile.statusesToString(profile.getStatuses()));
    }

    @Test
    void testToString() {
    }

    @Test
    void toJSON() {
        System.out.println("toJson test");
        System.out.println(profile.toJSON());
    }
}
