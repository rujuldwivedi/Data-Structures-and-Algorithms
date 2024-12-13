import java.util.*;

public class MathematicsProblem
{
    public static void helper(int[] arr)
    {
        int n = arr.length;
        
        Arrays.sort(arr);
        
        int[] permute = new int[n];

        for (int i = 0; i < n; i++)
        permute[i] = i + 1;
        
        int score = 0;

        for(int i=0; i<n; i++)
        score += Math.abs(permute[i] - arr[i]);
        
        System.out.println(Arrays.toString(permute).replaceAll("[\\[\\],]", ""));
    }

    public static void main(String[] args)
    {
        Scanner sc = new java.util.Scanner(System.in);
        
        int n = sc.nextInt();

        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++)
        arr[i] = sc.nextInt();
        
        helper(arr);
    }
}
