package main.java.use_case.recommendation;

import entity.Anime;
import entity.User;
import java.util.List;

public interface RecSystem {
    List<Anime> getRecommendations(User user);
}
