package data_access;

import entity.Media;
import entity.Anime;
import entity.Manga;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.search.SearchDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MediaApiDB implements SearchDataAccessInterface {

    private static final String API_URL = "https://api.jikan.moe/v4/anime";

    //TODO: implement these
    @Override
    public boolean resultsFound(String identifier) {
        return false;
    }

    //Helper Method
    public HashMap<String, ArrayList<Object>> getCoverInfo(){}

    @Override
    public HashMap<String, ArrayList<Object>> searchTitle(String title) {
        return null;
    }
}
