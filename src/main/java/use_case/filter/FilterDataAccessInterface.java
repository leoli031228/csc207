package use_case.filter;

import java.util.ArrayList;
import java.util.HashMap;

public interface FilterDataAccessInterface {

    public HashMap<String, ArrayList<Object>> filterByGenre(String genre);
}
