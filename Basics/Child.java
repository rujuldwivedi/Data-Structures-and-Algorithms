public class Child extends Parent
{
    Child()
    {
        System.out.println("Child constructor");
    }

    public void display()
    {
        System.out.println("Child display");
    }

    public static void main(String[] args)
    {
        Child c = new Child();
        c.display();
    }
}