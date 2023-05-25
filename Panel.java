import javax.swing.*;
import java.awt.*;

public class Panel {
    public JPanel jpanel = new JPanel();

    public Panel(GUI gui){
        gui.add(jpanel);
        jpanel.setBounds(0 ,0,gui.getSize().width, gui.getSize().height);
        jpanel.setVisible(false);
        jpanel.setBackground(Color.BLACK);
        jpanel.setOpaque(true);


        new Listener(this);

    }


}
