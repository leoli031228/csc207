package use_case.signup;

import entity.User;

import java.time.LocalDateTime;

public class SignupInteractor implements SignupInputBoundary {
    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            User user = new User(signupInputData.getUsername(), signupInputData.getEmail(),
                                                signupInputData.getPassword(), now);
            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), user.getEmail(),
                                                                        now.toString(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }
}