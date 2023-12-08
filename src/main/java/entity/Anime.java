package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Anime implements Media{
    private Integer id;
    private String title;
    private Map<String,Integer> genres;
    private LocalDateTime releaseDate;
    private String imageURL;
    private String synopsis;
    private ArrayList<String> episodes;

    Anime(Integer id, String title, Map<String,Integer> genres, LocalDateTime releaseDate, String imageURL, String synopsis,
          ArrayList<String> episodes) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.imageURL = imageURL;
        this.synopsis = synopsis;
        this.episodes = episodes;
    }
    // for mock DAO
    public Anime(Integer id, String title, String imageURL) {
        this.id = id;
        this.title = title;
        this.imageURL = imageURL;

    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Map<String,Integer> getGenres() {
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

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setGenres(Map<String,Integer> genres) {
        this.genres = genres;
    }

    @Override
    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setEpisodes(ArrayList<String> episodes) {
        this.episodes = episodes;
    }

    // to String
    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genres=" + genres + // turn to string
                ", releaseDate=" + releaseDate + // turn to string
                ", imageURL='" + imageURL + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", episodes=" + episodes + // turn to string
                '}';
    }

    @Override
    public String toSimpleString() {
        return "Anime{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
//TODO: check
    @Override
    public boolean equals(Media media) {
        if (this == media) return true;
        if (media == null || getClass() != media.getClass()) return false;

        Anime other = (Anime) media;
        return Objects.equals(id, other.id) &&
                Objects.equals(title, other.title) &&
                Objects.equals(genres, other.genres) &&
                Objects.equals(releaseDate, other.releaseDate) &&
                Objects.equals(imageURL, other.imageURL) &&
                Objects.equals(synopsis, other.synopsis) &&
                Objects.equals(episodes, other.episodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genres, releaseDate, imageURL, synopsis, episodes);

    public static AnimeBuilder builder() {
        return new AnimeBuilder();

    }
}
