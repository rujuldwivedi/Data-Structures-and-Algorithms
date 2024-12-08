public class StringBuilderDemo
{
    public static void main(String[] args)
    {
        // Creating a StringBuilder object
        StringBuilder sb = new StringBuilder("Hello");

        // 1. append(): Concatenates the specified string to the end of the StringBuilder.
        sb.append(" World");
        System.out.println("After append(): " + sb); // Output: Hello World

        // 2. insert(): Inserts the specified string at the specified position.
        sb.insert(5, "Beautiful ");
        System.out.println("After insert(): " + sb); // Output: Hello Beautiful World

        // 3. delete(): Deletes characters from the specified start index to the end index.
        sb.delete(6, 16);
        System.out.println("After delete(): " + sb); // Output: Hello World

        // 4. deleteCharAt(): Deletes the character at the specified index.
        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt(): " + sb); // Output: HelloWorld

        // 5. replace(): Replaces characters from the specified start index to the end index with the specified string.
        sb.replace(5, 10, "Everyone");
        System.out.println("After replace(): " + sb); // Output: HelloEveryone

        // 6. reverse(): Reverses the characters in the StringBuilder.
        sb.reverse();
        System.out.println("After reverse(): " + sb); // Output: enoyrevEolleH

        // 7. capacity(): Returns the current capacity of the StringBuilder.
        System.out.println("Capacity: " + sb.capacity()); // Output: 23 (default capacity is 16 + length)

        // 8. length(): Returns the length (number of characters) of the StringBuilder.
        System.out.println("Length: " + sb.length()); // Output: 14

        // 9. charAt(): Returns the character at the specified index.
        System.out.println("Character at index 5: " + sb.charAt(5)); // Output: r

        // 10. substring(): Returns a new string that is a substring of the StringBuilder.
        System.out.println("Substring: " + sb.substring(5, 10)); // Output: Ever

        // 11. toString(): Converts the StringBuilder to a String.
        String str = sb.toString();
        System.out.println("String representation: " + str); // Output: enoyrevEolleH
    }
}