package Esercitazione0310_2.Esercizio1;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class Triangle extends Polygon{

    private double l1,l2,l3;

    public Triangle(double l1, double l2, double l3){
        super(); //quando si estendono le classi è buona norma farlo;
        this.l1=l1;
        this.l2=l2;
        this.l3=l3;
    }

    @Override
    public double perimeter() {
        return l1+l2+l3;
    }


}
