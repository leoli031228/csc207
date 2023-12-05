package use_case.progessTracker;

import entity.Media;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgressTrackerOutputData {
    private final HashMap<Media, String> results;

    public ProgressTrackerOutputData(HashMap<Media,String> results) {
        this.results = results;
    }

    public HashMap<Media,String> getResults() {
        return results;
    }
 }
