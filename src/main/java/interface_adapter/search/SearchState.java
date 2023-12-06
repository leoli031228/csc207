package interface_adapter.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchState {
    private Map<String, ArrayList<Object>> results = new HashMap<>();

    public SearchState(SearchState copy) {
        results = copy.results;
    }

    public SearchState(){
    }

    public Map<String, ArrayList<Object>> getResults() {return results;}
    public void setResults(Map<String, ArrayList<Object>> results) {this.results = results; }

}
