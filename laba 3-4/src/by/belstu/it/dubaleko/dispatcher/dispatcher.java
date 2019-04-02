package by.belstu.it.dubaleko.dispatcher;
import  by.belstu.it.dubaleko.aircompany.aircompany;
import  by.belstu.it.dubaleko.aircraft.aircraft;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;
import java.util.List;
import static java.util.Collections.*;

public class dispatcher
{
    public  void sort(aircompany item)
    {
        ArrayList<aircraft> arr = item.getArrayList();

        Collections.sort(arr, (a,b)->  {return  a.getRangeofflight() - b.getRangeofflight();});
        for (aircraft im : arr)
        {
            im.Infoaboutaircraft();
        }
    }

   public  void findaircraft(aircompany item, int a , int b)
   {
       ArrayList<aircraft> arr = item.getArrayList();
       for (aircraft im : arr)
       {
           if (im.getAmountoffuel() > a  && im.getAmountoffuel() < b)
           {
               im.Infoaboutaircraft();
           }
       }
   }
}
