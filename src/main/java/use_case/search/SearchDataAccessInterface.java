package use_case.search;

import entity.Anime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SearchDataAccessInterface {
    boolean resultsFound(String identifier);

    public HashMap<String, ArrayList<Object>> searchTitle(String title);

}
