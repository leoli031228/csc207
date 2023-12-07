/*
package view;

import data_access.FileUserDataAccessObject;
import entity.User;
import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SearchFriendView extends JPanel implements ActionListener, PropertyChangeListener {

    public static final String viewName = "SearchFriendView";
    private JTextField searchField;
    private JButton searchButton;
    private JList<String> resultList; // assuming the results are strings
    private JLabel titleLabel;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JButton backButton; // New back button
    private LoggedInViewModel loggedInViewModel;

    private FileUserDataAccessObject userDataAccessObject;

    public SearchFriendView(final FileUserDataAccessObject userDataAccessObject,
                            final JPanel cardPanel,
                            final CardLayout cardLayout,
                            final LoggedInViewModel loggedInViewModel) {
        this.userDataAccessObject = userDataAccessObject;
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.loggedInViewModel = loggedInViewModel;

        setLayout(new BorderLayout());

        // Initialize components
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        resultList = new JList<>();
        titleLabel = new JLabel("Type in to search for user");

        // Panel for title, search field, and button
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(titleLabel);
        northPanel.add(searchField);
        northPanel.add(searchButton);  // Add search button to this panel

        // Adding components to the main panel
        add(northPanel, BorderLayout.NORTH);  // Add the panel containing the title, search field, and button to the top
        add(new JScrollPane(resultList), BorderLayout.CENTER);  // Add the result list to the center

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        add(backButton, BorderLayout.PAGE_END);

        // double click to go to other page
        resultList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Double-click
                    int index = resultList.locationToIndex(evt.getPoint());
                    String selectedUserInfo = resultList.getModel().getElementAt(index);
                    String selectedUsername = selectedUserInfo.split(" - ")[0];
                    User selectedUser = userDataAccessObject.getUser(selectedUsername);

                    UserDetailView userDetailView = new UserDetailView(selectedUser, cardPanel, cardLayout,
                            userDataAccessObject.getUser(loggedInViewModel.getLoggedInUser()));
                    cardPanel.add(userDetailView, UserDetailView.viewName);
                    cardLayout.show(cardPanel, UserDetailView.viewName);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String searchQuery = searchField.getText();
            List<User> results = userDataAccessObject.searchUsers(searchQuery);
            System.out.println("Search results: " + results.size()); // Add this line to check the size of results

            // 把自己 filter 出去
            updateResultList(results.stream()
                    .filter(x -> !Objects.equals(x.getUsername(), loggedInViewModel.getLoggedInUser()))
                    .collect(Collectors.toList()));
        } else if (e.getSource() == backButton) {
            cardLayout.show(cardPanel, LoggedInView.viewName);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property changed: " + evt.getPropertyName() + ", New value: " + evt.getNewValue());
    }

    private void updateResultList(List<User> results) {
        System.out.printf(results.toString());
        DefaultListModel<String> model = new DefaultListModel<>();
        for (User user : results) {
            model.addElement(user.getUsername() + " - " + user.getEmail());
        }
        resultList.setModel(model);
    }
}
*/
