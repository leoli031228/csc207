package data_access;

import use_case.filter.FilterDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryFilterDataAccessObject implements FilterDataAccessInterface {
    @Override
    public HashMap<String, ArrayList<Object>> filterByGenre(ArrayList<Integer> genre) {
        return null;
    }
}
