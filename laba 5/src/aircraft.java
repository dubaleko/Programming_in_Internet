import java.io.Serializable;

public class aircraft  implements Serializable {
    private  String colorofaircraft;
    private  String nameofaircraft;
    private int rangeofflight;
    private  int amountoffuel;
    private int  carrying;
    private int capacity;

    public String getColorofaircraft() {
        return colorofaircraft;
    }

    public void setColorofaircraft(String colorofaircraft) {
        this.colorofaircraft = colorofaircraft;
    }

    public String getNameofaircraft() {
        return nameofaircraft;
    }

    public void setNameofaircraft(String nameofaircraft) {
        this.nameofaircraft = nameofaircraft;
    }

    public int getRangeofflight() {
        return rangeofflight;
    }

    public void setRangeofflight(int rangeofflight) {
        this.rangeofflight = rangeofflight;
    }

    public int getAmountoffuel() {
        return amountoffuel;
    }

    public void setAmountoffuel(int amountoffuel) {
        this.amountoffuel = amountoffuel;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void Infoaboutaircraft() {
        System.out.println("Name of aircraft: "+nameofaircraft +" Color of aircraft: "
                + colorofaircraft+"Range of flight: "+ rangeofflight+ "кm Amount of fuel "+amountoffuel+" kg"
                + " Carrying: "+carrying+" kg"+ " Capacity: "+capacity+" places");
    }

    public aircraft(String colorofaircraft, String nameofaircraft, int rangeofflight, int amountoffuel, int carrying, int capacity)
    {
        this.colorofaircraft = colorofaircraft;
        this.nameofaircraft = nameofaircraft;
        this.rangeofflight = rangeofflight;
        this.amountoffuel = amountoffuel;
        this.carrying = carrying;
        this.capacity = capacity;
    }
     public aircraft()
     {

     }
}
