package data_access;

import entity.Anime;
import entity.Media;
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


public class FileProfileDataAccessObject /*implements*/ {
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

                //the whole file is a JSONObject
                JSONObject profileList = new JSONObject(jsonContent);
                //Parsing the File to get the array of profiles
                JSONArray jsonProfileArray = new JSONArray(profileList.getJSONArray("profiles"));

                // Iterate over each JSON object in the array
                for (int i = 0; i < jsonProfileArray.length(); i++) {

                    //get the profile object
                    JSONObject jsonProfile = jsonProfileArray.getJSONObject(i);
                    // get the key of the profile (their username)
                    String profileName = jsonProfile.keys().next();
                    //initialize the profile
                    Profile profile = new Profile(profileName);

                    //parse the profile to add info to profile.
                    JSONArray friendsArray = jsonProfile.getJSONArray("friends");
                    ArrayList<User> friends = new ArrayList<>();
                    for (int n=0; n < friendsArray.length(); n++){
                        JSONObject jsonFriend = new JSONObject(friendsArray.getJSONObject(n));
                        User friend = new User(jsonFriend.getString("username"),
                                                jsonFriend.getString("email")); // create friend users
                        friends.add(friend); // add User friend to list
                    }
                    profile.setFriends(friends); // adding list of friends

                    JSONArray watchlistArray = jsonProfile.getJSONArray("watchlist");
                    JSONArray inProgressArray = jsonProfile.getJSONArray("inProgress");
                    JSONArray watchHistoryArray = jsonProfile.getJSONArray("watchHistory");
                    //using helper method to create Media list for each type and add to profile
                    profile.setWatchlist(toMediaList(watchlistArray));
                    profile.setInProgress(toMediaList(inProgressArray));
                    profile.setWatchHistory(toMediaList(watchHistoryArray));




                    // add profile to the mapping of username to profile.
                    profiles.put(profileName, profile);
                }



            }catch(IOException e){
                throw new FileNotFoundException("File reading error");
            }
        }
    }

    // helper to create a media list from the JSONArray
    private ArrayList<Media> toMediaList(JSONArray jsonArray){
        ArrayList<Media> mediaList = new ArrayList<>();
        for (int n=0; n < jsonArray.length(); n++){
            JSONObject media = new JSONObject(jsonArray.getJSONObject(n));
            mediaList.add(Anime.builder()
                    .id(media.getInt("id"))
                    .title(media.getString("title"))
                    .imageURL(media.getString("imageURL"))
                    .buildSimple()); // add built media to list
        }
        return mediaList;
    }


    // save the user into the hashMap
/*
@Override
    public void save(Profile profile) {
        profiles.put(profile.getUsername(), profile);
        this.save();
    }


 @Override
    public Profile getUsername(String username) {
        return profile.get(username);
    }


 @Override
    public ArrayList<String> getProfiles() {
        return new ArrayList<>(profile.keySet());
    }
*/





    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(jsonFile));

            writer.write("{\"profiles\":[");
            for (Profile profile : profiles.values()) {
                writer.write("{\"" + profile.getUsername() + "\":");
                writer.write(profile.toJSON());
                writer.write("},");
            }
            writer.write("]}");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
