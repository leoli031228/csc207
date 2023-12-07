package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.progresstracker.ProgressTrackerController;
import interface_adapter.progresstracker.ProgressTrackerPresenter;
import interface_adapter.progresstracker.ProgressTrackerViewModel;
import use_case.progessTracker.ProgressTrackerDataAccessInterface;
import use_case.progessTracker.ProgressTrackerInputBoundary;
import use_case.progessTracker.ProgressTrackerInteractor;
import use_case.progessTracker.ProgressTrackerOutputBoundary;
import view.ProgressTrackerView;

import javax.swing.*;
import java.io.IOException;

public class ProgressTrackerUseCaseFactory {
    private ProgressTrackerUseCaseFactory() {}

    public static ProgressTrackerView create(
            ViewManagerModel viewManagerModel,
            ProgressTrackerViewModel progressTrackerViewModel,
            ProgressTrackerDataAccessInterface userDAO ){

        try {
            ProgressTrackerController progressTrackerController = createProgressTrackerUseCase(
                    viewManagerModel, progressTrackerViewModel, userDAO);
            return new ProgressTrackerView(progressTrackerController,
                    progressTrackerViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }
        return null;
    }


    private static ProgressTrackerController createProgressTrackerUseCase(
            ViewManagerModel viewManagerModel,
            ProgressTrackerViewModel progressTrackerViewModel,
            ProgressTrackerDataAccessInterface userDAO) throws IOException {

        ProgressTrackerOutputBoundary progressTrackerOutputBoundary = new ProgressTrackerPresenter(viewManagerModel, progressTrackerViewModel);
        ProgressTrackerInputBoundary userProgTrackInteractor = new ProgressTrackerInteractor(
                userDAO, progressTrackerOutputBoundary);
        return new ProgressTrackerController(userProgTrackInteractor);
    }
}
