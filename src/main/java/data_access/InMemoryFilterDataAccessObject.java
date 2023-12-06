package data_access;

import entity.Anime;
import use_case.filter.FilterDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryFilterDataAccessObject implements FilterDataAccessInterface {
    private Map<String, Anime> animeDatabase = new HashMap<>();
    public InMemoryFilterDataAccessObject() {

        // Initialize the database with some sample data
        animeDatabase = new HashMap<>();

        animeDatabase.put("One Piece", new Anime(1, "One Piece", ,
                "https://upload.wikimedia.org/wikipedia/en/9/90/One_Piece%2C_Volume_61_Cover_%28Japanese%29.jpg"));
        animeDatabase.put("Naruto", new Anime(2, "Naruto",
                "https://upload.wikimedia.org/wikipedia/en/9/94/NarutoCoverTankobon1.jpg"));
        animeDatabase.put("Dragon Ball", new Anime(3, "Dragon Ball",
                "https://m.media-amazon.com/images/M/MV5BYzI0YjYxY2UtNzRjNS00NTZiLTgzMDItNGEzMjU5MmE0ZWJmXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg"));
        animeDatabase.put("Attack on Titan", new Anime(4, "Attack on Titan",
                "https://static.wikia.nocookie.net/shingekinokyojin/images/d/d8/Attack_on_Titan_Season_1.jpg/revision/latest?cb=20211005182832" ));
        animeDatabase.put("My Hero Academia", new Anime(5, "My Hero Academia",
                "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/251524e3b5517b689317437d881eccf0.jpe"));
    }
    @Override
    public HashMap<String, ArrayList<Object>> filterByGenre(ArrayList<Integer> genre) {


        // Simulate searching for anime by title
        // return mapping of title name to list containing the image url and id
        HashMap<String, ArrayList<Object>> filterResults = new HashMap<>();

        for (String animeTitle : animeDatabase.keySet()) {
            Anime anime = animeDatabase.get(animeTitle);
            if (anime.getTitle().toLowerCase().contains(title.toLowerCase())) {
                ArrayList<Object> imageAndId = new ArrayList<>();
                imageAndId.add(anime.getImageURL());
                imageAndId.add(anime.getID());

                filterResults.put(anime.getTitle(), imageAndId);
            }
        }

        return filterResults;

    }
}
