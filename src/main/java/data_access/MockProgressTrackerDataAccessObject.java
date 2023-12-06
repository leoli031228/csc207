package data_access;

import entity.Anime;
import entity.Media;
import entity.Profile;
import entity.User;
import use_case.progessTracker.ProgressTrackerDataAccessInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MockProgressTrackerDataAccessObject implements ProgressTrackerDataAccessInterface {
    // Simulating a database with a list of Anime entities
    private Map<String, Anime> animeDatabase = new HashMap<>();
    // Create fake account
    private User fakeuser = new User("David", "123@gmail.com", "Lee",
            LocalDateTime.now(),
            new Profile("David"),
            new ArrayList<>());
    Profile fakeaccount = fakeuser.getProfile();

    public MockProgressTrackerDataAccessObject() {
        // Initialize the database with some sample data


        animeDatabase = new HashMap<>();
        animeDatabase.put("One Piece", new Anime(1, "One Piece",
                "https://upload.wikimedia.org/wikipedia/en/9/90/One_Piece%2C_Volume_61_Cover_%28Japanese%29.jpg"));
        animeDatabase.put("Naruto", new Anime(2, "Naruto",
                "https://upload.wikimedia.org/wikipedia/en/9/94/NarutoCoverTankobon1.jpg"));
        animeDatabase.put("Dragon Ball", new Anime(3, "Dragon Ball",
                "https://m.media-amazon.com/images/M/MV5BYzI0YjYxY2UtNzRjNS00NTZiLTgzMDItNGEzMjU5MmE0ZWJmXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg"));
        animeDatabase.put("Attack on Titan", new Anime(4, "Attack on Titan",
                "https://static.wikia.nocookie.net/shingekinokyojin/images/d/d8/Attack_on_Titan_Season_1.jpg/revision/latest?cb=20211005182832"));
        animeDatabase.put("My Hero Academia", new Anime(5, "My Hero Academia",
                "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/251524e3b5517b689317437d881eccf0.jpe"));

        fakeaccount.addToInProgress(animeDatabase.get("Naruto"));
        fakeaccount.addtoStatus("Completed", animeDatabase.get("Attack on Titan"));

    }

    @Override

    public boolean existsinWatchHistory(Profile profile, Media title) {
        return fakeaccount.getWatchHistory().contains(title);
    }

    public void changeStatustoinProgress(Profile profile, Media title) {
        // adds the media to the inProgress list and updates the statuses list in the user's profile
        if (!fakeaccount.getInProgress().contains(title)) { // body runs only if the media is not in the progress list
            if (fakeaccount.getWatchlist().contains(title)) { // remove the media from the watch list if it is there
                fakeaccount.removeFromWatchlist(title);
            }
            fakeaccount.addToInProgress(title);
            fakeaccount.removeFromsStatus("Watchlist", title);
            fakeaccount.addtoStatus("In Progress", title); // update status to in progress
        }
    }

    public void changeStatustoFinished(Profile profile, Media title) {
        // if media is in Inprogress list
        if (fakeaccount.getInProgress().contains(title)) { // remove the media from the Inprogress list if it is there
            fakeaccount.removeFromInProgress(title);
        }
        // Since the media is in the in progress list, remove from the list of in progress media
        fakeaccount.removeFromsStatus("In Progress", title);
        fakeaccount.addtoStatus("Completed", title); // update status to finished
        // add finished media to user's watch history
        fakeaccount.addToWatchHistory(title);
    }
    public boolean existsinInProgress(Profile profile, Media title) {
        return fakeaccount.getInProgress().contains(title);
    }
}
