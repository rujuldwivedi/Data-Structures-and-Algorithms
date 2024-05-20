import java.io.*;
import java.util.*;

public class ExceptionHandling
{
    public static void main(String[] args)
    {
        try
        {
            // Attempting to read a file that may not exist
            File file = new File("nonexistentfile.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            // Handling the exception when the file is not found
            System.out.println("File not found: " + e.getMessage());
            // Attempting to read from the default input stream (e.g., keyboard)
            Scanner userInputScanner = new Scanner(System.in);
            System.out.println("Enter a string: ");
            String userInput = userInputScanner.nextLine();
            System.out.println("You entered: " + userInput);
            userInputScanner.close();
        }
        finally
        {
            // Code in the finally block will always execute, whether an exception occurs or not
            System.out.println("Finally block executed");
        }

        // Example of unchecked exception (ArithmeticException)
        try
        {
            int result = 10 / 0; // This will throw ArithmeticException
            System.out.println("Result: " + result);
        }
        catch(ArithmeticException e)
        {
            // Handling ArithmeticException
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }

        // Example of custom exception handling
        try
        {
            int age = -5;
            if(age < 0)
            throw new IllegalArgumentException("Age cannot be negative");
        }
        catch(IllegalArgumentException e)
        {
            // Handling custom exception
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }
}