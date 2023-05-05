import javax.swing.*;
import java.awt.*;

public class Paddle extends JComponent {
    private int x;
    private int y;

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Paddle(int x, int y){
        this.x = x;
        this.y = y;

    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.green);
        g.fillRect(this.x,this.y,60,5);

    }
    public void Move(int xs,int ys){
        this.x = xs;
        this.y = ys;
    }
}
