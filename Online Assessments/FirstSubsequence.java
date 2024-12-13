package GoogleOA;

import java.util.Scanner;

public class FirstSubsequence
{

    public static int locateSubsequence(String haystack, String needle)
    {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        if(needleLength == 0)
        return 1;
        if(haystackLength < needleLength)
        return -1;
        
        for(int startIndex = 0; startIndex <= haystackLength - needleLength; ++startIndex)
        {
            boolean potentialMatch = true;
            int alterationCount = 0;
            
            for(int offset = 0; offset < needleLength; ++offset)
            {
                if(haystack.charAt(startIndex + offset) != needle.charAt(offset))
                {
                    if(offset == 0)
                    {
                        potentialMatch = false;
                        break;
                    }
                    ++alterationCount;
                    if(alterationCount > 1)
                    {
                        potentialMatch = false;
                        break;
                    }
                }
            }
            
            if (potentialMatch)
            return startIndex + 1;
        }
        
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int testCases = sc.nextInt();
        sc.nextLine();
        
        while (testCases-- > 0)
        {
            String sourceString = sc.nextLine();
            String targetSubsequence = sc.nextLine();
            System.out.println(locateSubsequence(sourceString, targetSubsequence));
        }
        
        sc.close();
    }
}
