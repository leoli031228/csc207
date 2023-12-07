package main.java.use_case.recommendation;

import entity.User;
import entity.Anime;
import java.util.List;

public class RecSystemRatings implements RecSystem {
    public RecSystemRatings() {
    }

    @Override
    public List<Anime> getRecommendations(User user) {
        return null;
    }
}
