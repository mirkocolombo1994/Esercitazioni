package Esercitazione2609_1.Esercizio3;

import java.util.Stack;

/**
 * Created by Mirko Colombo on 02/10/2017.
 */
public class IntStack {
    private Stack<Integer> intS;

    public IntStack (){
        this.intS = new Stack<Integer>();
    }

    public void addInt (int n){
        intS.add(n);
    }

    public boolean isMember(int n){
        for (int num:intS) {
            if (num==n){
                return true;
            }
        }
        return false;
    }

    /*public void remove(int n){
        if(this.isMember(n)){
            this.intS.remove();
        }
    }*/
}
