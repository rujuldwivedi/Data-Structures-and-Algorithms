import java.util.*;
class Greedy
{
    public static void activitySelection(int[] start, int[] end)
    {
        int i=0;
        int  j=1;
        System.out.print(i+" ");
        while(j < start.length)
        {
            if(start[j] >= end[i])
            {
                System.out.print(j+" ");
                i = j;
            }
            j++;
        }
    }
    public static int maxWineProfit(int[] price, int i, int j, int x)
    {
        if(i > j)
        return 0;
        int left = price[i]*x + maxWineProfit(price, i+1, j, x+1);
        int right = price[j]*x + maxWineProfit(price, i, j-1, x+1);
        return Math.max(left, right);
    }
    public static int minPlatforms(int[] arr, int[] dep)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1;
        int j=0;
        int max=1;
        int curr=1;
        while(i < arr.length && j < dep.length)
        {
            if(arr[i] <= dep[j])
            {
                curr++;
                i++;
            }
            else
            {
                curr--;
                j++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
    public static int maxSum(int[] arr, int k)
    {
        int sum = 0;
        Arrays.sort(arr);
        for(int i=0; i<k; i++)
        sum += arr[i];
        return sum;
    }
    public static void main(String[] args)
    {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        activitySelection(start, end);
        int[] price = {2, 3, 5, 1, 4};
        System.out.println(maxWineProfit(price, 0, price.length-1, 1));
        int[] arr1 = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(minPlatforms(arr1, dep));
        int[] arr2 = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        System.out.println(maxSum(arr2, 3));
    }
}
