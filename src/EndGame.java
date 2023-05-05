import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EndGame{

    public JPanel EndGame(boolean isFinished){
        JPanel layout = new JPanel();
        layout.setBounds(Utils.instance.panelOffsetX, Utils.instance.panelOffsetY, Utils.instance.panelWidth, 150);
        layout.setAlignmentX(Component.CENTER_ALIGNMENT);
        layout.setAlignmentY(Component.CENTER_ALIGNMENT);
        layout.setLayout(new BoxLayout(layout,BoxLayout.PAGE_AXIS));

        //new Game
        JLabel end = new JLabel(isFinished ? "Congratulations Your Score is: " : "Your Score is: ");
        layout.add(end);

        //Options
        JLabel score = new JLabel(String.valueOf(Player.instance.getScores()));
        layout.add(score);

        //Scores
        JTextField tf = new JTextField();
        tf.setMaximumSize(new Dimension(400,60));
        layout.add(tf);

        // Help

        Button save = new Button("Save");
        save.setSize(Utils.instance.buttonWidth, Utils.instance.buttonHeight);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save
                if(tf.getText().equals("") || tf.getText().equals(" ")){
                    end.setText("The name should not be empty");
                }
                else{
                    if(ArrayController.instance.getIndex(tf.getText().trim()) != -1){
                        ArrayController.instance.getScores().get(ArrayController.instance.getIndex(tf.getText().trim())).setScore(Player.instance.getScores());
                        ArrayController.instance.getScores().get(ArrayController.instance.getIndex(tf.getText().trim())).setDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
                        SceneController.instance.MainMenu();
                    }
                    else{
                        Scores s = new Scores(tf.getText().trim(),Player.instance.getScores());
                        s.setDate(new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime()));

                        ArrayController.instance.getScores().add(s);
                        ArrayController.instance.create();
                        SceneController.instance.MainMenu();
                    }
                }

            }
        });
        layout.add(save);

        //About

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
