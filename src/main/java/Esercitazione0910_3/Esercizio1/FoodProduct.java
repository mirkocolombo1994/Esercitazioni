package Esercitazione0910_3.Esercizio1;

import java.time.LocalDate;

/**
 * Created by Mirko Colombo on 09/10/2017.
 */
public class FoodProduct implements Product {

    private int id;
    private  double price;
    private String description;
    private LocalDate expirationDate;

    public FoodProduct(int id, int price, String description, LocalDate expirationDate){
        this.id=id;
        this.price=price;
        this.description=description;
        this.expirationDate=expirationDate;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public  LocalDate getExpirationDate(){
        return expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public boolean canBeSold() {
       if (this.isExpired()){
           return false;
       }
       return true;
    }

    public double getDiscountedPrice() {
        return this.getPrice();
    }

    public boolean isExpired(){
        return this.getExpirationDate().isBefore(LocalDate.now());
    }

    public boolean equals(Object other){
        if( this==other){return true;}
        if(other == null){return false;}
        if (this.getClass() != other.getClass()){return false;}

        FoodProduct p = (FoodProduct) other;
        return (this.getId() == p.getId() &&
                this.getPrice() == p.getPrice() &&
                this.getDescription() == p.getDescription() &&
                this.getExpirationDate() == p.getExpirationDate());

    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder(); //Same use as String when yuo use it to concatenate
        // Strigs, but it's more efficiently
        stringBuilder.append(id).append(", ").append(description).append(", ").append(price).append(", ").append(this
                .getDiscountedPrice());
        return stringBuilder.toString();
    }

}
