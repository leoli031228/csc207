package use_case.signup;

public class SignupInputData {
    final private String username;
    final private String email;
    final private String password;
    final private String repeatPassword;

    public SignupInputData(String username, String email, String password, String repeatPassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    String getUsername() {
        return username;
    }

    String getEmail(){ return email; }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
