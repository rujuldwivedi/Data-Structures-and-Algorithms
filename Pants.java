public class Pants extends Product implements Product.InnerProduct
{
    private double size;

    public Pants(double price, String color, String brand, double size)
    {
        super(price, color, brand);
        this.size = size;
    }

    @Override
    public void Fold()
    {
        System.out.println("Folding the pants");
    }

    @Override
    public void wear()
    {
        System.out.println("Wearing the pants");
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
        Pants p = new Pants(2500, "Black", "Adidas", 32);
        p.display();
        p.wear();
        p.Fold();
    }

}