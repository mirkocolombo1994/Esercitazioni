package Esercitazione0310_2.Esercizio1;

import java.util.ArrayList;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class Main {

    public static void main(String[] args){

        ArrayList<Polygon> polygons = new ArrayList<Polygon>();

        polygons.add(new Triangle(5,4,3));
        polygons.add(new Rectangle(4,10));
        polygons.add(new Square(2));

        for (Polygon p:polygons) {
            System.out.println(p.perimeter());
        }


    }

}
