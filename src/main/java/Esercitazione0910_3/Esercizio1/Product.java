package Esercitazione0910_3.Esercizio1;

/**
 * Created by Mirko Colombo on 09/10/2017.
 */
public interface Product {

    int getId();
    double getPrice();
    double getDiscountedPrice();
    String getDescription();
    boolean canBeSold();

}
