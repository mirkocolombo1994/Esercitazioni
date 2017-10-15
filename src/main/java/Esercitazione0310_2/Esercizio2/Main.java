package Esercitazione0310_2.Esercizio2;

import java.time.LocalDateTime;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class Main {

    public static void main (String[] args){

        CronManager cron = new CronManager();

        for (int i=0;i<10;i++){
            Action a = new Action(new PrintActionable("Ciao" + i +"!"), LocalDateTime.now().plusSeconds(3+i));
            cron.addAction(a);
        }
        cron.go();

    }

}
