package data_access;

import entity.Anime;
import entity.Media;
import entity.User;
import use_case.progessTracker.ProgressTrackerDataAccessInterface;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static java.time.Month.APRIL;

public class MockProgressTrackerDataAccessObject implements ProgressTrackerDataAccessInterface {
    // Simulating a database with a list of Anime entities
    private Map<String, Anime> animeDatabase = new HashMap<>();
    // Create fake account
    private User fakeaccount;

    public MockProgressTrackerDataAccessObject() {
        // Initialize the database with some sample data
        fakeaccount = new User("aa", "bb", "cc", LocalDateTime.of(2023, 12, 1, 12,0,0));


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

        fakeaccount.getWatchlist().add(animeDatabase.get("One Piece"));
        fakeaccount.getInProgress().add(animeDatabase.get("Naruto"));
        fakeaccount.getInProgress().add(animeDatabase.get("Dragon Ball"));
        fakeaccount.getStatuses().put("Completed", animeDatabase.get("Attack on Titan"));

    }

    @Override
    public void changeStatustoinProgress(User user, Media title) {
        // adds the media to the inProgress list and updates the statuses list in the user's profile
        if (!fakeaccount.getInProgress().contains(title)) { // body runs only if the media is not in the progress list
            if (fakeaccount.getWatchlist().contains(title)) { // remove the media from the watch list if it is there
                fakeaccount.getWatchlist().remove(title);
            }
            fakeaccount.getInProgress().add(title);
            fakeaccount.getStatuses().put("In Progress", title); // update status to in progress
        }
    }

    public void changeStatustoFinished(User user, Media title) {
        // if media is in Inprogress list
        if (fakeaccount.getInProgress().contains(title)) { // remove the media from the Inprogress list if it is there
            fakeaccount.getInProgress().remove(title);
            // Since the media is in the in progress list, the media was already added to the status map
            // so just update the status
            fakeaccount.getStatuses().replace("Completed", title); // update status to finished
            // add finished media to user's watch history
            fakeaccount.getWatchHistory().add(title);
            return;
        }
        // executes this if media is not in Inprogress list, i.e. when the user finishes the media without
        // adding it to their Inprogress list
        fakeaccount.getStatuses().put("Completed", title);
        // add finished media to user's watch history
        fakeaccount.getWatchHistory().add(title);
    }
}