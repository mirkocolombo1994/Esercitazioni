package Esercitazione1010_4.BattagliaNavale;

/**
 * Created by Mirko Colombo on 10/10/2017.
 */
public class Player {
    private String name;
    private Boat[] boats = new Boat[8]; //boats available
    private Grid grid;

    /**
     * Throw a bomb in a position to the opponent's grid
     * @param position
     * @param grid
     * @return
     */
    public MoveState putBomb(Position position, Grid grid) throws ArrayIndexOutOfBoundsException {
        return grid.checkBomb(position);
    }

    /**
     * Place a boat in the grid
     * @param boat
     * @param position
     * @param direction
     */
    public boolean putBoat(Boat boat) throws NullPointerException {
        try {
            grid.putBoat(boat);
            return false;
        /*}catch (NullPointerException e){
            /*System.out.println("You can not put a boat that long. Try with a shot one or try change direction.");
            return true;*/
        }catch (PositionOccupiedException e)
        {
            System.out.println(super.toString());
            return true;
        }catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(super.toString() + " PIPPO");
            return true;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoats(Boat[] boats) {
        this.boats = boats;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * Constructor of the class
     * @param name the name of the player
     * @param grid the grid of the player
     * @param boats the boats that the player can use
     */
    public Player(String name,Grid grid,Boat[] boats){
        this.name=name;
        this.grid=grid;
        this.boats=boats;
    }

    public Player(Grid grid,Boat[] boats){
        this.grid=grid;
        this.boats=boats;
    }

    /**
     * Return the amount of boats that user have
     * @return
     */
    public String toString(){
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append("You have \n"
                + countBoatPerLenth(4) +" boats of lenth 4\n"
                + countBoatPerLenth(3) +" boats of lenth 3\n"
                + countBoatPerLenth(2) +" boats of lenth 2\n"
                + countBoatPerLenth(1) +" boats of lenth 1\n");

        return stringBuilder.toString();
    }

    /**
     * Counts the amount of boats with boatLen the user have
     * @param boatLen
     * @return
     */
    private int countBoatPerLenth(int boatLen){
        int num=0;
        for (Boat b:boats) {
            if(b.getLength()==boatLen){
                num++;
            }
        }
        return num;
    }

    public Boat[] getBoats() {
        return boats;
    }

    public String getName() {
        return name;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public Player(Grid grid){
        this.grid=grid;
    }
}
