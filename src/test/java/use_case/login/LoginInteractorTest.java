package use_case.login;

import data_access.InMemoryUserDataAccessObject;
import entity.User;
import entity.Profile;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import use_case.login.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {

    // Only write assertions for the use case methods we expect to be called

    @Test
    void successTest() {
        // create input data for test
        LoginInputData inputData = new LoginInputData("Kelsie","password");

        // make DataAccessInterface through Mock InMemoryDataAccessObject
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // Add Kelsie to the repo so that when we check later the username & password is correct
        User user = new User("Kelsie", "kels@mail.ca", "password",
                LocalDateTime.now(), new Profile("Kelsie"));
        userRepository.save(user);

        // create mock presenter implementing OutputBoundary to test whether test case is as expected (asserts things)
        // instead of taking actual output data of the view model that the view would see
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                // check that the output data is the correct Username logged in.
                assertEquals("Kelsie", user.getUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        // set up the interactor to execute the use case
        // (pass data access interface & presenter output boundary to interactor)
        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    // Fails because the password does not match the saved password
    @Test
    void failurePasswordMismatchTest() {
        LoginInputData inputData = new LoginInputData("Kelsie", "wrong");
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        // Add Kelsie to the repo so that when we check later the password is incorrect
        User user = new User("Kelsie", "kels@mail.ca", "pswd",
                LocalDateTime.now(), new Profile("Kelsie"));
        userRepository.save(user);

        // This creates a presenter that tests whether the test case is as we expect.
        LoginOutputBoundary failurePresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Incorrect password for Kelsie.", error);
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, failurePresenter);
        interactor.execute(inputData);
    }

    // Fails because the User account does not exist.
    @Test
    void failureUserExistsTest() {
        LoginInputData inputData = new LoginInputData("Kelsie", "password");
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // create a presenter that tests whether the test case is as we expect.
        LoginOutputBoundary failurePresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Kelsie: Account does not exist.", error);
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, failurePresenter);
        interactor.execute(inputData);
    }
}