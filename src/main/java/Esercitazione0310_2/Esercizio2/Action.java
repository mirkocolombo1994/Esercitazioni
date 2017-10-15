package Esercitazione0310_2.Esercizio2;

import java.time.LocalDateTime;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class Action {

    private Actionable what;
    private LocalDateTime when;
    private boolean done;

    public Action(Actionable what,LocalDateTime when){
        this.what=what;
        this.when=when;
        this.done=false;
    }

    public  Actionable getWhat(){
        return this.what;
    }

    public LocalDateTime getWhen(){
        return this.when;
    }

    public boolean isDone(){
        return done;
    }

    public void  setDone(){
        this.done=true;
    }

}
