/*
package data_access;

import entity.User;
import entity.Profile;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileProfileDataAccessObject */
/*implements ... add interfaces it implements*//*
 {
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, Profile> profiles = new HashMap<>();
    public FileUserDataAccessObject(String csvPath) throws IOException {

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("watchlist", 1);
        headers.put("in_progress", 2);
        headers.put("watch_history", 3);
        */
/*headers.put("profile", 4);*//*


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
                    String friends = String.valueOf(col[headers.get("friends")]);
                    String watchlist = String.valueOf(col[headers.get("watchlist")]);
                    String inProgress = String.valueOf(col[headers.get("in_progress")]);
                    String watchHistory = String.valueOf(col[headers.get("watch_history")]);
                    */
/*String profile = String.valueOf(col[headers.get("profile")]);*//*

                    // TODO: finish implementing to add stored profile to user
                    User user = new User(username, email, password, ldt, new Profile(username)); //fix?
                    accounts.put(username, user);
                }
            }
        }
    }

    // save the user into the hashMap
    @Override
    public void save(Profile profile) {
        profiles.put(user.getUsername(), profile);
        this.save();
    }

    */
/*@Override
    public User getUsername(String username) {
        return accounts.get(username);
    }*//*


   */
/* @Override
    public ArrayList<String> getUsers() {
        return new ArrayList<>(accounts.keySet());
    }*//*


    // TODO: update this
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

}
*/
