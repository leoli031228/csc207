package data_access;

import entity.Media;
import entity.Anime;
import entity.Manga;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.search.SearchDataAccessInterface;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MediaApiDB implements SearchDataAccessInterface {

    private static final String API_URL = "https://api.jikan.moe/v4/anime";

    //TODO: implement these
    @Override
    public boolean resultsFound(String title) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.jikan.moe/v4/anime?q=%s&type=tv&sfw", title))
                .build();
        try{
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt("status_code") == 200) {
                JSONArray jsonArray = responseBody.getJSONArray("data");
                return !jsonArray.isEmpty();
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public HashMap<String, ArrayList<Object>> searchTitle(String title) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                                                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.jikan.moe/v4/anime?q=%s&type=tv&sfw", title))
                .build();
        try{
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt("status_code") == 200) {
                JSONArray jsonArray = responseBody.getJSONArray("data");
                HashMap<String, ArrayList<Object>> searchResults = new HashMap<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    // array list to put into map
                    ArrayList<Object> imageAndId = new ArrayList<>();
                    JSONObject media = new JSONObject(jsonArray.getJSONObject(i));
                    imageAndId.add(media.getJSONObject("images").getJSONObject("jpg").getString("image_url"));
                    imageAndId.add(media.getInt("mal_id"));

                    //parse default title
                    String defaultTitle = media.getJSONArray("titles").getJSONObject(0).getString("title");
                    //add media to the array list
                    searchResults.put(defaultTitle, imageAndId);
                }

                return searchResults;
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }


}
