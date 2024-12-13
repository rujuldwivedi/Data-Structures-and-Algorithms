import java.util.*;

public class GetMinSize
{
    public static int getMinSize(int[] gameSize, int k) 
    {
        // Arrays.sort(gameSize, Collections.reverseOrder());

        for(int i=0; i<gameSize.length; i++)
        {
            for(int j=i+1; j<gameSize.length; j++)
            {
                if(gameSize[i] < gameSize[j])
                {
                    int temp = gameSize[i];
                    gameSize[i] = gameSize[j];
                    gameSize[j] = temp;
                }
            }
        }
        
        int maxPenDriveSize = 0;

        for(int i=0; i<gameSize.length; i++)
        maxPenDriveSize += gameSize[i];
        
        int low = 0;
        int high = maxPenDriveSize;
        int minCapacity = maxPenDriveSize;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            
            if(valid(gameSize, k, mid))
            {
                minCapacity = Math.min(minCapacity, mid);
                high = mid - 1;
            }
            else
            low = mid + 1;
        }
        
        return minCapacity;
    }
    
    public static boolean valid(int[] gameSize, int k, int penDriveSize)
    {
        int childrenAssigned = 0;
        int currentPenDriveSize = 0;
        
        for(int i=0; i<gameSize.length; i++)
        {
            if(currentPenDriveSize + gameSize[i] <= penDriveSize)
            currentPenDriveSize += gameSize[i];
            else
            {
                childrenAssigned++;
                currentPenDriveSize = gameSize[i];
                
                if(childrenAssigned == k)
                return false;
            }
        }
        
        return childrenAssigned < k;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] gameSize = new int[n];

        for(int i = 0; i < n; i++)
        gameSize[i] = scanner.nextInt();

        int numChildren = scanner.nextInt();

        int minCapacity = getMinSize(gameSize, numChildren);

        System.out.println(minCapacity);

        scanner.close();
    }    
}
