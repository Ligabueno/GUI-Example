import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUI extends JFrame {


    public JButton bSTART = new JButton();
    public JButton bBACK = new JButton();
    public JButton bSETTINGS = new JButton();
    public JButton bQUIT = new JButton();
    public JButton bRESUME = new JButton();

      Panel panel;

    private Listener listener;

    public GUI(){

    super();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int framewidth = d.width/2;
    int frameheight = d.height/2;
    setSize(framewidth, frameheight);

    int x = 480;
    int y = 270;
    setLocation(x,y);
    setLayout(null);
    setTitle("GUI");
    setResizable(false);

//--------------------------------------------------------
    bSTART.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            bSTART_actionPerformed(e);
        }
    });
    int Startwidth = 200;
    int Startheight = 100;
    int Startx = (framewidth/2)-(Startwidth/2);
    int Starty = (frameheight/2)-(Startheight*2);
    bSTART.setText("START");
    bSTART.setBounds(Startx,Starty,Startwidth,Startheight);
    bSTART.setForeground(Color.BLACK);
    bSTART.setVisible(true);
    add(bSTART);

//--------------------------------------------------------
    bRESUME.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            bRESUME_actionPerformed(e);
        }
    });
    int Resumewidth = 200;
    int Resumeheight = 100;
    int Resumex = (framewidth/2)-(Resumewidth/2);
    int Resumey = (frameheight/2)-(Resumeheight*2);
    bRESUME.setText("RESUME");
    bRESUME.setBounds(Resumex, Resumey, Resumewidth, Resumeheight);
    bRESUME.setForeground(Color.BLACK);
    bRESUME.setVisible(false);
    add(bRESUME);
//--------------------------------------------------------

    bBACK.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            bBACK_actionPerformed(e);
        }
    });
    int Backwidth = 100;
    int Backheight = 100;
    int Backx = (framewidth/12)-(Backwidth/2);
    int Backy = frameheight-(frameheight/4)-(Backheight/3);
    bBACK.setText("BACK");
    bBACK.setBounds(Backx,Backy,Backwidth,Backheight);
    bBACK.setForeground(Color.BLACK);
    bBACK.setVisible(true);
    add(bBACK);
//--------------------------------------------------------

    bSETTINGS.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            bSETTINGS_actionPerformed(e);
        }
    });
    int Setwidth = 200;
    int Setheight = 100;
    int Setx = (framewidth/2)-(Setwidth/2);
    int Sety = (frameheight/2)-(Setheight/2)-(Setheight/4);
    bSETTINGS.setText("SETTINGS");
    bSETTINGS.setBounds(Setx,Sety,Setwidth,Setheight);
    bSETTINGS.setForeground(Color.BLACK);
    bSETTINGS.setVisible(true);
    add(bSETTINGS);
//--------------------------------------------------------
    bQUIT.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            bQUIT_actionPErformed(e);
        }
    });
    int Quitwidth = 200;
    int Quitheight = 100;
    int Quitx = (framewidth/2)-(Setwidth/2);
    int Quity = (frameheight/2)+(Quitheight/2);
    bQUIT.setText("QUIT");
    bQUIT.setBounds(Quitx,Quity,Quitwidth,Quitheight);
    bQUIT.setForeground(Color.BLACK);
    bQUIT.setVisible(true);
    add(bQUIT);

//--------------------------------------------------------

        //System.out.println(Startx+"|"+Starty);



    setVisible(true);
    new Panel(this);
    new Listener(this);


    }


    public void bSTART_actionPerformed(ActionEvent e){


        panel.jpanel.setVisible(true);
       // listener.timer.start();
        bSTART.setVisible(false);
        bSETTINGS.setVisible(false);
        bQUIT.setVisible(false);



    }
    public void bRESUME_actionPerformed(ActionEvent e){
        bRESUME.setVisible(false);
        bQUIT.setVisible(false);
        bSETTINGS.setVisible(false);
        panel.jpanel.setVisible(true);
        listener.timer.start();
    }
    public void bBACK_actionPerformed(ActionEvent e){
       /* bQUIT.setVisible(true);
        bSETTINGS.setVisible(true);
        bBACK.setVisible(false);
        // Wenn der Button back bei 0sek gedrückt wird,
        if (listener.sek == 0) {                                                    //wird der Button Start sichtbar wenn es keine 0 sek sind,
            bSTART.setVisible(true);                                         // wird der Button Resume sichtbar
        } else if (0 <= listener.sek) {

            bSTART.setVisible(false);
            bRESUME.setVisible(true);

        } else {
            bRESUME.setVisible(true);
        }*/

    }
    public void bSETTINGS_actionPerformed(ActionEvent e){
        bRESUME.setVisible(false);
        bQUIT.setVisible(false);
        bSETTINGS.setVisible(false);                                //Button Settings
        bBACK.setVisible(true);
        bSTART.setVisible(false);




    }
    public void bQUIT_actionPErformed(ActionEvent e){
    dispose();
    }
}