package Esercitazione0310_2.Esercizio2;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class PrintActionable implements Actionable {

    private String message;

    public PrintActionable(String message){
        this.message=message;
    }

    public void doIt() {
        System.out.println(message);
    }
}
