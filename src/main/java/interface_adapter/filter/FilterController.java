package interface_adapter.filter;

import use_case.filter.FilterInputBoundary;
import use_case.filter.FilterInputData;

public class FilterController {
    final FilterInputBoundary filterUseCaseInteractor;
    public FilterController(FilterInputBoundary filterUseCaseInteractor) {
        this.filterUseCaseInteractor = filterUseCaseInteractor;
    }

    public void execute(String title) {
        FilterInputData filterInputData = new FilterInputData(
                title);

        // pass in the genre, invoking the interactor
        filterUseCaseInteractor.execute(filterInputData);
    }
}
