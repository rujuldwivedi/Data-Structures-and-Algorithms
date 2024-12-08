public class XOROperation
{
    /*
     * Here we'll do the following:
     * 1. Find the only non-repeating element in an array where all other elements repeat twice
     * 2. Find the two non-repeating elements in an array where all other elements repeat twice
     * 3. Find the only non-repeating element in an array where all other elements repeat k times
     */

    public static int findNonRepeatingElement(int[] arr)
    {
        /*
         * To find the only non-repeating element in an array where all other elements repeat twice,
         * we'll use the XOR operator.
         * The XOR operator returns 1 if the bits are different, else it returns 0.
         * We'll XOR all the elements of the array.
         * The repeating elements will cancel each other out and we'll be left with the non-repeating element.
         */
        int result = 0;
        for (int i = 0; i < arr.length; i++)
        {
            result ^= arr[i];
        }
        return result;
    }
    public static int[] findTwoNonRepeatingElements(int[] arr)
    {
        /*
         * To find the two non-repeating elements in an array where all other elements repeat twice,
         * we'll use the XOR operator.
         * The XOR operator returns 1 if the bits are different, else it returns 0.
         * We'll XOR all the elements of the array.
         * The repeating elements will cancel each other out and we'll be left with the XOR of the two non-repeating elements.
         * We'll find the rightmost set bit in the result.
         * We'll divide the array into two groups based on the rightmost set bit.
         * We'll XOR all the elements of each group to get the two non-repeating elements.
         */
        int result = 0;
        for (int i = 0; i < arr.length; i++)
        {
            result ^= arr[i];
        }
        int rightmostSetBit = result & -result;
        int[] resultArr = new int[2];
        for (int i = 0; i < arr.length; i++)
        {
            if ((arr[i] & rightmostSetBit) == 0)
            {
                resultArr[0] ^= arr[i];
            }
            else
            {
                resultArr[1] ^= arr[i];
            }
        }
        return resultArr;
    }
    public static int findNonRepeatingElementKTimes(int[] arr, int k)
    {
        /*
         * To find the only non-repeating element in an array where all other elements repeat k times,
         * we'll use the XOR operator.
         * The XOR operator returns 1 if the bits are different, else it returns 0.
         * We'll XOR all the elements of the array.
         * We'll count the number of 1s in the result.
         * If the count is not a multiple of k, the non-repeating element will have that bit set.
         */

        /*
        * Another Method:

        int result = 0;
        for (int i = 0; i < arr.length; i++)
        {
            result ^= arr[i];
        }
        int count = 0;
        int temp = result;
        while (temp > 0)
        {
            count += temp & 1;
            temp >>= 1;
        }
        if (count % k != 0)
        {
            return result;
        }
        return 0;
        */

        /*
        * The below code is a more optimized version of the above code.
            * We'll use an array of size 32 to store the count of 1s at each bit position.
            * We'll XOR all the elements of the array.
            * We'll count the number of 1s at each bit position.
            * If the count is not a multiple of k, the non-repeating element will have that bit set.
        */
        int[] count = new int[32];
        for (int i = 0; i < arr.length; i++)
        {
            int temp = arr[i];
            for (int j = 0; j < 32; j++)
            {
                count[j] += temp & 1;
                temp >>= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++)
        {
            if (count[i] % k != 0)
            {
                result |= 1 << i;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] arr1 = {1, 2, 3, 4, 1, 2, 3};
        System.out.println("The only non-repeating element in the array is "+findNonRepeatingElement(arr1));
        int[] arr2 = {1, 2, 3, 4, 1, 2, 3, 5};
        int[] resultArr = findTwoNonRepeatingElements(arr2);
        System.out.println("The two non-repeating elements in the array are "+resultArr[0]+" and "+resultArr[1]);
        int[] arr3 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4};
        System.out.println("The only non-repeating element in the array is "+findNonRepeatingElementKTimes(arr3,4));
    }
}