import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void tojson(ArrayList<aircraft> item) throws IOException {
        Gson gson = new Gson();
        String JSON  = gson.toJson(item);
        FileWriter mywriter  = new FileWriter("files/air.json", false);
        mywriter.write(JSON);
        mywriter.flush();
    }
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException, ClassNotFoundException {
        ArrayList<aircraft> airarray = new ArrayList<aircraft>();
        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document = builder.parse(new File("files/air.xml"));
        // Получение списка всех элементов aircraft внутри корневого элемента (getDocumentElement возвращает ROOT элемент XML файла).
        NodeList aircraftElements = document.getDocumentElement().getElementsByTagName("aircraft");
        // Перебор всех элементов aircraft
        for (int i = 0; i < aircraftElements.getLength(); i++) {
            // Получение атрибутов каждого элемента
            Node node = aircraftElements.item(i);
            aircraft el  = new aircraft();
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element)node;
                el.setColorofaircraft(element.getElementsByTagName("color").item(0).getChildNodes().item(0).getNodeValue());
                el.setNameofaircraft(element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue());
                el.setRangeofflight(Integer.parseInt(element.getElementsByTagName("range").item(0).getChildNodes().item(0).getNodeValue()));
                el.setAmountoffuel(Integer.parseInt(element.getElementsByTagName("amount").item(0).getChildNodes().item(0).getNodeValue()));
                el.setCapacity(Integer.parseInt(element.getElementsByTagName("capacity").item(0).getChildNodes().item(0).getNodeValue()));
                el.setCarrying(Integer.parseInt(element.getElementsByTagName("carrying").item(0).getChildNodes().item(0).getNodeValue()));
            }
            airarray.add(el);
        }
        for (aircraft item : airarray)
        {
            item.Infoaboutaircraft();;
        }
        //трансформация в html
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc=new StreamSource("files/air.xsl");
        Source xmlDoc=new StreamSource("files/air.xml");
        String outputFileName="files/air.html";
        OutputStream htmlFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(htmlFile));
        //инициализация нового списка
        ArrayList<aircraft> listofaircraft = new ArrayList<aircraft>();
        aircraft a1 = new aircraft("green", "X-153", 740, 55, 200, 15);
        aircraft a2 = new aircraft("blue", "CY-30", 2100, 2754, 320, 2);
        listofaircraft.add(a1);
        listofaircraft.add(a2);
        System.out.println("\nserialiation:");
        //Сериализация в файл с помощью класса ObjectOutputStream
        FileOutputStream objectOutputStream  = new FileOutputStream("files/serial.xml");
        java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(objectOutputStream);
        xe1.writeObject(listofaircraft);
        xe1.close();
        // Востановление из файла с помощью класса ObjectInputStream
        FileInputStream objectInputStream = new FileInputStream("files/serial.xml");
        java.beans.XMLDecoder x2 = new java.beans.XMLDecoder(objectInputStream);
        ArrayList<aircraft> mylist = (ArrayList<aircraft>)x2.readObject();
        x2.close();
        for (var item : mylist)
        {
            item.Infoaboutaircraft();
        }
        //запись в json
        Main.tojson(airarray);
    }
}
