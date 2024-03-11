package org.example;
import org.example.models.Tshirt;
import org.example.models.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static final String ORDER_TABLE = "orders";
    public static final String COLUMN_NO = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PH_NO = "ph_no";
    public static final String COLUMN_ITEMS = "items";
    public static final String COLUMN_PRICE = "price";

    public static void main(String[] args) {


        Order o1 = new Order(1, "Ram Basnet", 90815678, 1, 1200);
        Tshirt t1 = new Tshirt(1,"COOLTEE", 1000,"Lucci", "I drink cool tea and wear COOLTEE");
        Tshirt t2 = new Tshirt(2,"TCOOL", 1299,"White Jeans", "Cooler than the other side of the pillow");


        String url = "jdbc:sqlite:order.db";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + ORDER_TABLE + "(id integer PRIMARY KEY NOT NULL," +
                "name text," +
                "ph_no integer," +
                "items integer," +
                "price integer)";

        System.out.println(createTableSQL);

        String insertRecordSQL = "INSERT INTO " + ORDER_TABLE + "(name, ph_no, items, price) values(?,?,?,?)";
        System.out.println(insertRecordSQL);

        String selectData = "SELECT * FROM " + ORDER_TABLE;

        System.out.println(selectData);
        try {

            Connection c = DriverManager.getConnection(url);
            System.out.println("Connected");

            Statement stm = c.createStatement();
            stm.execute(createTableSQL);


            PreparedStatement preparedStatement = c.prepareStatement(insertRecordSQL);
            preparedStatement.setString(1, o1.getName());
            preparedStatement.setInt(2, o1.getPh_no());
            preparedStatement.setInt(3, o1.getItems());
            preparedStatement.setInt(4, o1.getPrice());

            preparedStatement.execute();

            System.out.println("Insert Created");

            List<Order> orderList = new ArrayList<>();
            ResultSet rs = stm.executeQuery(selectData);
            while (rs.next()) {
                int id = rs.getInt(COLUMN_NO);
                String name = rs.getString(COLUMN_NAME);
                int ph_no = rs.getInt(COLUMN_PH_NO);
                int items = rs.getInt(COLUMN_ITEMS);
                int price = rs.getInt(COLUMN_PRICE);
                Order o2 =new Order(id,name,ph_no,items,price);
                orderList.add(o2);

            }

            c.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        o1.vat();
        t1.product_info();
        t2.product_info();
    }
}