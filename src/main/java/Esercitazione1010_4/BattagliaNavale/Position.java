package Esercitazione1010_4.BattagliaNavale;

/**
 * Created by Mirko Colombo on 10/10/2017.
 */
public class Position {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public Position(){
        this.x=-1;
        this.y=-1;
    }
}
