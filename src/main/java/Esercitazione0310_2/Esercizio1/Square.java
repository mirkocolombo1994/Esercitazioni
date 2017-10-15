package Esercitazione0310_2.Esercizio1;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class Square extends Polygon {

    double l1;

    public  Square(double l1){
        super();
        this.l1=l1;
    }

    @Override
    public double perimeter() {
        return l1*4;
    }
}
