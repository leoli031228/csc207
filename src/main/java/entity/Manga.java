package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manga implements Media{
    private Integer mangaId;
    private String title;
    private List<String> genres;
    private LocalDateTime releaseDate;
    private String imageURL;
    private String synopsis;
    private ArrayList<String> chapters;

    @Override
    public Integer getID() {
        return mangaId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getGenres() {
        return genres;
    }

    @Override
    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String getImageURL() {
        return imageURL;
    }
    @Override
    public String getSynopsis() {
        return synopsis;
    }

    public ArrayList<String> getChapters() {
        return chapters;
    }
}
