package entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MediaBuilder {

    MediaBuilder id(Integer id);

    MediaBuilder title(String title);

    MediaBuilder imageURL(String url);

    MediaBuilder genres(Map<String,Integer> genres);

    MediaBuilder releaseDate(LocalDateTime releaseDate);

    MediaBuilder synopsis(String synopsis);

    Media buildSimple();

    Media build();

}
