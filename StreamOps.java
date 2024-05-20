import java.util.*;

public class StreamOps
{
    public static void main(String[] args)
    {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        numbers.stream()
               .filter(x -> x % 2 == 0) //filters out odd numbers, using predicate
                .map(x -> x * x) //transforms each element by squaring it
                .sorted((x, y) -> y.compareTo(x)) //sorts in descending order, using comparator
                .map(x -> "$" + x) //transforms each element by prepending a dollar sign
                .forEach(System.out::println); //prints each element and terminates the stream
    }
}
