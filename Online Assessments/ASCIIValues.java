package GoogleOA;

import java.util.*;

public class ASCIIValues
{
    static void processStrings(String s, String names)
    {
        String[] arr = s.split("\\.");
        String name = names;

        List<String> substrings = new ArrayList<>();
        for(String str : arr)
        substrings.add(str.substring(0, 3));

        int initialIndex = Arrays.asList(arr).indexOf(name);
        int nameMoveCount = 0;

        boolean sorted;
        do
        {
            sorted = true;
            for(int i = 0; i < substrings.size() - 1; i++)
            {
                if(compareSubstrings(substrings.get(i), substrings.get(i + 1)) < 0)
                {
                    Collections.swap(substrings, i, i + 1);
                    Collections.swap(Arrays.asList(arr), i, i + 1);
                    sorted = false;
                }
            }
        }while (!sorted);

        int finalIndex = Arrays.asList(arr).indexOf(name);
        nameMoveCount = Math.abs(finalIndex - initialIndex);

        int asciiValue = 0;
        String nameSubstring = name.substring(0, 3);
        for(char c : nameSubstring.toCharArray())
        asciiValue += (int) c;

        System.out.println(nameMoveCount - 1);
        System.out.println(asciiValue);
    }

    private static int compareSubstrings(String s1, String s2)
    {
        int sum1 = s1.chars().sum();
        int sum2 = s2.chars().sum();
        return Integer.compare(sum2, sum1);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();

        while(t-- > 0)
        {
            String s = sc.next();
            String names = sc.next();
            processStrings(s, names);
        }

        sc.close();
    }
}