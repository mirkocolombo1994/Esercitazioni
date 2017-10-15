package Esercitazione0910_3.Esercizio1;

/**
 * Created by Mirko Colombo on 09/10/2017.
 */
public class WarehouseItem implements Cloneable{

    private Product product;
    private int quantity;

    public WarehouseItem(Product product, int quantity){
        this.product=product;
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable(int quantity){
        return this.getQuantity() >= quantity;
    }

    public  boolean isAvailable(){
        return this.isAvailable(1);
    }

    public WarehouseItem buyProduct(int quantity) throws ProductNotAvailableException{
        if(this.isAvailable(quantity) && product.canBeSold()){
            this.quantity= this.quantity-quantity;
            return new WarehouseItem(this.product, quantity);
        }
        throw new ProductNotAvailableException();
    }

    public Object clone(){
        return new WarehouseItem(this.product,this.quantity);
    }

    public String toString(){
        return product.toString() + "quantity: " + quantity;
    }
}
