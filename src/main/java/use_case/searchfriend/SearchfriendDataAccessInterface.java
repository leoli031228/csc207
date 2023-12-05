package use_case.searchfriend;

import entity.Anime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SearchfriendDataAccessInterface {
    boolean resultsFound(String identifier);

    public HashMap<String, ArrayList<Object>> searchTitle(String title);

}
