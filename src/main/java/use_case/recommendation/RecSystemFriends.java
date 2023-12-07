package main.java.use_case.recommendation;

import entity.User;
import entity.Anime;
import entity.Media;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecSystemFriends implements RecSystem {

    @Override
    public List<Anime> getRecommendations(User user) {
        Set<Anime> recommendedAnime = new HashSet<>();

        for (User friend : user.getProfile().getFriends()) {
            List<Media> friendsWatchHistory = friend.getProfile().getWatchHistory();

            for (Media media : friendsWatchHistory) {
                if (media instanceof Anime) {
                    recommendedAnime.add((Anime) media);
                }
            }
        }

        // Convert the set to a list and limit the number of recommendations
        return new ArrayList<>(recommendedAnime).subList(0, Math.min(recommendedAnime.size(), 5));
    }
}
