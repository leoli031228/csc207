package use_case.signup;

import entity.User;
import entity.Profile;

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
            userPresenter.prepareFailView("Username already exists.");
        } else if(userDataAccessObject.existsByEmail(signupInputData.getEmail())){
            userPresenter.prepareFailView("Email already being used.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            User user = new User(signupInputData.getUsername(), signupInputData.getEmail(),
                                                signupInputData.getPassword(), now,
                                                new Profile(signupInputData.getUsername()));
            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), user.getEmail(),
                                                                        now.toString(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }
}