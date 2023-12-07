package interface_adapter.filter;

import interface_adapter.ViewManagerModel;
import interface_adapter.filter.FilterViewModel;
import use_case.filter.FilterOutputBoundary;
import use_case.filter.FilterOutputData;
import use_case.filter.FilterOutputData;

public class FilterPresenter implements FilterOutputBoundary {
    private final FilterViewModel filterViewModel;
    private ViewManagerModel viewManagerModel;
    public FilterPresenter(FilterViewModel filterViewModel,
                           ViewManagerModel viewManagerModel) {
        this.filterViewModel = filterViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareResultsView(FilterOutputData results) {
        // update view to display resulting titles and their images
        FilterState filterState = filterViewModel.getState();
        filterState.setResults(results.getResults());

        this.filterViewModel.setState(filterState);
        filterViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(filterViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

}
