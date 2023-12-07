package interface_adapter.filter;

import use_case.filter.FilterInputBoundary;
import use_case.filter.FilterInputData;

import java.util.ArrayList;

public class FilterController {
    final FilterInputBoundary filterUseCaseInteractor;
    public FilterController(FilterInputBoundary filterUseCaseInteractor) {
        this.filterUseCaseInteractor = filterUseCaseInteractor;
    }

    public void execute(ArrayList<Integer> genreIDs) {
        FilterInputData filterInputData = new FilterInputData(
                genreIDs);

        // pass in the genre IDs
        filterUseCaseInteractor.execute(filterInputData);
    }
}
