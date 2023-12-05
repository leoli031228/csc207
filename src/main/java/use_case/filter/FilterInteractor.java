package use_case.filter;

import use_case.filter.FilterDataAccessInterface;
import use_case.filter.FilterInputData;
import use_case.filter.FilterOutputBoundary;


public class FilterInteractor implements FilterInputBoundary{
    final FilterDataAccessInterface resultsDataAccessObject;
    final FilterOutputBoundary resultsPresenter;

    public FilterInteractor(FilterDataAccessInterface filterDataAccessObject, FilterOutputBoundary filterOutputBoundary) {
        this.resultsDataAccessObject = filterDataAccessObject;
        this.resultsPresenter = filterOutputBoundary;
    }
    @Override
    public void execute(FilterInputData filterInputData) {
        // ask DAO to fetch all the data (the entities)
        // input data is the genre

            // collect results in an Output Data object
            // pass the Output Data invoking the Presenter

            FilterOutputData filterOutputData = new FilterOutputData(
                    resultsDataAccessObject.filterByGenre(filterInputData.getGenreIDs()) );
            resultsPresenter.prepareResultsView(filterOutputData);
        }

    }
