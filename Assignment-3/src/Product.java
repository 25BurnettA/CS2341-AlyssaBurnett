public class Product 
{

    public String id, name, category, price;

    Product(String i, String n, String c, String p)
    {
        id = i;
        name = n;
        category = c;
        price = p;
    }

    public String toString()
    {
        return this.id + " " + this.name + " " + this.category + " " + this.price;
    }
}
