import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mole{
    private int xVal;
    private int yVal;
    private boolean isClicked;
    private boolean isUp = false;
    private Image diglett, hole;

    private int timer;


    public Mole(int xVal, int yVal)
    {
        this.diglett = new ImageIcon("Resources/diglett1.png").getImage();
        this.hole = new ImageIcon("Resources/digletthole.png").getImage();
        this.xVal = xVal;
        this.yVal = yVal;
        this.isClicked = false;
        this.isUp = false;
        this.timer = 30 + (int)(Math.random() * 31);
    }

    public void randTimer(){
        timer = 30 + (int)(Math.random() * 31);
    }

    public void decreaseTimer(){
        timer--;
    }

    public int getTime(){
        return timer;
    }

    public int getX(){
        return xVal;
    }

    public int getY() {
        return yVal;
    }

    public Image diglett(){
        return diglett;
    }

    public Image hole(){
        return hole;
    }

    public boolean isUp(){
        return isUp;
    }

    public void goDown(){
        isUp = false;
    }

    public void goUp()
    {
        isUp = true;
    }


}
