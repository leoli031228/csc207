package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Media {
    Integer getID();

    String getTitle();

    Map<String,Integer> getGenres();

    LocalDateTime getReleaseDate();

    String getImageURL();

    String getSynopsis();


    void setId(Integer id);

    void setTitle(String title);

    void setImageURL(String imageURL);

    void setSynopsis(String synopsis);

    void setGenres(Map<String,Integer> genres);

    void setReleaseDate(LocalDateTime ldt);


    String toString();

    String toSimpleString();

}
