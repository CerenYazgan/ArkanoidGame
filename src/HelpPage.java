import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpPage {

    public JPanel HelpPage(){
        JPanel layout = new JPanel();
        layout.setBounds(Utils.instance.panelOffsetX, Utils.instance.panelOffsetY, Utils.instance.panelWidth, Utils.instance.panelHeight);
        layout.setAlignmentX(Component.CENTER_ALIGNMENT);
        layout.setAlignmentY(Component.CENTER_ALIGNMENT);
        layout.setLayout(new BoxLayout(layout,BoxLayout.PAGE_AXIS));

        JLabel l = new JLabel("<html>The game will be start after pressing the Space bar.<br><br>" +
                "The paddle can be moved by left or right arrow keys and also with the mouse.<br><br>" +
                "The left side of the paddle can change the angle of the ball.<br><br>" +
                "To save your score at the end of the game you can type name and hit save button<br><br>"+
                "İf all the bricks has broken you would go to next level.</html>");

        layout.add(l);


        Button About = new Button("Main Menu");
        About.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        About.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SceneController.instance.MainMenu();

            }
        });
        About.setMaximumSize(new Dimension(100,56));
        layout.add(About);



        return layout;
    }
}
