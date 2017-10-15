package Esercitazione2609_1.Esercizio1;

/**
 * Created by Mirko Colombo on 26/09/2017.
 */
public class Point2D {

    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Point2D(float x, float y){
        this.x=x;
        this.y=y;
    }

    public Point2D(){
        this.x=0;
        this.y=0;
        //oppure anche
        // this(0,0);
    }

    public double distance (Point2D point)
    {
        return(float) Math.sqrt(Math.pow((this.x-point.x),2)+(Math.pow(this.y-point.y,2)));
    }
}

