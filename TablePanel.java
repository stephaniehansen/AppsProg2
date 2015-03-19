import model.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TablePanel extends JPanel implements View
{   private JTable table;
    private TableModel model;
    private Tower tower;
    private Apt apt;

    public TablePanel(Tower tower, Apt apt)
    {   this.tower = tower;
        this.apt = apt;
        tower.attach(this);
        setup();
        update();    }
    
    private void setup()
    {   model = new TableModel();
        table = new JTable(model);
        Box box = Box.createVerticalBox();
        box.add(table.getTableHeader());
        box.add(table);
        add(box);    }
        
    public void update()
    {   model.fireTableDataChanged();    }
    
private class TableModel extends AbstractTableModel{
    private final int ROWS = apt.size();
    private final int COLS = 2;
    private final String[] headers = {"Bed", "Student"};
    
    public String getColumnName(int col)
    {   return headers[col];    }
    
    public int getRowCount()
    {   return ROWS;    }    
    
    public int getColumnCount()
    {   return COLS;    }
    
    public Object getValueAt(int row, int col)
    {   Room room = apt.room(row);
        Student student = room.student();
        if(col == 0){
            return room.toString();
        }
        if(col == 1 && student!=null){
            return student.name();
        }
        return "";   
    }
}
}