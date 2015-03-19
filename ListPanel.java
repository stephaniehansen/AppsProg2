import model.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListPanel extends JPanel implements View
{   private DefaultListModel model = new DefaultListModel();
    private JList list = new JList(model);
    private JScrollPane scroll = new JScrollPane(list);  
    private Tower tower;
    private Apt apt;
     
    public ListPanel(Tower tower)
    {   this.tower = tower;
        attach();
        setup();
        build();
    }
    
    private void setup()
    {   setSize(new Dimension(200, 200)); 
        scroll.setPreferredSize(new Dimension(200, 200));
        scroll.setBorder(BorderFactory.createLineBorder(Color.blue));
        list.setFixedCellWidth(180);    }

    private void build()
    {   list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new Listener());
        update();    }
    
    public void update()
    {   model.clear();
        add(scroll);
        for (Apt apt: tower.usedApts()){
            model.addElement(apt.toString());   }}
    
    private void attach()
    {   tower.attach(this); }
        
    private void detach()
    {   tower.detach(this); }

private class Listener implements ListSelectionListener
{   public void valueChanged(ListSelectionEvent e)
    {   if(e.getValueIsAdjusting())
            return;
        int selected = list.getSelectedIndex();
        if (selected == -1)
            return;
        apt = tower.usedApt(selected);
        attach();
        new ApartmentWindow(tower, apt);    }    
}
}