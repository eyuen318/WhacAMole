import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLOutput;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WhacAMoleViewer extends JFrame implements MouseListener, MouseMotionListener {
    private Image mallet;
    public static final int WINDOW_WIDTH = 700;
    public static final int WINDOW_HEIGHT = 800;


    private Game game;
    private Mole[] moles;
    private Image bush;
    private int counter;
    private static int highScore;

    private Image rocks;


    public void highScore(int current)
    {
        if(current >= highScore)
        {
            highScore = current;
        }
    }
    public WhacAMoleViewer(int counter, Mole[] moles, Game g){
        mallet = new ImageIcon("Resources/mallet.png").getImage();
        bush = new ImageIcon("Resources/bush.png").getImage();
        rocks = new ImageIcon("Resources/rocks.png").getImage();
        this.setTitle("Whac-A-Mole");
        this.counter = counter;
        //this.createBufferStrategy(2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setVisible(true);
        this.game = g;
        this.moles = moles;

    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        g.setColor(new Color(13, 102, 44));
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.fillOval(105, 105, 90, 45);
        g.setColor(new Color(255, 255, 255));
        g.drawString("Score: ", 100, 80);
        g.drawString(Integer.toString(counter), 200, 80 );
        g.drawString("High score: ", 320, 80);
        g.drawString(Integer.toString(highScore), 500, 80 );

        this.draw(bush, 450, 311, g);
        this.draw(bush, 324, 120, g);
        this.draw(bush, 234, 650, g);
        this.draw(rocks, 605, 670, g);
        this.draw(rocks, 123, 240, g);
        if (moles[0].isUp()) {
            this.draw(moles[0].diglett(), moles[0].getX(), moles[0].getY(), g);
        } else {
            this.draw(moles[0].hole(), moles[0].getX(), moles[0].getY(), g);
        }
        if (moles[1].isUp()) {
            this.draw(moles[1].diglett(), moles[1].getX(), moles[1].getY(), g);
        } else {
            //draw hole
            this.draw(moles[1].hole(), moles[1].getX(), moles[1].getY(), g);
        }
        if (moles[2].isUp()) {
            this.draw(moles[2].diglett(), moles[2].getX(), moles[2].getY(), g);
        } else {
            //draw hole
            this.draw(moles[2].hole(), moles[2].getX(), moles[2].getY(), g);
        }
        if (moles[3].isUp()) {
            this.draw(moles[3].diglett(), moles[3].getX(), moles[3].getY(), g);
        } else {
            //draw hole
            this.draw(moles[3].hole(), moles[3].getX(), moles[3].getY(), g);
        }
        if (moles[4].isUp()) {
            this.draw(moles[4].diglett(), moles[4].getX(), moles[4].getY(), g);
        } else {
            //draw hole
            this.draw(moles[4].hole(), moles[4].getX(), moles[4].getY(), g);
        }
        g.setColor(Color.BLACK);

    }


    public void mousePressed(MouseEvent e)
    {
        //goes thru moles array. Every time mouse is pressed, checks if the x value of mouse is within 55 pixels of mole in either direction.
        //goes thru moles array. Every time mouse is pressed, checks if the y value of mouse is within 65 pixels of mole in either direction.
        //these checks will only work if the mole is popped up by using the isUp() function.
        for (int i = 0; i < moles.length; i++) {
            if(moles[i].isUp() && ((e.getX() + 55 > moles[i].getX()) && (e.getX() - 55 < moles[i].getX()) && (e.getY() + 65 > moles[i].getY()) && (e.getY() - 65 < moles[i].getY())))
            {
                //increases score by one if true
                counter++;
                return;
            }
        }

    }


    public void mouseReleased(MouseEvent e)
    {


    }


    public void mouseClicked(MouseEvent e)
    {

    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }

    public void mouseDragged(MouseEvent e) { // this method gets called every time you click and drag

        // find out where the mouse is


    }

    public void mouseMoved(MouseEvent e) { // this method gets called everytime you move the mouse

    }

    public void draw(Image pic, int x, int y, Graphics g){
        g.drawImage(pic, x, y, 90, 90, this);
    }

}

