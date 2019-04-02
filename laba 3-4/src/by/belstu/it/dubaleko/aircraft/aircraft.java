package by.belstu.it.dubaleko.aircraft;
import org.apache.log4j.Logger;
import  org.apache.log4j.PropertyConfigurator;
import   org.apache.log4j.PropertyConfigurator;


abstract public class aircraft implements  Interface {
    private  String colorofaircraft;
    private  String nameofaircraft;
    private int rangeofflight;
    private  int amountoffuel;
    private int  carrying;
    private int capacity;
    Nestedclass nestedclass;
    Type aircrafttype;

    public String getColorofaircraft() {
        return colorofaircraft;
    }

    public void setColorofaircraft(String colorofaircraft) {
        this.colorofaircraft = colorofaircraft;
    }

    public void setAmountoffuel(int amountoffuel)  { this.amountoffuel = amountoffuel; }

    public int getAmountoffuel() {
        return amountoffuel;
    }

    public void setRangeofflight(int rangeofflight) {
        this.rangeofflight = rangeofflight;
    }

    public int getRangeofflight() {
        return rangeofflight;
    }

    public void setNameofaircraft(String nameofaircraft){
        this.nameofaircraft = nameofaircraft;
    }

    public String getNameofaircraft() {
        return nameofaircraft;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying)
    {
        this.carrying = carrying;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity)  {
        this.capacity = capacity;
    }

    public aircraft(String colorofaircraft, Type type , String nameofaircraft, int rangeofflight, int amountoffuel, int carrying, int capacity) throws Exception
    {
        if(amountoffuel < 0) throw new Exception("Incorrectly enteered value of range of flight");
        if(rangeofflight< 0)throw new Exception("Incorrectly entered value of range of flight");
        if(carrying < 0) throw new Exception("Incorrectly entered value of carrying");
        if(capacity < 0) throw new Exception("Incorrectly entered value of capcity");

        this.colorofaircraft = colorofaircraft;
        this.nameofaircraft = nameofaircraft;
        this.rangeofflight = rangeofflight;
        this.amountoffuel = amountoffuel;
        aircrafttype = type;
        this.carrying = carrying;
        this.capacity = capacity;
        Nestedclass nestedclass = new Nestedclass();
    }

    public String toString()
    {
        return nameofaircraft+colorofaircraft+rangeofflight+amountoffuel;
    }
    @Override
    public void Infoaboutaircraft() {
        System.out.println("Name of aircraft: "+nameofaircraft+" Type of aircraft: "+aircrafttype +" Color of aircraft: "
                           + colorofaircraft+"Range of flight: "+ rangeofflight+ "кm Amount of fuel "+amountoffuel+" kg"
                           + " Carrying: "+carrying+"kg "+ "Capacity: "+capacity+" places");
    }
    public  class Nestedclass
    {
        public  void  Nameofaircraft()
        {
            System.out.println("Name of aircraft:"+ aircraft.this. nameofaircraft);
        }
    }
}
