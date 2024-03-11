package org.example.models;

public class Order {

    int id;
    String name;
    int ph_no;

    int items;

    int price;


    public Order(int id, String name, int ph_no, int items, int price) { //constructor
        this.id = id;
        this.name = name;
        this.ph_no = ph_no;
        this.items = items;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {//getter for name
        return name;
    }

    public void setName(String name) {//setter for name
        this.name = name;
    }

    public int getPh_no() {//getter for phone number
        return ph_no;
    }

    public void setPh_no(int ph_no) {//setter for phone number
        this.ph_no = ph_no;
    }

    public int getItems() {//getter for items
        return items;
    }

    public void setItems(int items) {//setter for items
        this.items = items;
    }

    public int getPrice() {//getter for price
        return price;
    }

    public void setPrice(int price) {//setter for price
        this.price = price;
    }
    public void vat() {

        String name = this.name;
        int ph_no = this.ph_no;
        int price = this.price;
        int items= this.items;
        double vat = price*0.13;    //VAT is calculated
        double grand_total = price + vat;   //Grand total is calculated

        System.out.println("\nOrder details: \n");
        System.out.println("Name: "+name);  //Name of the person ordering is displayed
        System.out.println("Phone number: "+ph_no);//Phone number of the person ordering is displayed
        System.out.println("Price: " + price);//Price of the ordered items is displayed
        System.out.println("Items:"+items); //number of items are displayed
        System.out.println("Grand Total with VAT:"+grand_total+"\n");//Total with VAT is displayed
    }
}
