package org.example;
import org.example.models.Tshirt;
import org.example.models.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class test {
    public static final String TSHIRT_TABLE = "tshirt";
    public static final String TSHIRT_ID = "id";
    public static final String TSHIRT_NAME = "name";
    public static final String TSHIRT_PRICE = "price";
    public static final String TSHIRT_BRAND = "brand";
    public static final String TSHIRT_DES = "des";
    public static void main(String[] args) {


        Tshirt t1 = new Tshirt(1,"COOLTEE", 1000,"Lucci", "I drink cool tea and wear COOLTEE");
        Tshirt t2 = new Tshirt(2,"TCOOL", 1299,"White Jeans", "Cooler than the other side of the pillow");

        String url = "jdbc:sqlite:tshirt.db";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + TSHIRT_TABLE + "(id integer PRIMARY KEY NOT NULL," +
                "name text," +
                "code integer," +
                "price integer," +
                "brand text," +
                "des text)";

        System.out.println(createTableSQL);

        String insertRecordSQL = "INSERT INTO " + TSHIRT_TABLE + "(name, price, brand, des) values(?,?,?,?)";
        System.out.println(insertRecordSQL);

        String selectData = "SELECT * FROM " + TSHIRT_TABLE;

        System.out.println(selectData);
        try {

            Connection c = DriverManager.getConnection(url);
            System.out.println("Connected");

            Statement stm = c.createStatement();
            stm.execute(createTableSQL);


            PreparedStatement preparedStatement = c.prepareStatement(insertRecordSQL);
            preparedStatement.setString(1, t1.getName());
            preparedStatement.setInt(2, t1.getPrice());
            preparedStatement.setString(3, t1.getBrand());
            preparedStatement.setString(4, t1.getDes());

            preparedStatement.setString(1, t2.getName());
            preparedStatement.setInt(2, t2.getPrice());
            preparedStatement.setString(3, t2.getBrand());
            preparedStatement.setString(4, t2.getDes());



            preparedStatement.execute();
            System.out.println("Insert Created");
            List<Tshirt> tshirtList = new ArrayList<>();
            ResultSet rs = stm.executeQuery(selectData);
            while (rs.next()) {
                int id = rs.getInt(TSHIRT_ID);
                String name = rs.getString(TSHIRT_NAME);
                int price = rs.getInt(TSHIRT_PRICE);
                String brand  = rs.getString(TSHIRT_BRAND);
                String des  = rs.getString(TSHIRT_DES);

                tshirtList.add(t1);
                tshirtList.add(t2);

            }

            c.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }


    }
}