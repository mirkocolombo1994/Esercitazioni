package Esercitazione0310_2.Esercizio2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class CronManager {

    private List<Action> jobs;

    public List<Action> getJobs() {
        return jobs;
    }

    public CronManager(){
        jobs = new ArrayList<Action>();
    }

    public void addAction(Action action){
        jobs.add(action);
    }

    public void go(){
        boolean done = false;
        while (!done){
            done=true;
            for (Action a: jobs) {
                if(a.getWhen().isBefore(LocalDateTime.now()) && !a.isDone())
                {
                    a.getWhat().doIt();
                    a.setDone();
                }
                else if (!a.isDone())
                {
                 done = false;
                }
            }
        }
    }
}
