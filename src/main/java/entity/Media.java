package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface Media {
    Integer getID();

    String getTitle();

    List<String> getGenres();

    LocalDateTime getReleaseDate();

    String getImageURL();

    String getSynopsis();


    void setId(Integer id);

    void setTitle(String title);

    void setImageURL(String imageURL);

    void setSynopsis(String synopsis);

    void setGenres(List<String> genres);

    void setReleaseDate(LocalDateTime ldt);


    String toString();

    String toSimpleString();

}
