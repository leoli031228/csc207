package entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Anime implements Media{
    private long animeId;
    private String title;
    private String genre;
    private Date releaseDate;
    private String coverImage;
    private String synopsis;
    private List<String> episodes;

    Anime(long animeId, String title, String genre, Date releaseDate, String coverImage, String synopsis,
          List<String> episodes) {
        this.animeId = animeId;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.coverImage = coverImage;
        this.synopsis = synopsis;
        this.episodes = episodes;
    }
    // for mock DAO
    public Anime(long animeId, String title) {
        this.animeId = animeId;
        this.title = title;

    }

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
