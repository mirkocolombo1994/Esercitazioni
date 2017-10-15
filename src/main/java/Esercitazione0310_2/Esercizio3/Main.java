package Esercitazione0310_2.Esercizio3;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class Main {

    public static void main (String[] args){

        UnlimitedQueue q = new UnlimitedQueue();
        try {
            q.insert(new StringQueueable("String1"));
            q.insert(new StringQueueable("String2"));
        }catch (ObjectNotValidException e){
            e.printStackTrace();
        }

        try {
            q.insert(new IntQueueable(3));

        }catch (ObjectNotValidException e){
            e.printStackTrace();
        }
    }
}
