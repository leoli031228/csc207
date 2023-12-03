package entity;

import java.time.LocalDateTime;
import java.util.List;

public interface Media {
    Integer getID();

    String getTitle();

    List<String> getGenres();

    LocalDateTime getReleaseDate();

    String getImageURL();
}
