package view;

import entity.Anime;
import interface_adapter.filter.FilterController;
import interface_adapter.filter.FilterViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchView implements ActionListener, PropertyChangeListener {
//    public static void main(String[] args) {
//        // Sample data for anime
//        List<Anime> animeList = getSampleAnimeData();
//
//        // Create and show the GUI
//        SwingUtilities.invokeLater(() -> animeGridResults(animeList));
//    }
    public final String viewName = "search";
    private final SearchController searchController;
    private final FilterController filterController;
    // Create a panel for the grid with GridLayout
    private final JPanel gridPanel = new JPanel(new GridLayout(3, 3, 10, 10));

    // Create a scroll pane for the grid panel
    private final JScrollPane scrollPane = new JScrollPane(gridPanel);
    private final JTextField searchField = new JTextField(20);
    final JButton searchButton = new JButton("Search");




    public SearchView(SearchController controller, FilterController filterController,
                      SearchViewModel searchViewModel, FilterViewModel filterViewModel) {
        this.searchController = controller;
        this.filterController = filterController;
        searchViewModel.addPropertyChangeListener(this);
        filterViewModel.addPropertyChangeListener(this);

        JFrame frame = new JFrame("Anime Search Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a panel for the search bar and filter options
        JPanel searchFilterPanel = new JPanel(new BorderLayout());

        // Create a panel for the genre filter on the left side
        JPanel genreFilterPanel = new JPanel(new BorderLayout());
        String[] genreFilters = {"All Genres", "Action", "Adventure", "Drama", "Fantasy", "Horror", "Mystery"};
        JList genreList = new JList(genreFilters);
        genreList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Add the "Filter:" label above the genre list
        genreFilterPanel.add(new JLabel("Filter:"), BorderLayout.NORTH);
        genreFilterPanel.add(genreList, BorderLayout.CENTER);

        // filter panel
        //ADJUST MARGINS
        genreFilterPanel.setBorder(new EmptyBorder(0, 10, 0, 2));

        // Add the genre filter panel to the WEST position
        searchFilterPanel.add(genreFilterPanel, BorderLayout.WEST);

        // Create a panel for the search bar and search button
        JPanel searchPanel = new JPanel();


        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Add the search panel to the NORTH position
        searchFilterPanel.add(searchPanel, BorderLayout.NORTH);

        // Add the search and genre filter panel to the WEST position
        mainPanel.add(searchFilterPanel, BorderLayout.WEST);


        // Displaying search results area:

        // Add the scroll pane to the CENTER position
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the main panel to the content pane
        frame.getContentPane().add(mainPanel);

        // Set frame size, center it, and make it visible
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);



        searchButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt){
                        if (evt.getSource().equals(searchButton)) {

                            // get input title from the search field
                            String titleSearched = searchField.getText();
 
                            searchController.execute(titleSearched);

                        }
                    }
                }

        );
    }

        private static JPanel createAnimeCard(String anime, String imageURL) {
        JPanel cardPanel = new JPanel();
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cardPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(anime);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // display image
        ImageIcon imageIcon = createImageIcon(imageURL);
        JLabel imageLabel = new JLabel(imageIcon);

        cardPanel.add(imageLabel, BorderLayout.CENTER);
        cardPanel.add(titleLabel, BorderLayout.SOUTH);

        return cardPanel;
    }

    private static ImageIcon createImageIcon(String imageUrl) {
        try {
            // Load the image from the URL
            java.net.URL url = new java.net.URL(imageUrl);
            Image image = ImageIO.read(url);

            // Make image fit in JLabel
            Image scaledImage = image.getScaledInstance(70, 150, Image.SCALE_DEFAULT);

            return new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ImageIcon();
        }
    }



    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchState state = (SearchState) evt.getNewValue();
        // get results from the state which is a mapping of the anime title to an array list containing the ID
        // and the image url
        Map<String, ArrayList<Object>> results = state.getResults();
        List<String> animeList = new ArrayList<>(results.keySet());

        // Clear the current grid panel
        gridPanel.removeAll();


        for (String anime : animeList) {
            String imageURL = (String) results.get(anime).get(1);
            gridPanel.add(createAnimeCard(anime, imageURL));
        }

        // Repaint the grid panel to reflect the changes
        gridPanel.revalidate();
        gridPanel.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
