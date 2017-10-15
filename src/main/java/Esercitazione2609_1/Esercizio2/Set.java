package Esercitazione2609_1.Esercizio2;

/**
 * Created by Mirko Colombo on 26/09/2017.
 */
public class Set {

    private int[] numbers;
    private int cur_size;

    public Set(int len){
        this.cur_size=0;
        this.numbers= new int[len];
    }

    public Set(){
        numbers = new int[100];
        //otherwise
        // numbers = this(100);
    }

    public boolean isMember(int num){
        int i=0;
        while (i<this.cur_size){
            if (this.numbers[i]==num) {
                return true;
            }
        i++;
        }
        return false;
    }

    public void addMember(int n){
        if (this.isMember(n)){
            return;
        }
        if (this.cur_size== this.numbers.length) {
            return;
        }
        this.numbers[this.cur_size]=n;
        this.cur_size++;
    }

    /*public void deleteMember(int n){
        int i=0;
        while (int i<this.cur_size){
            if (this.numbers[i]==n) {
                this.cur_size--;
                while (i<this.cur_size){
                    this.numbers[i]=this.numbers[i+1];
                    i++;
                }
            }
        }
        return;
    }

    /*private int getPosition(int n){
        int i=0;
        while (i<cur_size){
            if (numbers[i]==n) {
                return  i;
            }
        }
    }*/

    /*public String toString(){
        int i=0;
        String s= "{";
        while (i<cur_size){
            s+=numbers[i];
            if (i!=cur_size-1) {
                s += ", ";
            }
        }
        s+="}";
        return s;
    }

    public void showSet() {System.out.print(this.toString());}*/
}
