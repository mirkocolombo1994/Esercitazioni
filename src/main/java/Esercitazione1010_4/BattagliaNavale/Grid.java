package Esercitazione1010_4.BattagliaNavale;

/**
 * Created by Mirko Colombo on 10/10/2017.
 */
public class Grid {
    private Boat[][] grid = new Boat[7][7];
    private boolean[][] hit = new boolean[7][7];


    public Grid(){
        for(int i=0;i<7;i++){
            for (int j=0;j<7;j++){
                hit[i][j]=true;
            }
        }
    }
    /**
     * check if there is a boat when  trying to put a boat
     * @param position
     * @param boatLen
     * @param direction
     * @return
     */
    private boolean checkBoat(Position position, int boatLen, Direction direction) throws NullPointerException,
            PositionOccupiedException, ArrayIndexOutOfBoundsException {
        if(grid[position.getX()][position.getY()]!= null) {
            throw new PositionOccupiedException();
        }
        switch (direction){
            case Up:
                for(int i=1; i<boatLen;i++){
                        if(grid[position.getX()][position.getY()-i]!=null){
                            throw new PositionOccupiedException();
                        }
                }
                return true;
            case Right:
                for(int i=1; i<boatLen;i++){
                        if(grid[position.getX()+i][position.getY()]!=null){
                            throw new PositionOccupiedException();
                        }
                }
                return true;
            case Down:
                for(int i=1; i<boatLen;i++){
                        if(grid[position.getX()][position.getY()+i]!=null){
                            throw new PositionOccupiedException();
                        }
                }
                return true;
            case Left:
                for(int i=1; i<boatLen;i++){
                        if(grid[position.getX()-i][position.getY()]!=null){
                            throw new PositionOccupiedException();
                        }
                }
                return true;
        }
        throw new PositionOccupiedException();
    }

    /**
     * Check if the bomb hits a part of a boat
     * @param position the position to control
     * @return if the bomb hits the boat
     */
    public MoveState checkBomb(Position position) throws NullPointerException, ArrayIndexOutOfBoundsException {
        if (grid[position.getX()][position.getY()]==null || hit[position.getX()][position.getY()]){
            return MoveState.Miss;
        }else{
            setHit(position);
            Boat boat = grid[position.getX()][position.getY()];
            return getHit(boat);
        }
    }

    /**
     * Controls if the grid is empty, that's when the game finish
     * @return
     *///|| grid[i][j]!=null
    public boolean checkVoidGrid() {
        for (int i=0; i<7;i++){
            for (int j=0;j<7;j++){
                if(!hit[i][j] ) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * It puts a boat in the grid
     * @param boat the boat to put in the grid
     * @return if the boat is in the grid
     */
    public void putBoat(Boat boat) throws NullPointerException,
            PositionOccupiedException,ArrayIndexOutOfBoundsException {

        if(checkBoat(boat.getPosition(), boat.getLength(), boat.getDirection()))
        {

            switch (boat.getDirection()){
                case Up:
                    for(int i = 0; i<boat.getLength(); i++) {
                        grid[boat.getPosition().getX()][boat.getPosition().getY()-i]=boat;
                        hit[boat.getPosition().getX()][boat.getPosition().getY()-i]=false;
                    }
                    break;
                case Right:
                    for(int i = 0; i<boat.getLength(); i++) {
                        grid[boat.getPosition().getX()+i][boat.getPosition().getY()]=boat;
                        hit[boat.getPosition().getX()+i][boat.getPosition().getY()]=false;
                    }
                    break;
                case Down:
                    for(int i = 0; i<boat.getLength(); i++) {
                        grid[boat.getPosition().getX()][boat.getPosition().getY()+i]=boat;
                        hit[boat.getPosition().getX()][boat.getPosition().getY()+i]=false;
                    }
                    break;
                case Left:
                    for(int i = 0; i<boat.getLength(); i++) {
                        grid[boat.getPosition().getX()-i][boat.getPosition().getY()]=boat;
                        hit[boat.getPosition().getX()-i][boat.getPosition().getY()]=false;
                    }
                    break;
            }
        }
    }

    public void setHit(Position position) {
        this.hit[position.getX()][position.getY()]=!hit[position.getX()][position.getY()];
    }

    public MoveState getHit(Boat boat) {
        switch (boat.getDirection()){
            case Up:
                for (int i = 0; i<boat.getLength(); i++){
                    if(!hit[boat.getPosition().getX()][boat.getPosition().getY()-i]){
                        return MoveState.Hit;
                    }
                }
                break;
            case Right:
                for (int i = 0; i<boat.getLength(); i++){
                    if(!hit[boat.getPosition().getX()+i][boat.getPosition().getY()]){
                        return MoveState.Hit;
                    }
                }
                break;
            case Down:
                for (int i = 0; i<boat.getLength(); i++){
                    if(!hit[boat.getPosition().getX()][boat.getPosition().getY()+i]){
                        return MoveState.Hit;
                    }
                }
                break;
            case Left:
                for (int i = 0; i<boat.getLength(); i++){
                    if(!hit[boat.getPosition().getX()-i][boat.getPosition().getY()]){
                        return MoveState.Hit;
                    }
                }
                break;
        }
        return MoveState.Sunk;
    }
}
