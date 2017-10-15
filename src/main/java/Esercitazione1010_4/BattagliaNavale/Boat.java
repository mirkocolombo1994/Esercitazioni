package Esercitazione1010_4.BattagliaNavale;

/**
 * Created by Mirko Colombo on 10/10/2017.
 */
public class Boat {
    private int length;
    private Position position;// the first top-left position
    private Direction direction;


    public Boat(int length) {
        this.length = length;

    }

    public Boat (int length, Position position, Direction direction){
        this.length = length;
        this.position=position;
        this.direction=direction;

    }

    public int getLength() {
        return length;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

}
