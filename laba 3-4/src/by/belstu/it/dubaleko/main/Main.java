package by.belstu.it.dubaleko.main;

import by.belstu.it.dubaleko.aircraft.*;
import  by.belstu.it.dubaleko.aircompany.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    static{ new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository()); }
    private static final Logger LOG = Logger.getLogger(Main.class);
    public static void main(String[] args)
    {
        try {
            monoplan lowplane = new monoplan("black", Type.Monoplan, "ATR - 72", 1300,
                    1570, 500, 10);
            monoplan midplane = new monoplan("white", Type.Monoplan, "Cy-7", 1130,
                    1350, 300, 2);
            monoplan highplan = new monoplan("green", Type.Monoplan, "Aн-12", 7200,
                    5000, 2000, 200);
            biplane biplane = new biplane("green", Type.Biplane, "И-153", 740,
                    55, 200, 15);
            threeplan threeplan = new threeplan("blue", Type.Threeplan, "CY-30", 2100,
                    2754, 320, 2);
            aircompany arrayList = new aircompany();
            arrayList.add(lowplane);
            arrayList.add(midplane);
            arrayList.add(highplan);
            arrayList.add(biplane);
            arrayList.add(threeplan);
            System.out.println("Aircraft of my aircompany:");
            arrayList.showlist();
            System.out.println("\n All carrying of my compay:");
            arrayList.allcarrying();
            System.out.println("\n All capacity of my compay:");
            arrayList.allcapacity();
            System.out.println("\n\nSorted Collection of aircraft of my company:");
            arrayList.sort(arrayList);
            System.out.println("\nAircraft of  range:");
            arrayList.findaircraft(arrayList, 1000, 1500);
        }
        catch (Exception ex)
        {
            LOG.error(ex.getMessage());
            System.out.print("Выполняемы код выдал исключение для большей информации откройте файл air.log");
        }
    }
}
