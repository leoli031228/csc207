package data_access;

import entity.Media;
import entity.Anime;
import entity.Manga;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.filter.FilterDataAccessInterface;
import use_case.search.SearchDataAccessInterface;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MediaApiDB implements SearchDataAccessInterface, FilterDataAccessInterface{

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

            if (response.code() == 200){
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
            //System.out.println(responseBody.toString(1));

            if (response.code() == 200) {
                JSONArray jsonArray = responseBody.getJSONArray("data");
                //System.out.println(jsonArray.toString(5));
                HashMap<String, ArrayList<Object>> searchResults = new HashMap<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    // array list to put into map
                    ArrayList<Object> imageAndId = new ArrayList<>();
                    JSONObject media = jsonArray.getJSONObject(i);
                    System.out.println(media.toString(5));
                    System.out.println("THIS IS A NEW ITERATION");
                    imageAndId.add(media.getJSONObject("images").getJSONObject("jpg").getString("image_url"));
                    imageAndId.add(media.getInt("mal_id"));

                    System.out.println(media.getJSONArray("titles").getJSONObject(0).getString("title"));
                    System.out.println(media.getJSONObject("images").getJSONObject("jpg").getString("image_url"));
                    System.out.println(String.valueOf(media.getInt("mal_id")));

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


    @Override
    public HashMap<String, ArrayList<Object>> filterByGenre(ArrayList<Integer> genre) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String result = genre.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        Request request = new Request.Builder()
                .url(String.format("https://api.jikan.moe/v4/anime?genres=%s",result))
                .build();
        System.out.println(result);
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            //System.out.println(responseBody.toString(1));

            if (response.code() == 200) {
                JSONArray jsonArray = responseBody.getJSONArray("data");
                //System.out.println(jsonArray.toString(5));
                HashMap<String, ArrayList<Object>> searchResults = new HashMap<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    // array list to put into map
                    ArrayList<Object> imageAndId = new ArrayList<>();
                    JSONObject media = jsonArray.getJSONObject(i);
                    System.out.println(media.toString(5));
                    System.out.println("THIS IS A NEW ITERATION");
                    imageAndId.add(media.getJSONObject("images").getJSONObject("jpg").getString("image_url"));
                    imageAndId.add(media.getInt("mal_id"));

                    System.out.println(media.getJSONArray("titles").getJSONObject(0).getString("title"));
                    System.out.println(media.getJSONObject("images").getJSONObject("jpg").getString("image_url"));
                    System.out.println(String.valueOf(media.getInt("mal_id")));

                    //parse default title
                    String defaultTitle = media.getJSONArray("titles").getJSONObject(0).getString("title");
                    //add media to the array list
                    searchResults.put(defaultTitle, imageAndId);
                }
                return searchResults;

            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }

        } catch(IOException | JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
