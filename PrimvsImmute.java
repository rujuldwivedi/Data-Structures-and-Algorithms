public class PrimvsImmute
{
    public static void main(String[] args)
    {
        // Primitive data types
        int primitiveInt1 = 10;
        int primitiveInt2 = primitiveInt1;
        primitiveInt2 = 20;
        System.out.println("Primitive Int 1: " + primitiveInt1); // Output: 10
        System.out.println("Primitive Int 2: " + primitiveInt2); // Output: 20

        // Immutable object - String
        String immutableStr1 = "Hello";
        String immutableStr2 = immutableStr1;
        immutableStr2 = "World";
        System.out.println("Immutable String 1: " + immutableStr1); // Output: Hello
        System.out.println("Immutable String 2: " + immutableStr2); // Output: World

        // Primitive data types
        Integer primitiveInt3 = 10;
        Integer primitiveInt4 = primitiveInt3;
        primitiveInt2 = 20;
        System.out.println("Primitive Int 1: " + primitiveInt1); // Output: 10
        System.out.println("Primitive Int 2: " + primitiveInt2); // Output: 20
        System.out.println("Primitive Int 3: " + primitiveInt3); // Output: 10
        System.out.println("Primitive Int 4: " + primitiveInt4); // Output: 10

        // Immutable object - String
        String immutableStr3 = "Hello";
        String immutableStr4 = immutableStr3;
        immutableStr2 = "World";
        System.out.println("Immutable String 1: " + immutableStr1); // Output: Hello
        System.out.println("Immutable String 2: " + immutableStr2); // Output: World
        System.out.println("Immutable String 3: " + immutableStr3); // Output: Hello
        System.out.println("Immutable String 4: " + immutableStr4); // Output: Hello
    }
}