package com.springshop.backShop.dto;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cart implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne
    private User user;

    @Column(name="grand_total")
    private double grandTotal;
    @Column(name="cart_lines")
    private int cartLines;




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public int getCartLines() {
        return cartLines;
    }

    public void setCartLines(int cartLines) {
        this.cartLines = cartLines;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", grandTotal=" + grandTotal +
                ", cartLines=" + cartLines +
                '}';
    }

}
