public class Shirts extends Product implements Product.InnerProduct
{
    private double size;

    public Shirts(double price, String color, String brand, double size)
    {
        super(price, color, brand);
        this.size = size;
    }

    @Override
    public void Fold()
    {
        System.out.println("Folding the shirt");
    }

    @Override
    public void wear()
    {
        System.out.println("Wearing the shirt");
    }

    public void display()
    {
        System.out.println("Price: " + getPrice());
        System.out.println("Color: " + getColor());
        System.out.println("Brand: " + getBrand());
        System.out.println("Size: " + size);
    }

    public static void main(String[] args)
    {
        Shirts s = new Shirts(1000, "Red", "Nike", 42);
        s.display();
        s.wear();
        s.Fold();
    }

}