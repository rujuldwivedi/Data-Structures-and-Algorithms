class Sample
{
    class Car
    {
        private String name;
        private String color;
        private int speed;
        
        Car(String name, String color, int speed)
        {
            this.name = name;
            this.color = color;
            this.speed = speed;
        }
        void display()
        {
            System.out.println("Name: " + name + " Color: " + color + " Speed: " + speed);
        }
    }
    String chatBot()
    {
        return "Hello";
    }
    public static void main(String[] args)
    {
        Sample s = new Sample();
        
        Car c = s.new Car("BMW", "Black", 200);
        c.display();
    }
}