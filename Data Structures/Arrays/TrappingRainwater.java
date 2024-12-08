public class TrappingRainwater
{

    /*
    * Here we'll do the following:
    * 1. Trapping Rainwater
    * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
    */
    
    // Function to find the maximum water that can be trapped
    public static int trap(int[] height)
    {
        int n = height.length;
        if (n == 0)
            return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        int trappedWater = 0;
        for (int i = 0; i < n; i++)
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        return trappedWater;
    }
    
    /*
    * The time complexity of the above approach is O(n)
    */
    
    public static void main(String[] args)
    {
        int[] height = { 3, 1, 2, 4, 0, 1, 3, 2 };
        System.out.println(trap(height));
    }    
}
