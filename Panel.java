import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class Panel extends JPanel{
    

    public Panel(Dimension d ){
        setBounds(0 ,0, d.width,d.height);
        setVisible(false);
        setBackground(Color.BLACK);
        setOpaque(true);
    }


}
