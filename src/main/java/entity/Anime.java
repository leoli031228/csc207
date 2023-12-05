package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Anime implements Media{
    private Integer animeId;
    private String title;
    private List<String> genres;
    private LocalDateTime releaseDate;
    private String imageURL;
    private String synopsis;
    private ArrayList<String> episodes;

    Anime(Integer animeId, String title, List<String> genres, LocalDateTime releaseDate, String imageURL, String synopsis,
          ArrayList<String> episodes) {
        this.animeId = animeId;
        this.title = title;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.imageURL = imageURL;
        this.synopsis = synopsis;
        this.episodes = episodes;
    }
    // for mock DAO
    public Anime(Integer animeId, String title, String imageURL) {
        this.animeId = animeId;
        this.title = title;
        this.imageURL = imageURL;

    }

    @Override
    public Integer getID() {
        return animeId;
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

    public ArrayList<String> getEpisodes() {
        return episodes;
    }

}
