package main.java.use_case.recommendation;

import entity.Media;
import entity.User;
import entity.Anime;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RecSystemRecent implements RecSystem {

    private static final String BASE_URL = "https://api.jikan.moe/v3";

    @Override
    public List<Anime> getRecommendations(User user) {
        try {
            String json = fetchRecentAnimeData();
            return parseJsonToAnime(json, 5); // Extract 5 titles
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list in case of an error
        }
    }

    private String fetchRecentAnimeData() throws Exception {
        String url = BASE_URL + "/anime/1/recommendations"; // Replace '1' with the appropriate anime ID
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private List<Anime> parseJsonToAnime(String json, int limit) {
        List<Anime> animeList = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(json);
        JSONArray dataArray = jsonObj.getJSONArray("data");

        // Iterate through each item in the data array (up to the specified limit)
        for (int i = 0; i < dataArray.length() && i < limit; i++) {
            JSONObject dataItem = dataArray.getJSONObject(i);
            JSONArray entryArray = dataItem.getJSONArray("entry");

            // Iterate through each entry in the entry array
            for (int j = 0; j < entryArray.length() && animeList.size() < limit; j++) {
                JSONObject entry = entryArray.getJSONObject(j);
                Integer malId = entry.getInt("mal_id");
                String titleName = entry.getString("title");
                String imageUrl = entry.getJSONObject("images").getJSONObject("jpg").getString("image_url");

                // Create a new Anime object and add it to the list
                Anime anime = new Anime(malId, titleName, imageUrl);
                animeList.add(anime);
            }
        }

        return animeList;
    }
}
