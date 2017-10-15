package Esercitazione0910_3.Esercizio1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mirko Colombo on 09/10/2017.
 */
public class Supermarket {

    private List<WarehouseItem> warehouseItems;

    public  Supermarket(){
        warehouseItems = new ArrayList<WarehouseItem>();
    }

    public void addProduct(List<WarehouseItem> newSupply){
        warehouseItems.addAll(newSupply);
    }

    public List<WarehouseItem> listProducts(){
        ArrayList<WarehouseItem> ret = new ArrayList<WarehouseItem>();
        for (WarehouseItem p:warehouseItems) {
            ret.add((WarehouseItem)p.clone());
        }
        return ret;
    }

    private WarehouseItem findItem(Product product) throws ProductNotAvailableException {
        for (WarehouseItem item: warehouseItems) {
            if(item.getProduct().equals(item)){
                return item;
            }
        }
        throw new ProductNotAvailableException();
    }

    public WarehouseItem buyProduct(Product p, int quantity){

        try {
            WarehouseItem item = this.findItem(p);
            return item.buyProduct(quantity);
        } catch (ProductNotAvailableException e) {
            e.printStackTrace();
        }
        return null;
    }

}
