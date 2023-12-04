package use_case.filter;

import java.util.ArrayList;
import java.util.HashMap;

public class FilterOutputData {
    private final HashMap<String, ArrayList<Object>> results;

    public FilterOutputData(HashMap<String,ArrayList<Object>> results){
        this.results = results;
    }

    public HashMap<String,ArrayList<Object>> getResults(){
        // returns a mapping of the title name to a list containing the Image URL and anime IDf
        return results;
    }
}
