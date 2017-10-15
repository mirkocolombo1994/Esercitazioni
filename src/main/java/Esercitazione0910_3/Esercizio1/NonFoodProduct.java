package Esercitazione0910_3.Esercizio1;

/**
 * Created by Mirko Colombo on 09/10/2017.
 */
public class NonFoodProduct implements Product{

    private int id;
    private double price;
    private String description;
    private String material;

    public NonFoodProduct(int id, double price, String description, String material){
        this.id=id;
        this.price=price;
        this.description=description;
        this.material=material;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountedPrice() {
        return this.getPrice()*(0.9);
    }

    public String getDescription() {
        return description;
    }

    public boolean canBeSold() {
        return false;
    }

    public String getMaterial(){
        return material;
    }

    public boolean equals(Object other){
        if( this==other){return true;}
        if(other == null){return false;}
        if (this.getClass() != other.getClass()){return false;}

        NonFoodProduct p = (NonFoodProduct) other;
        return (this.getId() == p.getId() &&
                this.getPrice() == p.getPrice() &&
                this.getDescription() == p.getDescription());

    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder(); //Same use as String when yuo use it to concatenate
        // Strigs, but it's more efficiently
        stringBuilder.append(id).append(", ").append(description).append(", ").append(price).append(", ").append
                (material).append(", ").append(this.getDiscountedPrice());
        return stringBuilder.toString();
    }
}
