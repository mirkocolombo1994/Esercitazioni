package Esercitazione0910_3.Esercizio1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mirko Colombo on 09/10/2017.
 */
public class Customer {

    List<WarehouseItem> cart;

    public Customer() {
        cart = new ArrayList<WarehouseItem>();
    }

    public List<WarehouseItem> listProduct(){
        ArrayList<WarehouseItem> ret = new ArrayList<WarehouseItem>();
        for (WarehouseItem item: cart) {
            ret.add((WarehouseItem)item.clone());
        }
        return ret;
    }

    public void printCard(){
        for (WarehouseItem p: this.listProduct()) {
            System.out.println(p);
        }
    }

    public void addProduct(WarehouseItem item){
        this.cart.add(item);
    }

    public double computeTotal(){
        double total =0;
        for (WarehouseItem item: cart) {
        total+= item.getProduct().getDiscountedPrice() * item.getQuantity();

        }
        return total;
    }



}
