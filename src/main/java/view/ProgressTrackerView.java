package view;

import entity.Media;
import interface_adapter.progresstracker.ProgressTrackerController;
import interface_adapter.progresstracker.ProgressTrackerState;
import interface_adapter.progresstracker.ProgressTrackerViewModel;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class ProgressTrackerView extends JPanel implements ActionListener, PropertyChangeListener {

//    public static void main(String[] args) {
//       // Sample data for anime
//      List<Anime> animeList = getSampleAnimeData();
//
//        // Create and show the GUI
//        SwingUtilities.invokeLater(() -> animeGridResults(animeList));
//    }
    public final String viewName = "Progress Track";
    private static ProgressTrackerController progressTrackerController = null;
    private static ProgressTrackerViewModel progressTrackerViewModel = null;
    private final JPanel gridPanel = new JPanel();
    private static JButton addtoInProgress;
    private static JButton addtoWatchHistory;


    public ProgressTrackerView(ProgressTrackerController controller,
                               ProgressTrackerViewModel progressTrackerViewModel) {

        this.progressTrackerController = controller;
        this.progressTrackerViewModel = progressTrackerViewModel;

        progressTrackerViewModel.addPropertyChangeListener(this);

        JLabel title_watchlist = new JLabel(ProgressTrackerViewModel.WATCHLIST_LABEL);
        title_watchlist.setHorizontalAlignment(20);

        JLabel title_inprogress = new JLabel(ProgressTrackerViewModel.INPROGRESS_LABEL);
        title_inprogress.setHorizontalAlignment(50);

        JLabel title_watchhistory = new JLabel(ProgressTrackerViewModel.WATCHHISTORY_LABEL);
        title_watchhistory.setHorizontalAlignment(80);

        JLabel title_status = new JLabel(ProgressTrackerViewModel.STATUS_LABEL);
        title_status.setHorizontalAlignment(110);

        JFrame frame = new JFrame("Progress Tracker");

        JPanel buttons = new JPanel(new GridLayout(3, 4, 10, 10));
        ProgressTrackerState currentState = progressTrackerViewModel.getState();

        for (Media media : currentState.getWatchlist()) {
            addtoInProgress = new JButton(ProgressTrackerViewModel.ADD_TO_PROG_BUTTON_LABEL);
            addtoInProgress.addActionListener(new ButtonClickListener(media));
            buttons.add(addtoInProgress);
        }
        for (Media media : currentState.getinProgress()) {
            addtoWatchHistory = new JButton(ProgressTrackerViewModel.ADD_TO_WATCHHISTORY_BUTTON_LABEL);
            addtoWatchHistory.addActionListener(new ButtonClickListener(media));
            buttons.add(addtoWatchHistory);
        }



       buttons.add(title_watchlist);
       buttons.add(title_inprogress);
       buttons.add(title_watchhistory);
       buttons.add(title_status);
       buttons.add(buttons);
       frame.getContentPane().add(buttons);
       frame.setSize(800, 800);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
    }
    private static class ButtonClickListener implements ActionListener {
        private final Media media;

        public ButtonClickListener(Media media) {
            this.media = media;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource().equals(addtoInProgress)) {
                ProgressTrackerState currentState = progressTrackerViewModel.getState();

                progressTrackerController.execute(currentState.getUser(),
                        media,
                        "Watchlist");
            }
            else if (evt.getSource().equals(addtoWatchHistory)) {
                ProgressTrackerState currentState = progressTrackerViewModel.getState();
                progressTrackerController.execute(currentState.getUser(),
                        media,
                        "In Progress");
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void propertyChange(PropertyChangeEvent evt) {
        ProgressTrackerState state = (ProgressTrackerState) evt.getNewValue();

        List<Media> watchlist = state.getWatchlist();
        List<Media> inProg = state.getinProgress();
        List<Media> watchhistory = state.getwatchHistory();
        Map<String, List<Media>> status = state.getStatuses();

        gridPanel.removeAll();

        for (Media media: watchlist) {
            String title = media.getTitle();
            gridPanel.add(new JLabel(title));
        }

        for (Media media: inProg) {
            String title = media.getTitle();
            gridPanel.add(new JLabel(title));
        }

        for (Media media: watchhistory) {
            String title = media.getTitle();
            gridPanel.add(new JLabel(title));
        }

        for (Map.Entry<String, List<Media>> medias: status.entrySet()) {
            String stat = medias.getKey();
            for (Media media: medias.getValue()) {
                String title = media.getTitle();
                gridPanel.add(new JLabel(stat+" "+title));
            }
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }
}
