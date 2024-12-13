import java.util.*;

public final class MaximiseScore
{
    public static void helper(Scanner sc)
    {
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] a = new int[n];
        int[] b = new int[n];
        
        for(int i=0; i<n; i++)
        a[i] = sc.nextInt();

        for(int i=0; i<n; i++)
        b[i] = sc.nextInt();
        
        Integer[] idx = new Integer[n];

        for(int i=0; i<n; i++)
        idx[i] = i;
 
        for(int i=0; i<n; i++)
        {
            for (int j=i+1; j<n; j++)
            {
                if(a[idx[i]] < a[idx[j]])
                {
                    int temp = idx[i];
                    idx[i] = idx[j];
                    idx[j] = temp;
                }
            }
        }

        // This will work for CP
        
        /*
        Arrays.sort(idx, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer i1, Integer i2)
            {
                return Integer.compare(a[i2], a[i1]);
            }
        });
        */
        
        int median = ((n - 1)/2) + 1;
        long low = 0;
        long high = (long) 1e10;
        
        while(low < high)
        {
            long mid = (low + high + 1)/2;
            boolean valid = false;
            
            for(int i : idx)
            {
                if(b[i] == 1)
                {
                    if(a[i] + k >= mid)
                    valid = true;
                    
                    long req = mid - a[i] - k;
                    int rem = median;
                    
                    for (int j : idx)
                    {
                        if(j == i)
                        continue;

                        if(rem == 0)
                        break;

                        if(a[j] >= req)
                        rem--;
                    }
                    
                    if(rem == 0)
                    valid = true;

                    break;
                }
            }
            
            for(int i : idx)
            {
                if(b[i] == 0)
                {
                    int rem = median;
                    long sum = 0;
                    long req = mid - a[i];
                    
                    for(int j : idx)
                    {
                        if(j == i)
                        continue;

                        if(rem == 0)
                        break;

                        if(a[j] >= req)
                        rem--;
                        else if(b[j] == 1)
                        {
                            sum += req - a[j];
                            rem--;
                        }
                    }
                    
                    if(rem == 0 && sum <= k)
                    valid = true;
                    
                    break;
                }
            }
            
            if(valid)
            low = mid;
            else
            high = mid - 1;
        }
        
        System.out.println(low);
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inputs");
        
        int t = sc.nextInt();

        System.out.println();
        System.out.println("Outputs");

        while(t-- > 0)
        helper(sc);

        sc.close();
    }
}