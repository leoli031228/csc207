package use_case.signup;

public class SignupOutputData {

    private final String username;
    final private String email;
    private String creationTime;
    private boolean useCaseFailed;

    public SignupOutputData(String username, String email, String creationTime, boolean useCaseFailed) {
        this.username = username;
        this.email = email;
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
