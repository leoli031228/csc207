package use_case.search;

import entity.Anime;

import java.util.ArrayList;
import java.util.List;

public interface SearchDataAccessInterface {
    boolean resultsFound(String identifier);
    ArrayList<Anime> searchByTitle(String title);
}
