package app;

import interface_adapter.filter.FilterController;
import interface_adapter.filter.FilterPresenter;
import interface_adapter.filter.FilterViewModel;
import interface_adapter.switch_view.SwitchViewController;

import use_case.filter.FilterDataAccessInterface;
import interface_adapter.*;
import use_case.filter.FilterInputBoundary;
import use_case.filter.FilterInteractor;
import use_case.filter.FilterOutputBoundary;
import view.FilterView;

import javax.swing.*;
import java.io.IOException;

public class FilterUseCaseFactory {

    /** Prevent instantiation. */
    private FilterUseCaseFactory() {}

    public static FilterView create(
            ViewManagerModel viewManagerModel,
            FilterViewModel filterViewModel,
            FilterDataAccessInterface filterDataAccessObject) {

        try {
            FilterController filterController = createFilterUseCase(viewManagerModel, filterViewModel, filterDataAccessObject);
            SwitchViewController switchViewController = new SwitchViewController(viewManagerModel);
            return new FilterView(filterController, filterViewModel, filterController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static FilterController createFilterUseCase(ViewManagerModel viewManagerModel, FilterViewModel filterViewModel, FilterDataAccessInterface filterDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        FilterOutputBoundary filterOutputBoundary = new FilterPresenter(filterViewModel, viewManagerModel);

        FilterInputBoundary userFilterInteractor = new FilterInteractor(
                filterDataAccessObject, filterOutputBoundary);

        return new FilterController(userFilterInteractor);
    }
}
