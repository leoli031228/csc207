package main.java.use_case.recommendation;

import entity.User;
import entity.Anime;
import org.json.JSONObject;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class RecSystemGenre implements RecSystem {

    private static final String BASE_URL = "https://api.jikan.moe/v3";

    @Override
    public List<Anime> getRecommendations(User user) {
        List<String> userPreferredGenres = getUserPreferredGenres(user);
        List<Integer> animeIds = fetchAnimeIdsByGenres(userPreferredGenres); // Implement this method
        List<Anime> recommendedAnime = new ArrayList<>();

        for (Integer animeId : animeIds) {
            try {
                String json = fetchAnimeById(animeId);
                JSONObject animeObject = new JSONObject(json).getJSONObject("data");
                Anime anime = parseAnimeObject(animeObject); // Implement this method
                recommendedAnime.add(anime);

                if (recommendedAnime.size() >= 5) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return recommendedAnime;
    }

    private String fetchAnimeById(Integer animeId) throws Exception {
        String url = BASE_URL + "/anime/" + animeId;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private Anime parseAnimeObject(JSONObject animeObject) {
        return new Anime();
    }

    private List<String> getUserPreferredGenres(User user) {
        return new ArrayList<>();
    }

    private List<Integer> fetchAnimeIdsByGenres(List<String> genres) {
        return new ArrayList<>();
    }
}
