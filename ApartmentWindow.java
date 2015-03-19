import model.*;

import java.awt.*;
import javax.swing.*;

public class ApartmentWindow extends JFrame
{   public ApartmentWindow(Tower tower, Apt apt)
    {   setup(apt);
        build(tower, apt);
        pack();
        setVisible(true);   }
        
    private void setup(Apt apt)
    {   setLocation(900, 500); 
        setMinimumSize(new Dimension(250, 100));
        this.setTitle("Apartment " + apt);   }
        
    private void build(Tower tower, Apt apt)
    {   add(new TablePanel(tower, apt));   }
}