package interface_adapter.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchState {
    private Map<String, ArrayList<Object>> results = new HashMap<>();
    private String noResultsError = null;

    public SearchState(SearchState copy) {
        results = copy.results;
        noResultsError = copy.noResultsError;
    }

    public SearchState(){
    }

    public Map<String, ArrayList<Object>> getResults() {return results;}
    public void setResults(Map<String, ArrayList<Object>> results) {this.results = results; }
    public void setNoResultsError(String noResultsError){this.noResultsError = noResultsError;}
    public String getNoResultsError(){return noResultsError;}

}
