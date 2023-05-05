import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewGame extends JPanel implements ActionListener {

    private boolean play = false;

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    private int score = 0;
    private int bricks = 27;

    private int level;


    private ArrayList<Brick> brick = new ArrayList<Brick>();

    private Timer timer;
    private int delay = 1;

    private int paddleX = 140;
    private int paddleY = 260;

    private int ballX = 160;
    private int ballY = 240;

    //340x320
    private int speedX = -1;
    private int speedY = -2;



    Ball ball = new Ball(ballX,ballY);
    Paddle paddle = new Paddle(paddleX,paddleY);
    JLabel scores = new JLabel("Score : " + score);
    JLabel levels = new JLabel("Level : " + Player.instance.getLevel());
    JLabel lives = new JLabel("Lives : " + Player.instance.getLives());


    public NewGame(int level)  {
        this.level = level;
        if(this.level == 2){
            speedX = -2;
            speedY = -3;
        }
        else if(this.level == 3){
            speedX = -4;
            speedY = -7;
        }

        Player.instance.over = false;
        if(this.level == 1){
            for(int j = 50; j > 20; j = j - 10){
                for(int i = 280;i > 10; i = i - 30){
                    Brick br = new Brick(i,j,"h");
                    br.setSize(new Dimension(720,720));
                    add(br);
                    brick.add(br);
                }

            }
        }
        else if(this.level == 2){
            int s = 1;
            for(int j = 50; j > 20; j = j - 10){
                if(s % 2 == 1){
                    for(int i = 280;i > 10; i = i - 30){
                        Brick br = new Brick(i,j,"h");
                        br.setSize(new Dimension(720,720));
                        add(br);
                        brick.add(br);
                    }
                }
                else{
                    for(int i = 280;i > 10; i = i - 30){
                        Brick br = new Brick(i,j,"o");
                        br.setSize(new Dimension(720,720));
                        add(br);
                        brick.add(br);
                    }
                }
                s++;

            }
        }
        else if(this.level ==  3){
            int s = 1;
            for(int j = 50; j > 20; j = j - 10){
                if(s == 1){
                    for(int i = 280;i > 10; i = i - 30){
                        Brick br = new Brick(i,j,"h");
                        br.setSize(new Dimension(720,720));
                        add(br);
                        brick.add(br);
                    }
                }
                else if(s == 2){
                    for(int i = 280;i > 10; i = i - 30){
                        Brick br = new Brick(i,j,"o");
                        br.setSize(new Dimension(720,720));
                        add(br);
                        brick.add(br);
                    }
                }
                else{
                    for(int i = 280;i > 10; i = i - 30){
                        Brick br = new Brick(i,j,"b");
                        br.setSize(new Dimension(720,720));
                        add(br);
                        brick.add(br);
                    }
                }
                s++;

            }
        }
        setLayout(null);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setSize(new Dimension(720,720));
        ball.setSize(new Dimension(720,720));
        paddle.setSize(new Dimension(720,720));
        scores.setSize(new Dimension(160,20));
        levels.setBounds(300,0,160,20);
        lives.setBounds(580,0,160,20);
        add(levels);
        add(lives);
        add(scores);
        add(paddle);
        add(ball);
        timer = new Timer(delay,this);
        timer.start();
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play){
            scores.setText("Score : " + score);
            levels.setText("Level : " + Player.instance.getLevel());
            lives.setText("Lives : " + Player.instance.getLives());
            if(new Rectangle(ball.getX(),ball.getY(),5,5).intersects(new Rectangle(paddle.getX(),paddle.getY(),60,5))){
                boolean right = ball.getX() >= ((paddle.getX() + 60) - 8);
                boolean left = ball.getX() <= ((paddle.getX() + 8 ));

                if(right || left){
                    speedX *= -1;
                }
                speedY *= -1;
            }



            if(!brick.isEmpty()){
                brick.removeIf(brick1 -> checkCol(brick1));
            }
            else{
                if(this.level == 3){
                    // go to end game
                    Player.instance.over = true;
                    Player.instance.setScores(score);
                    timer.stop();
                    SceneController.instance.EndGame(true);

                }
                else{
                    // go to new Game for level + 1
                    Player.instance.setLevel(Player.instance.getLevel()+1);
                    timer.stop();
                    SceneController.instance.NewGame();
                }
            }

            if(ball.getX() < 0 || ball.getX() > 340){
                speedX = -1*speedX;
            }
            if(ball.getY() < 0){
                speedY = -1*speedY;
            }

            if(ball.getY() > 320){
                // dead
                if(Player.instance.getLives() == 1){
                    // dead go to end  scene
                    Player.instance.over = true;
                    Player.instance.setScores(score);
                    play = false;
                    speedY = -1*speedY;
                    timer.stop();
                    SceneController.instance.EndGame(false);
                }
                else{
                    Player.instance.setLives(Player.instance.getLives()-1);
                    speedY = -1*speedY;
                }


            }
            ball.Move(speedX,speedY);

        }
        repaint();

    }

    public boolean checkCol(Brick br){
        if(new Rectangle(ball.getX(),ball.getY(),8,5).intersects(new Rectangle(br.getX(),br.getY(),20,10))){
            boolean right = ball.getX() >= ((br.getX() + br.getSizeX()) - 8);
            boolean left = ball.getX() <= ((br.getX() + 8 ));
            boolean bottom = ball.getY() >= ((br.getY() + br.getSizeY()) -8);
            boolean top = ball.getY() <= (br.getY() + 8);

            if(right || left){
                speedX = -1*speedX;
            }
            if(top||bottom){
                speedY = -1*speedY;
            }

            if(br.getHitpoint() == 1){
                if(br.getBrickTye().equals("b")){
                    score += 300;
                }
                else if(br.getBrickTye().equals("o")){
                    score += 200;
                }
                else{
                    score += 100;
                }
                remove(br);
                return true;
            }
            else{
                br.setHitpoint(br.getHitpoint()-1);
                return false;
            }

        }
        return false;
    }


    public void moveRight(){
        if(paddleX > 290){
            paddleX = 300;
        }
        else{
            paddleX += 10;
        }

        paddle.Move(paddleX,paddleY);
    }
    public void moveLeft(){
        if(paddleX < 10){
            paddleX = 0;
        }
        else{
            paddleX -= 10;
        }

        paddle.Move(paddleX,paddleY);
    }
}
