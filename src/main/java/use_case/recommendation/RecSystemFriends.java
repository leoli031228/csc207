package main.java.use_case.recommendation;

import entity.User;
import entity.Anime;
import entity.Media;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RecSystemFriends implements RecSystem {

    @Override
    public List<Anime> getRecommendations(User user) {
        Set<Anime> recommendedAnime = new HashSet<>();
        Set<Anime> userWatchedOrWatching = getUserAnimeList(user);
        for (User friend : user.getProfile().getFriends()) {
            List<Media> combinedMediaList = new ArrayList<>();
            combinedMediaList.addAll(friend.getProfile().getWatchHistory());
            combinedMediaList.addAll(friend.getProfile().getWatchlist());
            combinedMediaList.addAll(friend.getProfile().getInProgress());
            for (Media media : combinedMediaList) {
                if (media instanceof Anime && !userWatchedOrWatching.contains(media)) {
                    recommendedAnime.add((Anime) media);
                }
            }
        }
        return new ArrayList<>(recommendedAnime).subList(0, Math.min(recommendedAnime.size(), 5));
    }

    private Set<Anime> getUserAnimeList(User user) {
        Set<Anime> userAnimeList = new HashSet<>();

        // Process each list: watchHistory, watchlist, inProgress
        addAnimeToList(user.getProfile().getWatchHistory(), userAnimeList);
        addAnimeToList(user.getProfile().getWatchlist(), userAnimeList);
        addAnimeToList(user.getProfile().getInProgress(), userAnimeList);

        return userAnimeList;
    }

    private void addAnimeToList(List<Media> mediaList, Set<Anime> animeSet) {
        for (Media media : mediaList) {
            if (media instanceof Anime) {
                animeSet.add((Anime) media);
            }
        }
    }
}
