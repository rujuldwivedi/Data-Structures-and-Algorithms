import java.util.*;

public class GetLargestIndexLen
{
    public static boolean isOutlierFree(int[] feature1, int[] feature2, List<Integer> indices, int newIndex)
    {
        int n = indices.size();

        for(int i = 0; i < n; i++)
        {
            int index1 = indices.get(i);
            int index2 = newIndex;

            if(feature1[index1] == feature1[index2])
            return false;
            else if(feature1[index1] > feature1[index2] && feature2[index1] <= feature2[index2])
            return false;
            else if(feature1[index1] < feature1[index2] && feature2[index1] >= feature2[index2])
            return false;
        }

        return true;
    }

    public static int getLargestIndexLen(int[] feature1, int[] feature2)
    {
        int n = feature1.length;
        int maxLength = 0;

        for(int i=0; i<n; i++)
        {
            List<Integer> indices = new ArrayList<>();
            indices.add(i);

            int j = i + 1;

            while(j<n && isOutlierFree(feature1, feature2, indices, j))
            {
                indices.add(j);
                j++;
            }

            maxLength = Math.max(maxLength, indices.size());
        }

        return maxLength;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] feature1 = new int[n];
        int[] feature2 = new int[n];

        for(int i=0; i<n; i++)
        feature1[i] = sc.nextInt();

        for(int i=0; i<n; i++)
        feature2[i] = sc.nextInt();
        
        System.out.println(getLargestIndexLen(feature1, feature2));

        sc.close();
    }
}