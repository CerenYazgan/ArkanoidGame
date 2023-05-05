import javax.swing.*;
import java.awt.*;

public class Brick extends JComponent {
    private int x;
    private int y;
    private int sizeX;
    private int sizeY;
    private String brickTye;
    private int hitpoint;

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getHitpoint() {
        return hitpoint;
    }

    public void setHitpoint(int hitpoint) {
        this.hitpoint = hitpoint;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public String getBrickTye() {
        return brickTye;
    }

    public Brick(int x, int y, String brickTye){
        this.brickTye = brickTye;
        this.x = x;
        this.y = y;
        this.sizeX = 30;
        this.sizeY = 10;
        if(this.brickTye.equals("b")){
            this.hitpoint = 3;
        }
        else if(this.brickTye.equals("o")){
            this.hitpoint = 2;
        }
        else{
            this.hitpoint = 1;
        }

    }

    @Override
    public void paintComponent(Graphics g){
        if(brickTye.equals("b")){
            g.setColor(Color.black);
        }
        else if(brickTye.equals("o")){
            g.setColor(Color.orange);
        }
        else{
            g.setColor(Color.red);
        }

        g.fillRect(this.x,this.y,this.sizeX,this.sizeY);


    }
}
