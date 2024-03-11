package org.example.models;

import java.util.Arrays;
//"INSERT INTO " + TSHIRT_TABLE + "(" +
//                    COLUMN_TSHIRT_NAME + ", " +
//                    COLUMN_TSHIRT_PRICE + ", " +
//                    COLUMN_TSHIRT_BRAND + ", " +
//                    COLUMN_TSHIRT_DES +") values(?,?,?,?)";

public class Tshirt {
    int id;
    String name;

    int price;
    String brand;

    String des;

    public Tshirt(int id, String name, int price, String brand, String des) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDes() {
        return des;
    }

    public void setTDes(String des) {
        this.des = des;
    }

    public void product_info(){//function to display item information
        String name = this.name;
        int id = this.id;
        int price = this.price;
        String brand = this.brand;
        String des = this.des;

        System.out.println("Item name:"+this.name);
        System.out.println("Description:"+this.des);
        System.out.println("Price:"+this.price);
        System.out.println("Product Code:"+this.id);
        System.out.println("\n\n");
    }
}
