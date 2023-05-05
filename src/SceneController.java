
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;


public class SceneController {
    private Container root;
    public Frame window;

    //Layout
    private Container mainMenu;
    private Container options;
    private NewGame newGame;
    private Container endGame;
    private Container scoreScreen;
    private Container help;


    public static SceneController instance;

    public void closeKey(){
        InputMap inputMap = ((JPanel)this.root).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = ((JPanel)this.root).getActionMap();


        Action close = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
            }
        };

        inputMap.put(KeyStroke.getKeyStroke("ctrl Q"),"close");
        actionMap.put("close",close);
    }

    private void addKeyBindings(){
        InputMap inputMap = ((JPanel)this.root).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = ((JPanel)this.root).getActionMap();


        Action playy = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame.setPlay(true);
            }
        };

        Action moveRight = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame.moveRight();
            }
        };

        Action moveLeft = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame.moveLeft();
            }
        };


        inputMap.put(KeyStroke.getKeyStroke("SPACE"),"play");
        actionMap.put("play",playy);

        inputMap.put(KeyStroke.getKeyStroke("RIGHT"),"right");
        actionMap.put("right",moveRight);

        inputMap.put(KeyStroke.getKeyStroke("LEFT"),"left");
        actionMap.put("left",moveLeft);

        this.root.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(e.getX() / 2 > 325){

                }
                else{
                    newGame.paddle.setX(e.getX()/2);
                }



            }

            @Override
            public void mouseMoved(MouseEvent e) {


            }
        });


    }

    public SceneController(JFrame root) {

        this.instance = this;
        this.root = root.getContentPane();
        this.window = root;
        this.mainMenu = new MainMenu().MainMenu();
        this.options = new Options().Options();

        closeKey();
    }

    public void MainMenu(){
        this.root.removeAll();
        this.root.invalidate();
        this.root.add(mainMenu);
        this.root.revalidate();
        this.root.repaint();
    }

    public void Options(){

        this.root.removeAll();
        this.root.invalidate();
        this.root.add(options);
        this.root.revalidate();
        this.root.repaint();
    }

    public void NewGame(){
        this.root.removeAll();
        this.root.invalidate();
        this.newGame = new NewGame(Player.instance.getLevel());
        this.root.add(newGame);
        this.root.revalidate();
        this.root.repaint();
        addKeyBindings();

    }

    public void EndGame(boolean f){
        this.endGame = new EndGame().EndGame(f);
        this.root.removeAll();
        this.root.invalidate();
        this.root.add(this.endGame);
        this.root.revalidate();
        this.root.repaint();

    }


    public void ScoreScreen(){
        this.scoreScreen = new ScoreScreen().ScoreScreen();
        this.root.removeAll();
        this.root.invalidate();
        this.root.add(scoreScreen);
        this.root.revalidate();
        this.root.repaint();
    }


    public void Help(){
        this.help = new HelpPage().HelpPage();
        this.root.removeAll();
        this.root.invalidate();
        this.root.add(help);
        this.root.revalidate();
        this.root.repaint();
    }

}
