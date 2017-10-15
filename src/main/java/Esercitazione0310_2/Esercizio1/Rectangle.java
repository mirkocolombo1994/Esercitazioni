package Esercitazione0310_2.Esercizio1;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class Rectangle extends Polygon {

    private  double l1,l2;

    public Rectangle (double l1, double l2){
        super();
        this.l1=l1;
        this.l2=l2;
    }

    @Override
    public double perimeter() {
        return 2*l1 + 2*l2;
    }

}
