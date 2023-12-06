package use_case.progressTracker;



import data_access.ProgressTrackerDataAccessObject;
import entity.Anime;
import entity.Media;
import entity.Profile;
import entity.User;
import org.junit.jupiter.api.Test;
import use_case.progessTracker.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;


public class ProgressTrackerInteractorTest {
    @Test
    void resultsSuccessTest() {
        ProgressTrackerInputData inputTitle =
                new ProgressTrackerInputData(new User("David", "123@gmail.com", "Lee",
                        LocalDateTime.now(),
                        new Profile("David")),
                        new Anime(1, "One Piece",
                                "https://upload.wikimedia.org/wikipedia/en/9/90/One_Piece%2C_Volume_61_Cover_%28Japanese%29.jpg"),
                        "Watchlist");
        ProgressTrackerDataAccessInterface progtrackDataAccessObject = new ProgressTrackerDataAccessObject();

        ProgressTrackerOutputBoundary progtrackPresenter = new ProgressTrackerOutputBoundary() {
            @Override
            public void prepareSuccessView(ProgressTrackerOutputData results) {
                // checks if In progress is updated correctly when an anime is added to the list
                List<Media> inprog = new ArrayList<>();
                inprog.add(new Anime(1, "One Piece",
                                "https://upload.wikimedia.org/wikipedia/en/9/90/One_Piece%2C_Volume_61_Cover_%28Japanese%29.jpg"));
                assertEquals(inprog, results.getInProgress());

                // checks if Statuses is updated correctly when One Piece is added to the mapping
                Map<String, List<Media>> statuses = new HashMap<>();
                List<Media> medias = new ArrayList<>();
                medias.add(new Anime(1, "One Piece",
                        "https://upload.wikimedia.org/wikipedia/en/9/90/One_Piece%2C_Volume_61_Cover_%28Japanese%29.jpg"));
                statuses.put("In Progress", medias);
                assertEquals(statuses, results.getResults());

            }

            @Override
            public void prepareFailView(String noResults) {
                fail("Use case failure is unexpected.");
            }
        };
        ProgressTrackerInputBoundary interactor = new ProgressTrackerInteractor(progtrackDataAccessObject,
                progtrackPresenter);
        interactor.execute(inputTitle);
    }
}