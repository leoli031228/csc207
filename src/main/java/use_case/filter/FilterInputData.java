package use_case.filter;

import java.util.ArrayList;

public class FilterInputData {
    final private ArrayList<Integer> genreIDs;

    public FilterInputData(ArrayList<Integer> genreIDs) {
        this.genreIDs = genreIDs;
    }

    ArrayList<Integer> getGenreIDs() {
        return genreIDs;
    }
}
