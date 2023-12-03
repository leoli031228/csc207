package entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Anime implements Media{
    private long animeId;
    private String title;
    private List<String> genres;
    private Date releaseDate;
    private String imageURL;
    private String synopsis;
    private List<String> episodes;

    Anime(long animeId, String title, List<String> genres, Date releaseDate, String imageURL, String synopsis,
          List<String> episodes) {
        this.animeId = animeId;
        this.title = title;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.imageURL = imageURL;
        this.synopsis = synopsis;
        this.episodes = episodes;
    }
    // for mock DAO
    public Anime(long animeId, String title) {
        this.animeId = animeId;
        this.title = title;

    }

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

    @Override
    public String getImageURL() {
        return null;
    }
}
