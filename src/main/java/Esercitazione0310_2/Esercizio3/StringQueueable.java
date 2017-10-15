package Esercitazione0310_2.Esercizio3;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class StringQueueable implements Queueable{

    private String s;

    public StringQueueable(String s){
        this.s=s;
    }

    public boolean compareClasses(Object other) {
        if(this==other){
            return true;
        }
        if (other==null){
            return false;
        }
        if (this.getClass() != other.getClass()){
            return false;
        }else {
            return true;
        }
    }
}
