import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
public class GUI extends JFrame {
  
  
  public JButton bSTART = new JButton();
  public JButton bBACK = new JButton();
  public JButton bSETTINGS = new JButton();
  public JButton bQUIT = new JButton();
  public JButton bRESUME = new JButton();
  Timer timer = new Timer(1000, null);
  Dimension frameSize;
  public static int sek = 0;
  public Panel jpanel;
  
  
  public GUI(){
    super();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frameSize = new Dimension(d.width/2, d.height/2);
    jpanel = new Panel(frameSize);
    jpanel.setVisible(false);
    add(jpanel);
    setSize(frameSize);
    
    int x = 480,y = 270;
    setLocation(x,y);
    setLayout(null);
    setTitle("GUI");
    setResizable(false);
    add(jpanel);
    
    //--------------------------------------------------------
    int startWidth = 200, startHeight = 100;
    int startX = (frameSize.width/2)-(startWidth/2);
    int startY = (frameSize.height/2)-(startHeight*2);
    bSTART.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jpanel.setVisible(true);
        timer.start();
        bSTART.setVisible(false);
        bSETTINGS.setVisible(false);
        bQUIT.setVisible(false);
      }
    });
    bSTART.setText("START");
    bSTART.setBounds(startX,startY,startWidth,startHeight);
    bSTART.setForeground(Color.BLACK);
    bSTART.setVisible(true);
    bSTART.setFocusable(false);
    add(bSTART);
    
    //--------------------------------------------------------
    int resumeWidth = 200, resumeHeight = 100;
    int resumeX = (frameSize.width/2)-(resumeWidth/2);
    int resumeY = (frameSize.height/2)-(resumeHeight*2);
    bRESUME.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        bRESUME.setVisible(false);
        bQUIT.setVisible(false);
        bSETTINGS.setVisible(false);
        jpanel.setVisible(true);
        timer.start();
      }
    });
    bRESUME.setText("RESUME");
    bRESUME.setBounds(resumeX, resumeY, resumeWidth, resumeHeight);
    bRESUME.setForeground(Color.BLACK);
    bRESUME.setVisible(false);
    bRESUME.setFocusable(false);
    add(bRESUME);
    //--------------------------------------------------------
    int backWidth = 100, backHeight = 100;
    int backX = (frameSize.width/12)-(backWidth/2);
    int backY = frameSize.height-(frameSize.height/4)-(backHeight/3);
    bBACK.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        bQUIT.setVisible(true);
        bSETTINGS.setVisible(true);
        bBACK.setVisible(false);
        // Wenn der Button back bei 0sek gedrückt wird,
        if (sek == 0) {                                                    //wird der Button Start sichtbar wenn es keine 0 sek sind,
          bSTART.setVisible(true);                                         // wird der Button Resume sichtbar
        } else if (0 <= sek) {
          
          bSTART.setVisible(false);
          bRESUME.setVisible(true);
          
        } else {
          bRESUME.setVisible(true);
        }
      }
    });
    bBACK.setText("BACK");
    bBACK.setBounds(backX,backY,backWidth,backHeight);
    bBACK.setForeground(Color.BLACK);
    bBACK.setVisible(false);
    bBACK.setFocusable(false);
    add(bBACK);
    //--------------------------------------------------------
    int setWidth = 200, setHeight = 100;
    int setX = (frameSize.width/2)-(setWidth/2);
    int setY = (frameSize.height/2)-(setHeight/2)-(setHeight/4);
    bSETTINGS.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        bRESUME.setVisible(false);
        bQUIT.setVisible(false);
        bSETTINGS.setVisible(false);                                //Button Settings
        bBACK.setVisible(true);
        bSTART.setVisible(false);
      }
    });
    bSETTINGS.setText("SETTINGS");
    bSETTINGS.setBounds(setX,setY,setWidth,setHeight);
    bSETTINGS.setForeground(Color.BLACK);
    bSETTINGS.setVisible(true);
    bSETTINGS.setFocusable(false);
    add(bSETTINGS);
    //--------------------------------------------------------
    int quitWidth = 200, quitHeight = 100;
    int quitX = (frameSize.width/2)-(quitWidth/2);
    int quitY = (frameSize.height/2)+(quitHeight/2);
    bQUIT.addActionListener(new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    bQUIT.setText("QUIT");
    bQUIT.setBounds(quitX,quitY,quitWidth,quitHeight);
    bQUIT.setForeground(Color.BLACK);
    bQUIT.setVisible(true);
    bQUIT.setFocusable(false);
    add(bQUIT);
    //--------------------------------------------------------
    timer.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        sek++;
        if (sek == 11){
          timer.stop();
          jpanel.setVisible(false);
          bSTART.setVisible(true);
          bSETTINGS.setVisible(true);
          bQUIT.setVisible(true);
          sek=0;
        }     
      }
    });
    //--------------------------------------------------------
    addKeyListener(new KeyAdapter(){
      @Override
      public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        if (KeyEvent.VK_ESCAPE == e.getKeyCode()&&jpanel.isVisible()){
          jpanel.setVisible(false);
          bSTART.setVisible(false);
          bSETTINGS.setVisible(true);
          bRESUME.setVisible(true);
          bBACK.setVisible(false);
          bQUIT.setVisible(true);
        }
      }
    });
    //System.out.println(Startx+"|"+Starty);
    
    setVisible(true);
  }
}