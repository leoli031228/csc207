/*
package view;

import data_access.FileUserDataAccessObject;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public static final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;

    // 新加的搜索
    private JButton searchFriendButton;
    private JButton showFriendsButton;

    JLabel username;

    final JButton logOut;

    private final JPanel cardPanel;
    private final CardLayout cardLayout;
    private final FileUserDataAccessObject userDataAccessObject;


// A window with a title and a JButton.
    public LoggedInView(final LoggedInViewModel loggedInViewModel,
                        // 新加的两个，用来换 view
                        final JPanel cardPanel,
                        final CardLayout cardLayout,
                        final FileUserDataAccessObject userDataAccessObject) {
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.userDataAccessObject = userDataAccessObject;
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        JPanel buttons = new JPanel();
        logOut = new JButton(loggedInViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logOut);

        logOut.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(buttons);

        // 新加的搜索
        searchFriendButton = new JButton("Search Friend");
        buttons.add(searchFriendButton);
        searchFriendButton.addActionListener(this);

        // 新加的 show friends
        showFriendsButton = new JButton("Show My Friends");
        showFriendsButton.addActionListener(this);
        buttons.add(showFriendsButton);

    }

*
     * React to a button click that results in evt.


    public void actionPerformed(ActionEvent evt) {
        // 改的
        if (evt.getSource() == logOut) {
            // Log out action
            System.out.println("Clicked Log out");
        } else if (evt.getSource() == searchFriendButton) {
            // Search friend action
            // Here, you can switch the view to SearchFriendView, or open a dialog/window for it
            System.out.println("Search Friend clicked");
            cardLayout.show(cardPanel, SearchFriendView.viewName);
        } else if (evt.getSource() == showFriendsButton) {
            // Navigate to the friends list view
            // You need to implement this navigation based on your application's architecture
            System.out.println("Show Friends Button clicked");
            cardPanel.add(new FriendsListView(loggedInViewModel.getLoggedInUser(),
                    cardPanel, cardLayout, userDataAccessObject), FriendsListView.viewName);
            cardLayout.show(cardPanel, FriendsListView.viewName);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState state = (LoggedInState) evt.getNewValue();
        username.setText(state.getUsername());
    }
}
*/
