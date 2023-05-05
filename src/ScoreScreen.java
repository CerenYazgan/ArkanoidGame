import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreScreen {
    public JPanel ScoreScreen(){

        JPanel layout = new JPanel();
        layout.setBounds(Utils.instance.panelOffsetX, Utils.instance.panelOffsetY, Utils.instance.panelWidth, Utils.instance.panelHeight);
        layout.setAlignmentX(Component.CENTER_ALIGNMENT);
        layout.setAlignmentY(Component.CENTER_ALIGNMENT);
        layout.setLayout(new BoxLayout(layout,BoxLayout.PAGE_AXIS));
        JLabel tit = new JLabel("Highest Scores");
        layout.add(tit);

        ArrayController.instance.sortt();
        for(int i = 0; i < ArrayController.instance.getScores().size() && i < 11;i++){

            JLabel l = new JLabel(ArrayController.instance.getScores().get(i).getName() + " : " + ArrayController.instance.getScores().get(i).getScore());
            l.setAlignmentX(Component.CENTER_ALIGNMENT);
            layout.add(l);

        }


        Button About = new Button("Main Menu");
        About.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        About.setMaximumSize(new Dimension(100,56));
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
