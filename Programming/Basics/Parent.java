public class Parent
{
    Parent()
    {
        System.out.println("Parent constructor");
    }

    public void display()
    {
        System.out.println("Parent display");
    }

    public static void main(String[] args)
    {
        Parent p = new Parent();
        p.display();
    }
}