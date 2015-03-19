package model;

import java.io.*;
import java.util.*;

public class Tower extends Viewable
{   private LinkedList<Apt> apts = new LinkedList<Apt>();
    private LinkedList<Apt> usedApts = new LinkedList<Apt>();

    public Tower()
    {   for (int floor = 1; floor <= 10; floor++)
        {   apts.add(new Apt(floor, 1, 1));
            apts.add(new Apt(floor, 2, 3));
            apts.add(new Apt(floor, 3, 2));   }}

    public void add(String name)
    {   add(new Student(name));   }
    
    public void add(Student student)
    {   for (Apt apt: apts)
            if (apt.canFit(student))
            {   apt.add(student);
                used(apt);
                update();
                break;  }}

    public void move(String name)
    {   Room room = room(name);
        add(room.student());
        room.clear();  
        isAptEmpty();
        update();    }
            
    private Room room(String name)
    {   for (Apt apt: apts)
        {   Room room = apt.room(name);
            if (room != null)
                return room;    }
        return null;    }
        
    public Apt apt(int id)
    {   for (Apt apt: apts)
            if (apt.matches(id))
                return apt;
        return null;    }
        
    public Apt apts(int i)
    {   return apts.get(i);   }
    
    public LinkedList<Apt> apts()
    {   return apts;   }
    
    public LinkedList<Apt> usedApts()
    {   return usedApts;   }
    
    public Apt used(Apt apt)
    {   if(!usedApts.contains(apt))
        {   usedApts.add(apt);   }
        Collections.sort(usedApts);
        return apt;    }
    
    public Apt usedApt(int i)
    {   return usedApts.get(i);   }
        
    private void isAptEmpty()
    {   for(Apt apt : usedApts)
        {   if(apt.isEmpty())
            {   usedApts.remove(apt);
                break;   }}}
}