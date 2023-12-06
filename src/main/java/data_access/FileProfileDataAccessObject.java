/*
package data_access;

import entity.User;
import entity.Profile;

import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONArray;


public class FileProfileDataAccessObject */
/*implements*//*
{
    private final File jsonFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, Profile> profiles = new HashMap<>();
    public FileProfileDataAccessObject(String filePath) throws IOException {

        jsonFile = new File(filePath);


        if (jsonFile.length() == 0) {
            save();
        } else {

            // trying to read file as JSON
            try{
                String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));

                // Parse the JSON array
                JSONArray jsonArray = new JSONArray(jsonContent);

                ArrayList<JSONObject> jsonMedias = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonMedia = jsonArray.getJSONObject(i);
                    jsonMedias.add(jsonMedia);
                }

                // TODO: create profile from file...
                Profile profile = new Profile(username);
                // set lists in profile
                profiles.put(username, profile);

            }catch(IOException e){
                throw new FileNotFoundException("File reading error");
            }

            */
/*try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,friends,watchlist,in_progress,watch_history");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String friends = String.valueOf(col[headers.get("friends")]);
                    String watchlist = String.valueOf(col[headers.get("watchlist")]);
                    String inProgress = String.valueOf(col[headers.get("in_progress")]);
                    String watchHistory = String.valueOf(col[headers.get("watch_history")]);

                    // TODO: create profile from file...
                    Profile profile = new Profile(username);
                    // set lists in profile



                    profiles.put(username, profile);
                }
            }*//*

        }
    }

    // save the user into the hashMap
    */
/*@Override
    public void save(Profile profile) {
        profiles.put(profile.getUsername(), profile);
        this.save();
    }*//*


   */
/* @Override
    public Profile getUsername(String username) {
        return profile.get(username);
    }*//*


   */
/* @Override
    public ArrayList<String> getProfiles() {
        return new ArrayList<>(profile.keySet());
    }*//*


    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(jsonFile));
            writer.write("[");
            for (Profile profile : profiles.values()) {
                writer.write(profile.toJSON());
                writer.write(",");
            }
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
*/
