package entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Manga implements Media{
    private long mangaId;
    private String title;
    private String genre;
    private Date releaseDate;
    private String coverImage;
    private String synopsis;
    private List<String> chapters;

    @Override
    public String getID() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getGenre() {
        return null;
    }

    @Override
    public LocalDateTime getReleaseDate() {
        return null;
    }
}
