package use_case.signup;

import data_access.InMemoryUserDataAccessObject;
import entity.User;
import entity.Profile;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SignupInteractorTest {

    // Only write assertions for the use case methods we expect to be called

    @Test
    void successTest() {
        // create input data for test
        SignupInputData inputData = new SignupInputData("Kelsie", "kels@mail.utoronto.ca",
                "password", "password");

        // make DataAccessInterface through Mock InMemoryDataAccessObject
        SignupUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // create mock presenter implementing OutputBoundary to test whether test case is as expected (asserts things)
        // instead of taking actual output data of the view model that the view would see
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("Kelsie", user.getUsername());
                assertEquals("kels@mail.utoronto.ca", user.getEmail());
                assertNotNull(user.getCreationTime()); // any creation time is fine.
                assertTrue(userRepository.existsByName("Kelsie"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        // set up the interactor to execute the use case
        // (pass data access interface & presenter output boundary to interactor)
        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failurePasswordMismatchTest() {
        SignupInputData inputData = new SignupInputData("Kelsie", "kels@mail.utoronto.ca",
                                                            "password", "wrong");
        SignupUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // This creates a presenter that tests whether the test case is as we expect.
        SignupOutputBoundary failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Passwords don't match.", error);
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureUserExistsTest() {
        SignupInputData inputData = new SignupInputData("Kelsie", "kels@mail.utoronto.ca",
                                                        "password", "password");
        SignupUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // Add Kelsie to the repo so that when we check later they already exist
        User user = new User("Kelsie", "kels@mail.ca", "pswd",
                                                LocalDateTime.now(), new Profile("Kelsie"));
        userRepository.save(user);

        // create a presenter that tests whether the test case is as we expect.
        SignupOutputBoundary failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Username already exists.", error);
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, failurePresenter);
        interactor.execute(inputData);
    }
}