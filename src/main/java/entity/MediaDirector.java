// NOTE: not needed but could fix to implement.


/*
package entity;

public class MediaDirector {

    private MediaBuilder mediaBuilder;

    //Simple Media
    void buildSimpleMedia(String type){
        if (type.equals("anime"))
            mediaBuilder = new AnimeBuilder();
        else if (type.equals("manga"))
            mediaBuilder = new MangaBuilder();
        else
            System.out.println("media type unavailable");

        if (mediaBuilder != null)
            buildSimple();
    }

    void buildSimple(){
        mediaBuilder.newMedia();
        mediaBuilder.addID();
        mediaBuilder.addTitle();
        mediaBuilder.addImageURL();
        mediaBuilder.create();
        mediaBuilder = null;
    }

    // Full Media
    void buildMedia(String type){
        if (type.equals("anime"))
            mediaBuilder = new AnimeBuilder();
        else if (type.equals("manga"))
            mediaBuilder = new MangaBuilder();
        else
            System.out.println("media type unavailable");

        if (mediaBuilder != null)
            build();
    }

    // Full
    void build(){
        mediaBuilder.newMedia();
        mediaBuilder.addID();
        mediaBuilder.addTitle();
        mediaBuilder.addImageURL();
        mediaBuilder.addGenres();
        mediaBuilder.addReleaseDate();
        mediaBuilder.addSynopsis();
        mediaBuilder.create();
        mediaBuilder = null;
    }

}
*/
