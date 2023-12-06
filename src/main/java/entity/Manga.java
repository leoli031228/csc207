package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Manga implements Media{
    private Integer id;
    private String title;
    private Map<String,Integer> genres;
    private LocalDateTime releaseDate;
    private String imageURL;
    private String synopsis;
    private ArrayList<String> chapters;

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

    public ArrayList<String> getChapters() {
        return chapters;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenres(Map<String,Integer> genres) {
        this.genres = genres;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setChapters(ArrayList<String> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genres=" + genres + // turn to string
                ", releaseDate=" + releaseDate + // turn to string
                ", imageURL='" + imageURL + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", chapters=" + chapters + // turn to string
                '}';
    }

    @Override
    public String toSimpleString() {
        return "Manga{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';

    }
}
