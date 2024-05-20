import java.util.*;

class OOPS
{
    private int[] data;

    // Constructor
    public OOPS(int[] data)
    {
        this.data = data;
    }

    // Getter
    public int[] getData()
    {
        return data;
    }

    // Setter
    public void setData(int[] data)
    {
        this.data = data;
    }

    // Copy Constructor
    public OOPS(OOPS other)
    {
        this.data = Arrays.copyOf(other.data, other.data.length);
    }

    // Overloading constructor to handle different types of inputs
    public OOPS(int size)
    {
        this.data = new int[size];
        for(int i = 0; i < size; i++)
        this.data[i] = i + 1;
    }

    // Overriding toString method
    @Override
    public String toString()
    {
        return "OOPS{" +"data=" + Arrays.toString(data) +'}';
    }

    // DeepCopy method
    public OOPS deepCopy()
    {
        return new OOPS(Arrays.copyOf(this.data, this.data.length));
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3};
        
        // Creating an object using the provided constructor
        OOPS obj1 = new OOPS(arr);
        System.out.println("Object 1: " + obj1);

        // Creating an object using the overloaded constructor
        OOPS obj2 = new OOPS(5);
        System.out.println("Object 2: " + obj2);

        // Copy constructor
        OOPS obj3 = new OOPS(obj1);
        System.out.println("Object 3 (copy of Object 1): " + obj3);

        // Testing getter and setter
        System.out.println("Before Setter: " + Arrays.toString(obj2.getData()));
        obj2.setData(new int[]{5, 4, 3, 2, 1});
        System.out.println("After Setter: " + Arrays.toString(obj2.getData()));

        // Testing deep copy
        OOPS obj4 = obj1.deepCopy();
        System.out.println("Object 4 (deep copy of Object 1): " + obj4);
    }
}