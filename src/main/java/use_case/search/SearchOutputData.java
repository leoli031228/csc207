package use_case.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SearchOutputData {
    private final HashMap<String,ArrayList<Object>> results;

    public SearchOutputData(HashMap<String,ArrayList<Object>> results){
        this.results = results;
    }

    public HashMap<String,ArrayList<Object>> getResults(){
        // returns a mapping of the title name to a list containing the Image URL and anime ID

        return results;
    }
}
