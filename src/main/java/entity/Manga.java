package entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Manga implements Media{
    private long mangaId;
    private String title;
    private List<String> genres;
    private Date releaseDate;
    private String imageURL;
    private String synopsis;
    private List<String> chapters;

    @Override
    public Integer getID() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<String> getGenres() {
        return null;
    }

    @Override
    public LocalDateTime getReleaseDate() {
        return null;
    }

    public String getImageURL(){
        return null;
    }
}
