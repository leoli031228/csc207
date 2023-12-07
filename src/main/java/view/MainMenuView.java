package view;

import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.switch_view.SwitchViewController;
import view.SearchView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainMenuView extends JPanel implements ActionListener {
    public final String viewName = "main menu";

    private final SwitchViewController switchViewController;
    private final JButton home;
    private final JButton myProfile;
    private final JButton logout;
    private final JButton searchFriend;
    private final JButton searchMedia;

    public MainMenuView(SwitchViewController switchViewController) {
        this.switchViewController = switchViewController;

        JPanel buttons = new JPanel();
        JLabel title = new JLabel("Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        home = new JButton("Home");
        buttons.add(home);
        myProfile = new JButton("My Profile");
        buttons.add(myProfile);
        logout = new JButton("Log Out");
        buttons.add(logout);
        searchFriend = new JButton("Friends Search");
        buttons.add(searchFriend);
        searchMedia = new JButton("Search Media");
        buttons.add(searchMedia);

        home.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(home)) {
                            System.out.println("home clicked");
                            switchViewController.execute("home");
                        }
                    }
                }
        );

        myProfile.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(myProfile)) {
                            System.out.println("myProfile clicked");
                            switchViewController.execute("profile view");
                        }
                    }
                }
        );

        logout.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logout)) {
                            System.out.println("logout clicked");
                            switchViewController.execute("log out");

                        }
                    }
                }
        );

        searchFriend.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(searchFriend)) {
                            System.out.println("searchFriend clicked");
                            switchViewController.execute("SearchFriendView");
                        }
                    }
                }
        );

        searchMedia.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(searchMedia)) {
                            System.out.println("searchMedia clicked");
                            //switchViewController.execute("search");


                        }
                    }
                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
