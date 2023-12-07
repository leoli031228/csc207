package main.java.use_case.recommendation;

import entity.Anime;
import entity.User;
import java.util.List;

public class RecSystemPopularity implements RecSystem {
    public RecSystemPopularity() {
    }

    @Override
    public List<Anime> getRecommendations(User user) {
        return null;
    }
}
