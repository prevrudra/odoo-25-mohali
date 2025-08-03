import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

class Customer{
    String name;
    int number;
    HashMap products=new HashMap();
    Customer (String name,int number){
        this.name = name;
        this.number=number;
    }

    public String toString(){
        return "Name: " + name + ", Contact: " + number;
    }
}
