package data_access;

import entity.Anime;
import use_case.filter.FilterDataAccessInterface;
import use_case.search.SearchDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MockAnimeSearchDataAccessObject implements SearchDataAccessInterface, FilterDataAccessInterface {

    // Simulating a database with a list of Anime entities
    private Map<String,Anime> animeDatabase = new HashMap<>();

    public MockAnimeSearchDataAccessObject() {
        // Initialize the database with some sample data
        animeDatabase = new HashMap<>();
        Map<String,Integer> genres1 = new HashMap<>();
        genres1.put("Action", 1);
        genres1.put("Adventure", 2);
        Map<String,Integer> genres2 = new HashMap<>();
        genres2.put("Action", 1);
        Map<String,Integer> genres3 = new HashMap<>();
        genres3.put("Action", 1);
        Map<String,Integer> genres4 = new HashMap<>();
        genres4.put("Action", 1);
        Map<String,Integer> genres5 = new HashMap<>();
        genres5.put("Action", 1);
        Map<String,Integer> genres8 = new HashMap<>();
        genres8.put("Romance", 22);
        genres8.put("Drama", 8);

        animeDatabase.put("One Piece", Anime.builder()
                                .id(1).title("One Piece")
                                .genres(genres1)
                                .imageURL("https://upload.wikimedia.org/wikipedia/en/9/90/One_Piece%2C_Volume_61_Cover_%28Japanese%29.jpg")
                                .build());
        animeDatabase.put("Naruto", Anime.builder()
                                    .id(2).title("Naruto").genres(genres2)
                                    .imageURL("https://upload.wikimedia.org/wikipedia/en/9/94/NarutoCoverTankobon1.jpg").build());
        animeDatabase.put("Dragon Ball", Anime.builder().id(3).title("Dragon Ball").genres(genres3)
                .imageURL("https://m.media-amazon.com/images/M/MV5BYzI0YjYxY2UtNzRjNS00NTZiLTgzMDItNGEzMjU5MmE0ZWJmXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg").build());
        animeDatabase.put("Attack on Titan", Anime.builder().id(4).title("Attack on Titan").genres(genres4)
                .imageURL("https://static.wikia.nocookie.net/shingekinokyojin/images/d/d8/Attack_on_Titan_Season_1.jpg/revision/latest?cb=20211005182832").build());
        animeDatabase.put("My Hero Academia", Anime.builder().id(5).title("My Hero Academia").genres(genres5)
                .imageURL("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/251524e3b5517b689317437d881eccf0.jpe").build());
        animeDatabase.put("Jujutsu Kaisen", Anime.builder().id(6).title("Jujutsu Kaisen").genres(genres5)
                .imageURL("https://images.justwatch.com/poster/306336521/s332/season-2").build());
        animeDatabase.put("Jujutsu Kaisen 0", Anime.builder().id(7).title("Jujutsu Kaisen 0").genres(genres5)
                .imageURL("https://m.media-amazon.com/images/M/MV5BODM0NmVjMzUtOTJhNi00N2ZhLWFkYmMtYmZmNjRiY2M1YWY4XkEyXkFqcGdeQXVyOTgxOTA5MDg@._V1_.jpg").build());
        animeDatabase.put("Jujutsu Kaisen Official PV", Anime.builder().id(7).title("Jujutsu Kaisen Official PV").genres(genres5)
                .imageURL("https://m.media-amazon.com/images/M/MV5BMTMwMDM4N2EtOTJiYy00OTQ0LThlZDYtYWUwOWFlY2IxZGVjXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg").build());
        animeDatabase.put("Fruits Basket 1st Season", Anime.builder().id(7).title("Fruits Basket 1st Season").genres(genres8)
                .imageURL("https://cdn.myanimelist.net/images/anime/4/75204.jpg").build());


    }

    @Override
    public boolean resultsFound(String title) {
        // return if there is at least one result matching the given title
        return !searchTitle(title).isEmpty();
    }


    public HashMap<String,ArrayList<Object>> searchTitle(String title) {
        // Simulate searching for anime by title
        // return mapping of title name to list containing the image url and id
        HashMap<String, ArrayList<Object>> searchResults = new HashMap<>();

        for (String animeTitle : animeDatabase.keySet()) {
            Anime anime = animeDatabase.get(animeTitle);
            if (anime.getTitle().toLowerCase().contains(title.toLowerCase())) {
                ArrayList<Object> imageAndId = new ArrayList<>();
                imageAndId.add(anime.getImageURL());
                imageAndId.add(anime.getID());

                searchResults.put(anime.getTitle(), imageAndId);
            }
        }

        return searchResults;
    }

    @Override
    public HashMap<String, ArrayList<Object>> filterByGenre(ArrayList<Integer> genres) {
        // Simulate searching for anime by genre
        // return mapping of title name to list containing the image url and id
        HashMap<String, ArrayList<Object>> filteredResults = new HashMap<>();

        for (String animeTitle : animeDatabase.keySet()) {
            Anime anime = animeDatabase.get(animeTitle);
            for (Integer genreID : genres) {
                if (anime.getGenres().containsValue(genreID)) {
                    // get mapping of genre IDs of the anime and check if it contains the value of
                    // any of the input genreIDs
                    ArrayList<Object> imageAndId = new ArrayList<>();
                    imageAndId.add(anime.getImageURL());
                    imageAndId.add(anime.getID());
                    // add to the list of filtered results
                    filteredResults.put(anime.getTitle(), imageAndId);
                }
            }
        }

        return filteredResults;
    }
}

