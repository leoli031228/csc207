package data_access;

import entity.Anime;
import use_case.search.SearchDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class MockAnimeDAO implements SearchDataAccessInterface {

    // Simulating a database with a list of Anime entities
    private List<Anime> animeDatabase;

    public MockAnimeDAO() {
        // Initialize the database with some sample data
        animeDatabase = new ArrayList<>();
        animeDatabase.add(new Anime(1, "One Piece"));
        animeDatabase.add(new Anime(2, "Naruto"));
        animeDatabase.add(new Anime(3, "Dragon Ball"));
        animeDatabase.add(new Anime(4, "Attack on Titan"));
        animeDatabase.add(new Anime(5, "My Hero Academia"));
    }

    @Override
    public boolean resultsFound(String title) {
        // return if there is at least one result given the title
        return !searchByTitle(title).isEmpty();
    }

    // Simulate searching for anime by title
    public ArrayList<Anime> searchByTitle(String title) {
        ArrayList<Anime> searchResults = new ArrayList<>();

        for (Anime anime : animeDatabase) {
            if (anime.getTitle().toLowerCase().contains(title.toLowerCase())) {
                searchResults.add(anime);
            }
        }

        return searchResults;
    }
}

