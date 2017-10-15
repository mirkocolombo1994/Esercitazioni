package Esercitazione0310_2.Esercizio3;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class IntQueueable implements Queueable{

    private int n;

    public IntQueueable(int n){
        this.n=n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
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
