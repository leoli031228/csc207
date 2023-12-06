package view;

import interface_adapter.filter.FilterController;
import interface_adapter.filter.FilterViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterView extends JFrame implements ActionListener, PropertyChangeListener {
        private JList genres;
        private JList<String> animeList;

        private final FilterController filterController;

        public FilterView(FilterController controller, FilterViewModel filterViewModel, FilterController filterController) {
            this.filterController = controller;

            setTitle("Filter genre results view");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());


            animeList = new JList<>();
            JScrollPane listScrollPane = new JScrollPane(animeList);

            add(genres, BorderLayout.NORTH);
            add(listScrollPane, BorderLayout.CENTER);

            Map<String, Integer> genreToID = new HashMap<>();

            genreToID.put("Action", 1);
            genreToID.put("Adventure", 2);
            genreToID.put("Avant Garde", 3);
            genreToID.put("Comedy", 4);
            genreToID.put("Drama", 5);
            genreToID.put("Fantasy", 6);
            genreToID.put("Horror", 26);
            genreToID.put("Mystery", 26);
            genreToID.put("Romance", 36);
            genreToID.put("Sci-Fi", 13);

            List<String> genreNames = new ArrayList<>(genreToID.keySet());
            this.genres = new JList(genreNames.toArray());

        }



//        public int[] getSelectedGenre() {
//            // Get the selected genre from the drop-down menu
//            return genres.getSelectedIndices();
//        }

//        public void setGenres(Map<String,Integer> genres) {
//            // Set the available genres in the drop-down menu
//
//            for (String genre : genres) {
//                genreToID.put(genre, genreID);
//            }
//        }


        public void actionPerformed(ActionEvent evt) {

//            if (evt.getSource().equals(filter)) {
//
//                genres.setSelectionMode(
//                        ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//
//
//                JOptionPane.showMessageDialog(this, new JScrollPane(genres));
//                List selected = genres.getSelectedValuesList();
//
//                List<Integer> selectedGenreIDs = new ArrayList<>();
//                for (Object selectedGenre : selected) {
//                    Integer genreID = genreToID.get(selectedGenre);
//                    if (genreID != null) {
//                        selectedGenreIDs.add(genreID);
//                    }
//                }
//                filterController.execute(selectedGenreIDs);
//            }
        }




    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
