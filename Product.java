public abstract class Product
{
    private double price;
    private String color;
    private String brand;

    public Product(double price, String color, String brand)
    {
        this.price = price;
        this.color = color;
        this.brand = brand;
    }

    public double getPrice()
    {
        return price;
    }

    public String getColor()
    {
        return color;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void Fold()
    {
        System.out.println("Folding the product");
    }

    public abstract void wear();

    public interface InnerProduct
    {
        public void Fold();
        public void wear();
    }

}