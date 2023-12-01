package use_case.search;

import entity.Anime;

import java.util.ArrayList;

public class SearchOutputData {
    private final ArrayList<Anime> results;

    public SearchOutputData(ArrayList<Anime> results){
        this.results = results;
    }

    public ArrayList<Anime> getResults(){return results;}
}
