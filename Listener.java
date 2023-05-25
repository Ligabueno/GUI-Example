import javax.swing.*;
import java.awt.event.*;

public class Listener {

    public Timer timer = new Timer(1000, null);
    GUI gui;
    Panel panel;


    int sek = 0;



    public Listener(Panel panel){

        panel.jpanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });

        panel.jpanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });




    }
    public Listener(GUI gui){

     timer.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             timer_ActionPerformed(e);
         }
     });
    timer.setRepeats(true);
    timer.setInitialDelay(0);



    }



    public void timer_ActionPerformed(ActionEvent e){

        sek++;

        if (sek ==11){
            timer.stop();
            panel.jpanel.setVisible(false);
            gui.bSTART.setVisible(true);
            gui.bSETTINGS.setVisible(true);
            gui.bQUIT.setVisible(true);
            sek=0;

        }
    }
    public void keyPressed(KeyEvent e){

        if (KeyEvent.VK_ESCAPE == e.getKeyCode()){
            panel.jpanel.setVisible(false);
            gui.bSTART.setVisible(false);
            gui.bSETTINGS.setVisible(true);
            gui.bRESUME.setVisible(true);
            gui.bBACK.setVisible(true);
            gui.bQUIT.setVisible(true);

        }
    panel.jpanel.requestFocus();
    }

    public void mouseMoved(MouseEvent e){

        panel.jpanel.requestFocus();
    }

}
