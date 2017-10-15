package Esercitazione1010_4.BattagliaNavale;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Mirko Colombo on 10/10/2017.
 */
public class Game {


    /**
     * Declare the list of players named players
     * Declare a boolean named victory that it will turn false when a player wins
     * -------
     * Declare a method receivePlayers that ask the users to enter their name
     * -----
     * Declare a method loadPlayers that initiate all the players with boats, grid and name
     * ----
     * Declare a method playerTurn that let the user decide what move want to do
     *
     * Print what you want to do: 1. ... 2. ... 3. ...
     *
     */

    public static void main (String[] args){
        Player[] players = new Player[2];
        String[] names= new String[2];
        boolean victory=true;

        receivePlayers(names);

        loadPlayers(players,names);
        //loadPlayersAuto(players);

        while (victory){
            for (int i=0; i<players.length; i++) {
                Position position=null;
                MoveState moveState;
                boolean win;
                try {
                    position=playerTurn(players[i]);
                }catch (IOException e){
                    System.out.println("Something went wrong with you input.");
                }

                if (i==0) {
                    moveState=players[i].putBomb(position, players[i + 1].getGrid());
                }else {
                    moveState=players[i].putBomb(position, players[i - 1].getGrid());
                }

                if (moveState==MoveState.Hit){
                    System.out.println("Hit");
                }else if(moveState==MoveState.Miss){
                    System.out.println("Miss");
                }else{
                    System.out.println("Sunk");
                }

                if (i==0) {
                    win=players[i+1].getGrid().checkVoidGrid();
                }else {
                    win=players[i-1].getGrid().checkVoidGrid();
                }

                if (win==true){
                    victory=false;
                    System.out.println(players[i].getName() + " Wins the game!!!");
                }
            }
        }

    }

    /**
     * Ask the users to enter their names
     * @param names
     */
    private static void receivePlayers(String[] names){
        Scanner is = new Scanner(System.in);
        System.out.print("Enter the name of the first player: ");
        names[0]=is.nextLine();
        System.out.print("Enter the name of the first player: ");
        names[1]=is.nextLine();

    }

    /**
     * Initiate the players to play the game
     * @param players
     */
    private static void loadPlayers(Player[] players, String[] names){
        Boat[] boats = {new Boat(4),new Boat(4),new Boat(3),new Boat(3),new Boat(2),new Boat(2),new Boat(1),
                new Boat(1)};

        for (int i=0; i<players.length; i++) {
            players[i] = new Player(names[i],new Grid(),boats);
        }

        for (int i=0; i<players.length; i++) {
            setBoats(players[i]);
        }

        //loadBoatsAuto(players);
    }


    private static void setBoats(Player player) {

        System.out.print("Put your boats in the grid: write the position of the top-left angle.\n");
        for (Boat boat:player.getBoats()) {
            boolean next= true;
            while (next)
            {
                System.out.println("Boat of length " + boat.getLength()+ ": ");
                try {
                    next=setBoat(player,boat);
                }catch (IOException e){
                    next=true;
                }finally {
                    if (next==true)
                    {
                        System.out.println("Something went wrong. Please Try again.");
                    }
                }
            }
        }

    }

    private static boolean setBoat(Player player,Boat boat) throws IOException{
        Position position;
        Direction direction = null;
        Scanner is = new Scanner(System.in);
        int x,y,pos;
        System.out.print("Insert coordinate x: ");
        x= is.nextInt();
        System.out.print("Insert coordinate y: ");
        y= is.nextInt();
        position = new Position(x,y);
        System.out.print("In what position you want to put it?\n 1. Up \n 2. Right \n 3. Down \n 4. Left \nYour " +
                "choice: ");
        pos = is.nextInt();
        switch (pos){
            case 1:
                direction=Direction.Up;
                break;
            case 2:
                direction=Direction.Right;
                break;
            case 3:
                direction=Direction.Down;
                break;
            case 4:
                direction=Direction.Left;
                break;
        }
        boat.setPosition(position);
        boat.setDirection(direction);
        return player.putBoat(boat);
    }

    private static Position playerTurn(Player player) throws IOException{
        Scanner is = new Scanner(System.in);
        int x,y;
        System.out.println("Now, " + player.getName() + " choose where you want to try to hit your opponent boat.");
        System.out.print("X coordinate: ");
        x= is.nextInt();
        System.out.print("Y coordinate: ");
        y= is.nextInt();
         return new Position(x,y);

    }

    /*private static void loadPlayersAuto(Player[] players){

        for (int i=0; i<players.length; i++) {
            players[i] = new Player(new Grid());
        }

        loadBoatsAuto(players);

    }

    private static void loadBoatsAuto(Player[] players){
        //Player1
        /*boat:4
        players[0].putBoat(new Boat(4,new Position(0,0),Direction.Right));
        players[0].putBoat(new Boat(4,new Position(0,6),Direction.Right));
        //boat:3
        players[0].putBoat(new Boat(3,new Position(4,0),Direction.Right));
        players[0].putBoat(new Boat(3,new Position(6,3),Direction.Down));
        //boat:2
       // players[0].putBoat(new Boat(2,new Position(3,2),Direction.Down));
        //players[0].putBoat(new Boat(2,new Position(1,4),Direction.Right));
        //boat:1
        players[0].putBoat(new Boat(1,new Position(1,2),Direction.Right));
        players[0].putBoat(new Boat(1,new Position(4,5),Direction.Right));

        //Player2
        /*boat:4
        players[1].putBoat(new Boat(4,new Position(0,0),Direction.Down));
        players[1].putBoat(new Boat(4,new Position(5,2),Direction.Down));
        //boat:3
       players[1].putBoat(new Boat(3,new Position(1,6),Direction.Right));
        players[1].putBoat(new Boat(3,new Position(3,1),Direction.Down));
        //boat:2
       // players[1].putBoat(new Boat(2,new Position(6,0),Direction.Down));
       // players[1].putBoat(new Boat(2,new Position(1,5),Direction.Right));
        //boat:1
        players[1].putBoat(new Boat(1,new Position(1,0),Direction.Right));
        players[1].putBoat(new Boat(1,new Position(6,6),Direction.Right));
    }*/

}
