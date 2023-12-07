/*
package view;

import data_access.FileUserDataAccessObject;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FriendsListView extends JPanel {

    public static final String viewName = "FriendsListView";
    private User currentUser;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JList<String> friendsList; // List to display friends

    public FriendsListView(String username, JPanel cardPanel, CardLayout cardLayout, FileUserDataAccessObject db) {
        this.currentUser = db.getUser(username);
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        setLayout(new BorderLayout());

        friendsList = new JList<>(convertFriendsToModel(currentUser.getFriendlist()));
        friendsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    // Open UserDetailView for the selected friend
                    String selectedFriendUsername = friendsList.getSelectedValue();
                    // Fetch User object for selectedFriendUsername and display UserDetailView
                    UserDetailView userDetailView =
                            new UserDetailView(db.getUser(selectedFriendUsername), cardPanel, cardLayout);
                    cardPanel.add(userDetailView, UserDetailView.viewName);
                    cardLayout.show(cardPanel, UserDetailView.viewName);
                }
            }
        });
        add(new JScrollPane(friendsList), BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(cardPanel, LoggedInView.viewName));
        add(backButton, BorderLayout.PAGE_END);
    }

    private DefaultListModel<String> convertFriendsToModel(ArrayList<User> friends) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (User friend : friends) {
            model.addElement(friend.getUsername());
        }
        return model;
    }
}

*/
