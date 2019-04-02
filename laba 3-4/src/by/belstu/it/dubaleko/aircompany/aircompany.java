package by.belstu.it.dubaleko.aircompany;
import by.belstu.it.dubaleko.aircraft.aircraft;
import by.belstu.it.dubaleko.dispatcher.dispatcher;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

 public class aircompany  extends  dispatcher{

    private ArrayList<aircraft> arrayList = new ArrayList<aircraft>();

     public ArrayList<aircraft> getArrayList() {
         return arrayList;
     }

     public void setArrayList(ArrayList<aircraft> arrayList) {
         this.arrayList = arrayList;
     }

     public void add (aircraft item)
    {
        arrayList.add(item);
    };

    public  void  remove (aircraft item)
    {
        arrayList.remove(item);
    }
    public void  showlist ()
    {
        for (aircraft i : arrayList)
        {
            i.Infoaboutaircraft();
        }
    }
    public int allcarrying()
    {
        int x = 0;
        for (aircraft i : arrayList)
        {
            x += i.getCarrying();
        }
        System.out.print(x+ " kg");
        return  x;
    }
    public int allcapacity () {
        int x = 0;
        for (aircraft i : arrayList) {
            x += i.getCapacity();
        }
        System.out.print(x+" places");
        return x;
    }
}
