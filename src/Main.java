import javax.swing.*;
import java.awt.*;
import java.io.*;


public class Main {
    static SceneController sceneController;
    static Utils utils;
    static Player player;
    static ArrayController arrayController;
    public static void main(String[] args){

        utils = new Utils();
        player = new Player();
        arrayController = new ArrayController();

        File f = new File("scores.dat");
        if(f.exists()){
            try {
                BufferedReader br = new BufferedReader(new FileReader("scores.bat"));
                String line;

                while ((line = br.readLine()) != null){
                    String[] ll = line.split(":");
                    if(ll.length > 1){
                        Scores s = new Scores(ll[0],Integer.parseInt(ll[1].trim()));
                        arrayController.getScores().add(s);
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JFrame window = new JFrame();

        window.setBounds(0,0,Utils.instance.sceneWidth, Utils.instance.sceneHeight);
        window.setLayout(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sceneController = new SceneController(window);
        sceneController.MainMenu();
        window.setVisible(true);


    }
}
