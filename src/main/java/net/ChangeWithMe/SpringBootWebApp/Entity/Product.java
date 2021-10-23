package net.ChangeWithMe.SpringBootWebApp.Entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_serial_number")
    private long productSerialNumber;
    private String title;
    private String category;
    private float price;


    public long getProductSerialNumber() {
        return productSerialNumber;
    }

    public void setProductSerialNumber(long productSerialNumber) {
        this.productSerialNumber = productSerialNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
