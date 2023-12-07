package data_access;

import entity.User;
import entity.Profile;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface{

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();

    public FileUserDataAccessObject(String csvPath) throws IOException {

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("email", 1);
        headers.put("password", 2);
        headers.put("creation_time", 3);
        /*headers.put("profile", 4);*/

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,email,password,creation_time,profile");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String email = String.valueOf(col[headers.get("email")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                    User user = new User(username, email, password, ldt, new Profile(username));
                    accounts.put(username, user);
                }
            }
        }
    }

    // save the user into the hashMap
    @Override
    public void save(User user) {
        accounts.put(user.getUsername(), user);
        this.save();
    }

    @Override
    public User getUser(String username) {
        return accounts.get(username);
    }

   /* @Override
    public ArrayList<String> getUsers() {
        return new ArrayList<>(accounts.keySet());
    }*/

    // TODO: update this to save the user's profile
    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s",
                        user.getUsername(), user.getEmail(), user.getPassword(), user.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public boolean existsByEmail(String emailIdentifier) {
        for (String username: accounts.keySet()){
            User user = accounts.get(username);
            if (user.getEmail().equals(emailIdentifier)){
                return true;
            }
        }
        return false;
    }

    /**
     * Search for users whose username or email contains the search query.
     * @param searchQuery The query to search for.
     * @return A list of Users whose username or email contains the search query.
     */
    public List<User> searchUsers(String searchQuery) {
        List<User> matchingUsers = new ArrayList<>();
        for (User user : accounts.values()) {
            if (user.getUsername().toLowerCase().contains(searchQuery.toLowerCase())
                    || user.getEmail().toLowerCase().contains(searchQuery.toLowerCase())) {
                matchingUsers.add(user);
            }
        }
        return matchingUsers;
    }
}
