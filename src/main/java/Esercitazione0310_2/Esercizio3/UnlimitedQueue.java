package Esercitazione0310_2.Esercizio3;

import java.util.Vector;

/**
 * Created by Mirko Colombo on 03/10/2017.
 */
public class UnlimitedQueue {

    private Vector<Queueable> queue;

    public UnlimitedQueue (){
        queue = new Vector<Queueable>();
    }

    public void insert(Object o) throws ObjectNotValidException {
        Queueable a;
        try {
            a= (Queueable) o;
        }catch (ClassCastException e){
            System.err.print("Object not valid");
            throw new ObjectNotValidException();
        }

        if (!queue.isEmpty() && !a.compareClasses(queue.firstElement())){
            System.err.print("WRong object");
            throw new ObjectNotValidException();
        }

        queue.addElement(a);
        System.out.print("Object Inserted correctly");
    }

}
