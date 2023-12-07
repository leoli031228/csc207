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
    public final String viewName = "Progress Track";
    public static ProgressTrackerController progressTrackerController = null;
    public static ProgressTrackerViewModel progressTrackerViewModel = null;

    private static JButton addtoInProgress;
    private static JButton addtoWatchHistory;
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JFrame frame = new JFrame("Progress Tracker");


    public ProgressTrackerView(ProgressTrackerController controller,
                               ProgressTrackerViewModel progressTrackerViewModel) {

        this.progressTrackerController = controller;
        this.progressTrackerViewModel = progressTrackerViewModel;
        progressTrackerViewModel.addPropertyChangeListener(this);
        createUI();

    }

    private void createUI() {

        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        panel4.removeAll();

        JLabel title_watchlist = new JLabel(ProgressTrackerViewModel.WATCHLIST_LABEL);
        title_watchlist.setFont(new Font("Calibri", Font.BOLD, 20));
        title_watchlist.setVerticalAlignment(SwingConstants.TOP);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(title_watchlist);



        JLabel title_inprogress = new JLabel(ProgressTrackerViewModel.INPROGRESS_LABEL);
        title_inprogress.setVerticalAlignment(SwingConstants.TOP);
        title_inprogress.setFont(new Font("Calibri", Font.BOLD, 20));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(title_inprogress);

        JLabel title_watchhistory = new JLabel(ProgressTrackerViewModel.WATCHHISTORY_LABEL);
        title_watchhistory.setFont(new Font("Calibri", Font.BOLD, 20));
        title_watchhistory.setVerticalAlignment(SwingConstants.TOP);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(title_watchhistory);

        JLabel title_status = new JLabel(ProgressTrackerViewModel.STATUS_LABEL);
        title_status.setFont(new Font("Calibri", Font.BOLD, 20));
        title_status.setVerticalAlignment(SwingConstants.TOP);
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.add(title_status);

        frame.setLayout(new GridLayout(2,2));


        ProgressTrackerState currentState = progressTrackerViewModel.getState();

        for (Media media : currentState.getWatchlist()) {
            addtoInProgress = new JButton(ProgressTrackerViewModel.ADD_TO_PROG_BUTTON_LABEL);
            addtoInProgress.addActionListener(new ButtonClickListener(media));
            panel1.add(new JLabel(media.getTitle()));
            panel1.add(addtoInProgress);
        }
        for (Media media : currentState.getinProgress()) {
            addtoWatchHistory = new JButton(ProgressTrackerViewModel.ADD_TO_WATCHHISTORY_BUTTON_LABEL);
            addtoWatchHistory.addActionListener(new ButtonClickListener(media));
            panel2.add(new JLabel(media.getTitle()));
            panel2.add(addtoWatchHistory);
        }
        for (Media media : currentState.getwatchHistory()) {
            panel3.add(new JLabel(media.getTitle()));
        }

        for (Map.Entry<String, List<Media>> medias:  currentState.getStatuses().entrySet()) {
            String stat = medias.getKey();
            for (Media media: medias.getValue()) {
                String title = media.getTitle();
                panel4.add(new JLabel(stat+": "+title));
            }
        }


        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);


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
        updateViewContent(state);
    }

    private void updateViewContent(ProgressTrackerState state) {
        List<Media> watchlist = state.getWatchlist();
        List<Media> inProg = state.getinProgress();
        List<Media> watchhistory = state.getwatchHistory();
        Map<String, List<Media>> status = state.getStatuses();

        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        panel4.removeAll();

        JLabel title_watchlist = new JLabel(ProgressTrackerViewModel.WATCHLIST_LABEL);
        title_watchlist.setFont(new Font("Calibri", Font.BOLD, 20));
        title_watchlist.setVerticalAlignment(SwingConstants.TOP);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(title_watchlist);



        JLabel title_inprogress = new JLabel(ProgressTrackerViewModel.INPROGRESS_LABEL);
        title_inprogress.setVerticalAlignment(SwingConstants.TOP);
        title_inprogress.setFont(new Font("Calibri", Font.BOLD, 20));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(title_inprogress);

        JLabel title_watchhistory = new JLabel(ProgressTrackerViewModel.WATCHHISTORY_LABEL);
        title_watchhistory.setFont(new Font("Calibri", Font.BOLD, 20));
        title_watchhistory.setVerticalAlignment(SwingConstants.TOP);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(title_watchhistory);

        JLabel title_status = new JLabel(ProgressTrackerViewModel.STATUS_LABEL);
        title_status.setFont(new Font("Calibri", Font.BOLD, 20));
        title_status.setVerticalAlignment(SwingConstants.TOP);
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.add(title_status);




        for (Media media: watchlist) {
            String title = media.getTitle();
            panel1.add(new JLabel(title));
        }
        for (Media media : inProg) {
            String title = media.getTitle();
            panel2.add(new JLabel(title));
        }


        for (Media media: watchhistory) {
            String title = media.getTitle();
            panel3.add(new JLabel(title));
        }

        for (Map.Entry<String, List<Media>> medias:  status.entrySet()) {
            String stat = medias.getKey();
            for (Media media: medias.getValue()) {
                String title = media.getTitle();
                panel4.add(new JLabel(stat+": "+title));
            }
        }
        // Refresh and repaint the panels
        panel1.revalidate();
        panel2.revalidate();
        panel3.revalidate();
        panel4.revalidate();
        panel1.repaint();
        panel2.repaint();
        panel3.repaint();
        panel4.repaint();
        createUI();
    }
}
