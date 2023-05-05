import javax.swing.*;
import java.awt.*;

public class Ball extends JComponent {
    private int x;
    private int y;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Ball(int x, int y){
        this.x = x;
        this.y = y;

    }

    public void Move(int xs,int ys){
        this.x += xs;
        this.y += ys;

    }



    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.red);
        g.fillOval(this.x,this.y,8,8);


    }
}
