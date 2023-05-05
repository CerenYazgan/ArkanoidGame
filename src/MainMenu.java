import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MainMenu {

    public JPanel MainMenu(){
        JPanel layout = new JPanel();
        layout.setBounds(Utils.instance.panelOffsetX, Utils.instance.panelOffsetY, Utils.instance.panelWidth, Utils.instance.panelHeight);
        layout.setAlignmentX(Component.CENTER_ALIGNMENT);
        layout.setAlignmentY(Component.CENTER_ALIGNMENT);
        layout.setLayout(new BoxLayout(layout,BoxLayout.PAGE_AXIS));

        //new Game
        Button newGame = new Button("New Game");

        newGame.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player.instance.setLives(3);
                Player.instance.setScores(0);
                if(Player.instance.over){
                    Player.instance.setLevel(1);
                }
                SceneController.instance.NewGame();
            }
        });
        layout.add(newGame);

        //Options
        Button Options = new Button("Options");
        Options.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        Options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SceneController.instance.Options();
            }
        });
        layout.add(Options);

        //Scores
        Button Scores = new Button("Scores");
        Scores.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        Scores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SceneController.instance.ScoreScreen();

            }
        });
        layout.add(Scores);

        // Help

        Button Help = new Button("Help");
        Help.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        Help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SceneController.instance.Help();

            }
        });
        layout.add(Help);

        //About

        Button About = new Button("About");
        About.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        About.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(SceneController.instance.window,
                        "<html>Name : Ceren <br> " +
                                "Surname : Yazgan<br>" +
                                "School Number : 20200702099 <br>" +
                                "E-Mail : ceren.yazgan@std.yeditepe.edu.tr" +
                                "</html>",
                        "About",
                        JOptionPane.WARNING_MESSAGE);

            }
        });
        layout.add(About);

        //Exit
        Button Exit = new Button("Exit");
        Exit.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SceneController.instance.window.dispatchEvent(new WindowEvent(SceneController.instance.window, WindowEvent.WINDOW_CLOSING));

            }
        });
        layout.add(Exit);



        return layout;
    }
}
