import java.util.ArrayList;

public class airport {
    private ArrayList<aircraft> arrayList = new ArrayList<aircraft>();
    private String message;

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

    public void setMessage(String message) { this.message = message; }

    public  ArrayList<aircraft>  showlist ()
    {
        for (aircraft i : arrayList)
        {
            i.Infoaboutaircraft();
        }
        return arrayList;
    }
    public int allcarrying()
    {
        int x = 0;
        for (aircraft i : arrayList)
        {
            x += i.getCarrying();
        }
        return  x;
    }
    public int allcapacity () {
        int x = 0;
        for (aircraft i : arrayList) {
            x += i.getCapacity();
        }
        return x;
    }
    public int checklengthmessage()
    {
        int x = message.length();
        return x;
    }
}
