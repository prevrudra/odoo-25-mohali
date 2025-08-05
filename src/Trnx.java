import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
public class Trnx {
    private ArrayList<Products> receivedList;
    private HashMap<Integer,Customer> receivedCustomer;
    Trnx(ArrayList<Products> list,HashMap<Integer,Customer> idk){
        this.receivedList=list;
        this.receivedCustomer=idk;
    }
    public void buy(int pId, int cId) throws IOException {
        for(Products p: receivedList){
            if(pId == p.getId()){
                p.stock=(p.stock-1);
                Customer c = receivedCustomer.get(cId);
                c.products.put(p.name,p.price);
                BufferedWriter w = new BufferedWriter(new FileWriter("tx.txt"));
                w.write(p.price+" "+c.name+" Purchased Successfully");
                System.out.println("Product Purchased Successfully");
                break;
            }
        }
    }
}
