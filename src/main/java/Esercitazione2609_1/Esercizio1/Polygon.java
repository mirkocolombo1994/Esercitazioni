package Esercitazione2609_1.Esercizio1;

/**
 * Created by Mirko Colombo on 26/09/2017.
 */
public class Polygon {

    private Point2D[] vertices;

    public Polygon(int numVert){
        this.vertices = new Point2D[numVert];
    }

    public  float perimeter(){
        float p=0;
        for (int i=0; i<vertices.length; i++){
            p+= vertices[i].distance(vertices[i+1]);
        }
        p+=vertices[vertices.length-1].distance(vertices[0]); //IMPORTANTE IL -1!!!
        return p;
    }

}
