package use_case.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface FilterDataAccessInterface {

    public HashMap<String, ArrayList<Object>> filterByGenre(ArrayList<Integer> genre);
}
