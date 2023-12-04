package use_case.signup;

import entity.User;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String identifier);

    boolean existsByEmail(String emailIdentifier);

    void save(User user);


}
