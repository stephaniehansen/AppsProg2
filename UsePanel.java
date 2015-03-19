import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsePanel extends JPanel implements View
{   private JLabel studentLabel;
    private ListPanel listpanel;
    private JTextField name = new JTextField();
    private Tower tower;
    
    public UsePanel(Tower tower)
    {   this.tower = tower;
        build();    }
    
    private void build()
    {   Box box = Box.createVerticalBox();
        studentLabel = new JLabel("Student");
        box.add(studentLabel);
        box.add(Box.createVerticalStrut(5));
        box.add(inputBox());
        box.add(Box.createVerticalStrut(5));
        box.add(buttonBox());
        add(box);    }
    
    private Box inputBox()
    {   Box box = Box.createVerticalBox();
        box.add(name);
        return box;    }
    
    private Box buttonBox()
    {   Box box = Box.createHorizontalBox();
        box.add(button("Add", new AddListener()));
        box.add(Box.createHorizontalStrut(5));
        box.add(button("Move", new MoveListener()));
        return box;   }
    
    private JButton button(String label, ActionListener listener)
    {   JButton button = new JButton(label);
        button.addActionListener(listener);
        return button;    }
    
    private String name()
    {   return name.getText();    }
    
    private void clear(){
        name.setText("");
    }
    
    public void update(){
    }
    
    private void attach()
    {   tower.attach(this); }
        
    private void detach()
    {   tower.detach(this); }
    
private class AddListener implements ActionListener
{   public void actionPerformed(ActionEvent e)
    {   tower.add(name());
        clear();
        detach();    }
}

private class MoveListener implements ActionListener
{   public void actionPerformed(ActionEvent e)
    {   tower.move(name());
        clear();
        detach();    }
}
}