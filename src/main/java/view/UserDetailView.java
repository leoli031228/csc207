package view;

import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDetailView extends JPanel {

    public static final String viewName = "UserDetailView";
    private User user;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    public UserDetailView(User user, JPanel cardPanel, CardLayout cardLayout, User currentUser) {
        this.user = user;
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        setLayout(new BorderLayout());

        JLabel nameLabel = new JLabel("Name: " + user.getUsername());
        JLabel emailLabel = new JLabel("Email: " + user.getEmail());
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(cardPanel, SearchFriendView.viewName));

        JButton addFriendButton = new JButton("Add as Friend");
        addFriendButton.addActionListener(e -> {
            System.out.println("Added " + user.getUsername() + " as a friend.");

            currentUser.addFriend(user);
            addFriendButton.setText("Added");
            addFriendButton.setEnabled(false);
        });

        add(nameLabel, BorderLayout.NORTH);
        add(emailLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(); // Panel for buttons
        buttonPanel.add(backButton);
        buttonPanel.add(addFriendButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public UserDetailView(User user, JPanel cardPanel, CardLayout cardLayout) {
        this.user = user;
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        setLayout(new BorderLayout());

        JLabel nameLabel = new JLabel("Name: " + user.getUsername());
        JLabel emailLabel = new JLabel("Email: " + user.getEmail());
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(cardPanel, SearchFriendView.viewName));

        add(nameLabel, BorderLayout.NORTH);
        add(emailLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(); // Panel for buttons
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
