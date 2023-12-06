package entity;

import java.time.LocalDateTime;
import java.util.List;

public interface MediaBuilder {

    MediaBuilder id(Integer id);

    MediaBuilder title(String title);

    MediaBuilder imageURL(String url);

    MediaBuilder genres(List<String> genres);

    MediaBuilder releaseDate(LocalDateTime releaseDate);

    MediaBuilder synopsis(String synopsis);

    Media buildSimple();

    Media build();

}
