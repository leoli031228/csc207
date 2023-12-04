package use_case.filter;

public class FilterInputData {
    final private String genre;

    public FilterInputData(String genre) {
        this.genre = genre;
    }

    String getTitle() {
        return genre;
    }
}
