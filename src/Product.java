class Products{
    public static int ID = 1;
    String name;
    int price;
    int stock;
    int id;
    Products (String name,int price,int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.id = ID++;

    }

    public int getId() {
        return id;
    }
    public String toString(){
        return "Product ID: " + id + ", Name: " + name + ", Price: $" + price;
    }
}
