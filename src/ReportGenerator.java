import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ReportGenerator{
    private ArrayList<Products> receivedList;
    private HashMap<Integer,Customer> receivedCustomer;
    ReportGenerator(ArrayList<Products> list,HashMap<Integer,Customer> idk){
        this.receivedList=list;
        this.receivedCustomer=idk;
    }
    public void generate(){
        System.out.println("Report of Product");
        for(Products p : receivedList){
            if (p.stock <=5){
                System.out.println(p.toString()+" ->Low Stock");
            }
            else{
                System.out.println(p.toString());
            }
        }
        System.out.println("Top People");
        HashMap m = new HashMap();
        receivedCustomer.values().forEach(customer -> {
            if (customer.products.size() >= 5){
                System.out.println(customer.name);
            }
        });
        AtomicInteger p = new AtomicInteger();
        receivedList.forEach((products)-> {
                p.set(p.get() + products.price);
        });
        System.out.println("Total Revenue "+p.get());
    }





}