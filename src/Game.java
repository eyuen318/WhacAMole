import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game implements ActionListener {
    Mole mole1 = new Mole(100, 100);

    Mole[] moles;
    private static int counter = 0;

    private WhacAMoleViewer window;
    private static int DELAY_IN_MILLISEC = 21;

    public static void main(String[] args){
        Game game = new Game();

        Timer clock = new Timer(DELAY_IN_MILLISEC, game);

        clock.start();
    }
    public Game()
    {
        moles = new Mole[5];
        moles[0] = new Mole(100, 100);
        moles[1] = new Mole(500, 100);
        moles[2] = new Mole(300, 300);
        moles[3] = new Mole(100, 500);
        moles[4] = new Mole(500, 500);
        window = new WhacAMoleViewer(counter, moles ,this);

    }


    public void actionPerformed(ActionEvent e) {
        //goes thru array of all moles and randomly determines if it will pop up and for how long
        for (Mole b : moles) {

                if ((int) (Math.random() * 225 )== 0 && !b.isUp()) {
                    b.goUp();
                    b.randTimer();
                }
                if(b.getTime() == 0) {
                    b.goDown();
                }
                b.decreaseTimer();

        }

        window.repaint();
    }
}
