import model.*;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame
{   public MainWindow(Tower tower)
    {   setup();
        build(tower);
        pack();
        setVisible(true);    }
    
    private void setup()
    {   setLocation(500, 500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);    }
    
    private void build(Tower tower)
    {   add(new Panel(tower));    }
    
private class Panel extends JPanel
{   public Panel(Tower tower)
    {   build(tower);    }
    
    private void build(Tower tower)
    {   add(new UsePanel(tower));
        add(new ListPanel(tower));    }
}
}