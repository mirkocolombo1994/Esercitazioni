package Esercitazione0310_2.Esercizio1;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class Circle extends Polygon {

    double ray;

    public Circle(double ray){
        super();
        this.ray=ray;
    }

    @Override
    public double perimeter() {
        return ray * 3.14;
    }
}
