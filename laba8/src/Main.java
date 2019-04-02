import java.sql.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    private static  String url = "jdbc:mysql://localhost:3306/mydatabase";
    private  static  String name ="root";
    private static  String password = "1234";

    static{ new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository()); }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,name,password);
        LOG.info("Отключаем авто сохранение действий");
        connection.setAutoCommit(false);
        if(!connection.isClosed()) LOG.info("Соединение с БД установлено");
        Statement statement =  connection.createStatement();

        LOG.info("Запрос ищущий производителя с  именем  Magnitiprom");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM test.souvenir where Producer like 'Magnitoprom'");
        while(resultSet.next()){

            String name = resultSet.getString(1);
            String producer = resultSet.getString(2);
            Date  data = resultSet.getDate(3);
            int price = resultSet.getInt(4);
            LOG.info("Название сувенира: "+name+" Производитель: "+producer+" Дата производства: "+data+" Цена: "+price+" рублей");
        }
        LOG.info("Запрос ищущий производителя из Беларуси");
        ResultSet resultSet1 = statement.executeQuery("SELECT SouvenirName , Producer , Country, DateofProduce , Coast  FROM test.souvenir , test.producer where souvenir.Producer =  producer.Title and producer.Country like 'Belarus'");
        while(resultSet1.next()){

            String name = resultSet1.getString(1);
            String producer = resultSet1.getString(2);
            Date  data = resultSet1.getDate(4);
            int price = resultSet1.getInt(5);
            String country = resultSet1.getString(3);
            LOG.info("Название сувенира: "+name+" Производитель: "+producer+" Страна: "+country+" Дата производства: "+data+" Цена: "+price+" рублей");
        }
        LOG.info("Запрос ищущий сувениры произведенный в 2019 году");
        ResultSet resultSet2 = statement.executeQuery("SELECT SouvenirName , Producer , Country, DateofProduce , Coast  FROM test.souvenir , test.producer where souvenir.Producer =  producer.Title and  YEAR(souvenir.DateofProduce) = 2019");
        while(resultSet2.next()){

            String name = resultSet2.getString(1);
            String producer = resultSet2.getString(2);
            Date  data = resultSet2.getDate(4);
            int price = resultSet2.getInt(5);
            String country = resultSet2.getString(3);
            LOG.info("Название сувенира: "+name+" Производитель: "+producer+" Страна: "+country+" Дата производства: "+data+" Цена: "+price+" рублей");
        }
        LOG.info("Запрос ищущий сувениры с максимальной стоимостью 3 рубля");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT SouvenirName , Producer , Country, DateofProduce , Coast  FROM test.souvenir , test.producer where souvenir.Producer =  producer.Title and souvenir.Coast <= ?");
        preparedStatement.setInt(1, 3);
        ResultSet resultSet3 = preparedStatement.executeQuery();
        while(resultSet3.next()){

            String name = resultSet3.getString(1);
            String producer = resultSet3.getString(2);
            Date  data = resultSet3.getDate(4);
            int price = resultSet3.getInt(5);
            String country = resultSet3.getString(3);
            LOG.info("Название сувенира: "+name+" Производитель: "+producer+" Страна: "+country+" Дата производства: "+data+" Цена: "+price+" рублей");
        }

        LOG.info("Создаем точку отката");
        Savepoint savepointOne = connection.setSavepoint("SavepointOne");
        try {
           String SQL = "INSERT INTO Souvenir(SouvenirName, Producer, DateofProduce, Coast) Values('Big Magnet', 'Magnitoprom', '2019-12-8', 4))";
            statement.executeUpdate(SQL);

            SQL = "INSE INTHE Souvenir VALUES (7, 'Ron', 'Ruby', 1900)";
            statement.executeUpdate(SQL);

            connection.commit();
        } catch (SQLException e) {
            LOG.info("Произошла ошибка в sql запрос откатываемся изменения");
            connection.rollback(savepointOne);
        }

        connection.close();
        if(connection.isClosed()) LOG.info("Закрываем соединение с БД");
    }
}
