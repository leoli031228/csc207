package entity;

import java.time.LocalDateTime;

public interface Media {
    String getID();

    String getTitle();

    String getGenre();

    LocalDateTime getReleaseDate();
}
