import org.testng.AssertJUnit;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

public class AirportTest {

   aircraft air1 = new aircraft("black", "ATR - 72", 1300, 1570, 500, 10);
   aircraft air2 = new aircraft("white", "Cy-7", 1130, 1350, 300, 2);
   airport airs = new airport();
   aircraft newair = new aircraft();
   airport airport = new airport();

    @BeforeTest(groups = "unit1")
    public void addinfo()
    {
        airs.add(air1);
        airs.add(air2);
    }
    @AfterTest(groups = "unit1")
    public void removeinfo()
    {
        airs.remove(air1);
        airs.remove(air2);
    }
    @BeforeClass
    public  void infobfclass()
    {
        System.out.println("Test class start working");
    }
    @AfterClass
    public  void infoafclass()
    {
        System.out.println("In  few second testing class finished work");
    }
    @BeforeMethod
    public void infobfmetod()
    {
        System.out.println("Metod start working");
    }
    @AfterMethod
    public void infoafmetod() { System.out.println("Metod finished work"); }
    @BeforeSuite
    public  void infobfsuit() { System.out.println("This will execute before the Test Suite"); }
    @AfterSuite
    public  void  infoafsuit() { System.out.println("This will execute after Test Suite"); }
    @Test(groups = "unit1")
    public void testgroups() {
        AssertJUnit.assertTrue("Test interplay of class failed", airport.checklengthmessage() > 0 );
        System.out.println("TEST INTERPLAY OF CLASS");
    }
    @Test(groups = "unit1")
    public  void  testcapacity()
    {
        airport.setMessage(newair.getMessage());
        AssertJUnit.assertTrue("Test capacity failed",airs.allcapacity() > 0 );
        System.out.println("TEST CAPACITY");
    }
    @Test(timeOut = 20 , groups = "unit1")
    public void testcarrying()
    {
        AssertJUnit.assertTrue("Test carrying failed",airs.allcarrying() > 0);
        System.out.println("TEST CARRYING");
    }
    @Test(enabled = false , groups = "unit1")
    public void showlisttest()
    {
        AssertJUnit.assertTrue("Test showlist failed",airs.toString() != "");
        System.out.println("TEST SHOWLIST");
    }
}
