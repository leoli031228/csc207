package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AnimeBuilder implements MediaBuilder{
    private Integer id;
    private String title;
    private String imageURL;
    private List<String> genres;
    private LocalDateTime releaseDate;
    private String synopsis;
    private ArrayList<String> episodes;

    AnimeBuilder(){}

   /* @Override
    public AnimeBuilder newMedia() {
        this.anime = new Anime();
    }*/

    public AnimeBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public AnimeBuilder title(String title) {
        this.title = title;
        return this;
    }

    public AnimeBuilder imageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public AnimeBuilder genres(List<String> genres) {
        this.genres = genres;
        return this;
    }

    public AnimeBuilder releaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public AnimeBuilder synopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    public AnimeBuilder episodes(ArrayList<String> episodes) {
        this.episodes = episodes;
        return this;
    }

    @Override
    public Anime buildSimple() {
        return new Anime(id, title, imageURL);
    }

    @Override
    public Anime build() {
        return new Anime(id, title, genres, releaseDate, imageURL, synopsis, episodes);
    }

    public static AnimeBuilder builder() {
        return new AnimeBuilder();
    }
}
