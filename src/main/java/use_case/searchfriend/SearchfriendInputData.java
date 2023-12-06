package use_case.searchfriend;

public class SearchfriendInputData {
    final private String username;

    public SearchfriendInputData(String username) {
        this.username = username;
    }

    String getUsername() {
        return username;
    }
}
