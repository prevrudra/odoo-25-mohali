import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class func implements Runnable{
    public ArrayList<Products> products = new ArrayList<>();
    HashMap<Integer, Customer> customer = new HashMap<>();
    static int id = 1;
    public void adduser(){
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        int contact = s.nextInt();
        Customer c =new Customer(name,contact);
        customer.put(id++,c);
    }
    public void search(String name){
        customer.values().forEach(customer1 -> {
            if(customer1.name.equalsIgnoreCase(name)){
                System.out.println(customer1.toString());
            }
        });
    }
    public void remove(String name,int contact){
        Scanner s = new Scanner(System.in);
        String name2 = s.nextLine();
        int idk = s.nextInt();
        for(int i =0;i<= customer.size();i++){
            customer.values().forEach(customer1 -> {
                if(customer1.name.equalsIgnoreCase(name) && customer1.number==idk){
                    customer1.name=null;
                    customer1.number= Integer.parseInt(null);
                    customer1.products=null;
                    customer1=null;
                    System.out.println("Data Removed Successfully");
                }

            });
        }
    }
    public void updateProduct(){
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        for (Products product : products) {
            if(product.name.equalsIgnoreCase(name)){
                System.out.println("Product found");
                System.out.println("Select what you want to update:\n ~ Name - 1\n ~ Price - 2 \n ~ Stock - 3");
                int value = s.nextInt();
                switch (value){
                    case 1:
                        String nam3 = s.nextLine();
                        product.name = nam3;
                        break;
                    case 2:
                        int nam32 = s.nextInt();
                        product.price = nam32;
                        break;
                    case 3:
                        int nam33 = s.nextInt();
                        product.stock = nam33;
                        break;
                }
            }
        }
    }
    public void deleteProduct() {

        for (Products product : products) {
            System.out.println(product.getId()+ ' '+product.name);
        }
        Scanner s = new Scanner(System.in);
        int id = s.nextInt();
        for (Products product : products) {
            if(product.getId()==id){
                products.remove(id);
            }
        }
    }
    public void saveFile() throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter("./Sample.txt"));
        for (Products p :products){
            w.write(p.toString());
            w.newLine();
        }
        w.close(); // Ensure data is written
        BufferedWriter w4 = new BufferedWriter(new FileWriter("./Sample2.txt"));
        customer.values().forEach(customer1 -> {
            try {
                w4.write(customer1.toString());
                w4.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        w4.close(); // Ensure data is written
    }
    @Override
    public void run(){
       while (true){
           try {
               saveFile();
               System.out.println("Writing");
               Thread.sleep(1000);
           } catch (IOException | InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }


}

public class Main {
    public static void main(String[] args) throws IOException {
        func f3 = new func();
        Thread t = new Thread(f3);
        t.start();

        // Sample Products
        Products p1 = new Products("Laptop", 55000,5);
        Products p2 = new Products("Phone", 20000,3);
        Products p3 = new Products("Headphones", 3000,1);
        f3.products.add(p1);
        f3.products.add(p2);
        f3.products.add(p3);

        // Sample Customers
        Customer c1 = new Customer("Alice", 987654321);
        Customer c2 = new Customer("Bob", 912345678);
        f3.customer.put(1, c1);
        f3.customer.put(2, c2);

        // Simulate purchases (add products to customers)
        c1.products.put(p1.price, p1.name);
        c1.products.put(p2.price, p2.name);
        c2.products.put(p3.price, p3.name);

        // Print to test
        Trnx Trnx = new Trnx(f3.products,f3.customer);
        // Sample transaction (if your Trnx class handles payment etc.)
        Trnx.buy(1, 2);
        Trnx.buy(2, 1);
        ReportGenerator r= new ReportGenerator(f3.products,f3.customer);
        r.generate();

        // Report
    }
}