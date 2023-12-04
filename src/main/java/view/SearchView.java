package view;

import javax.swing.*;
import java.util.List;

public class SearchView {
    private final JTextArea resultsTextArea;

    public SearchView(JTextArea resultsTextArea) {

        this.resultsTextArea = resultsTextArea;
    }



    public void displayResults(List<String> titles) {
        resultsTextArea.setText(String.join("\n", titles));
    }


    public void displayNoResultsMessage(String message) {
        resultsTextArea.setText(message);
    }
}
