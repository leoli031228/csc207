package interface_adapter.filter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;

public class FilterState {
    private Map<String, ArrayList<Object>> results = new HashMap<>();

    public FilterState(FilterState copy) {
        results = copy.results;
    }

    public FilterState(){
    }

    public Map<String, ArrayList<Object>> getResults() {return results;}
    public void setResults(Map<String, ArrayList<Object>> results) {this.results = results; }

}
