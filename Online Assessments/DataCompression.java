package GoogleOA;

import java.util.*;

public class DataCompression
{
    public static int compressData(int[] arr, int n)
    {
        List<Integer> numbers = new ArrayList<>();
        for(int num : arr)
        numbers.add(num);

        while(numbers.size() > 1)
        {
            numbers = performConcatenatingPhase(numbers);
            if(numbers.size() == 1)
            break;
            numbers = performAddingPhase(numbers);
        }

        return numbers.get(0);
    }

    public static List<Integer> performConcatenatingPhase(List<Integer> numbers)
    {
        List<Integer> tempKeys = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i += 2)
        {
            if (i + 1 < numbers.size())
            tempKeys.add(Integer.parseInt("" + numbers.get(i) + numbers.get(i + 1)));
            else
            tempKeys.add(numbers.get(i));
        }
        return tempKeys;
    }

    private static List<Integer> performAddingPhase(List<Integer> tempKeys)
    {
        List<Integer> newKeys = new ArrayList<>();
        for(int i = 0; i < tempKeys.size(); i += 2)
        {
            if (i + 1 < tempKeys.size())
            newKeys.add(tempKeys.get(i) + tempKeys.get(i + 1));
            else
            newKeys.add(tempKeys.get(i));
        }
        return newKeys;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
            System.out.println(compressData(arr, n));
        }
        sc.close();
    }
}