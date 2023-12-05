package data_access;

import entity.Anime;
import entity.Media;
import entity.User;
import use_case.progessTracker.ProgressTrackerDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class MockProgressTrackerDataAccessObject implements ProgressTrackerDataAccessInterface {
    // Simulating a database with a list of Anime entities
    private Map<String, Anime> animeDatabase = new HashMap<>();
    // Create fake account
    private User fakeaccount = new User;

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
    }

    public void changeStatustoinProgress(User user, Media title) {
        // adds the media to the inProgress list and updates the statuses list in the user's profile
        if (!user.getInProgress.contains(title)) { // body runs only if the media is not in the progress list
            if (user.getWatchlist.contains(title)) { // remove the media from the watch list if it is there
                user.getWatchlist.remove(title);
            }
            user.getInProgress.add(title);
            user.getStatuses.put(title, "In Progress"); // update status to in progress
        }
    }

    public void changeStatustoFinished(User user, Media title) {
        // if media is in Inprogress list
        if (user.getInProgress.contains(title)) { // remove the media from the Inprogress list if it is there
            user.getInProgress.remove(title);
            // Since the media is in the in progress list, the media was already added to the status map
            // so just update the status
            user.getStatuses.replace(title, "Completed"); // update status to finished
            return;
        }
        // executes this if media is not in Inprogress list, i.e. when the user finishes the media without
        // adding it to their Inprogress list
        user.getStatuses.put(title, "Completed");
    }
}
