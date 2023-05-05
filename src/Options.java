import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options {

    public JPanel Options(){
        JPanel layout = new JPanel();
        layout.setBounds(Utils.instance.panelOffsetX, Utils.instance.panelOffsetY, Utils.instance.panelWidth, Utils.instance.panelHeight);
        layout.setAlignmentX(Component.CENTER_ALIGNMENT);
        layout.setAlignmentY(Component.CENTER_ALIGNMENT);
        layout.setLayout(new BoxLayout(layout,BoxLayout.PAGE_AXIS));

        JLabel l = new JLabel("Please choose desired level");

        //new Game
        Button newGame = new Button("1");
        newGame.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player.instance.setLevel(1);
                SceneController.instance.MainMenu();
            }
        });
        layout.add(newGame);

        //Options
        Button Options = new Button("2");
        Options.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        Options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player.instance.setLevel(2);
                SceneController.instance.MainMenu();

            }
        });
        layout.add(Options);

        //Scores
        Button Scores = new Button("3");
        Scores.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        Scores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player.instance.setLevel(3);
                SceneController.instance.MainMenu();

            }
        });
        layout.add(Scores);



        Button About = new Button("Main Menu");
        About.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        About.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SceneController.instance.MainMenu();

            }
        });
        layout.add(About);



        return layout;
    }
}
