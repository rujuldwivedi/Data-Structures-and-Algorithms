public class BitMasking
{
    /*
     * We'll do the following:
     * 1. Find the ith bit of a number
     * 2. Set the ith bit of a number
     * 3. Unset the ith bit of a number
     * 4. Find the number of bits to convert a to b
     */

    public static void findIthBit(int n, int i)
    {
        /*
         * To find the ith bit of a number, we'll use the left shift operator.
         * We'll left shift 1 by i positions and then perform the AND operation with the number.
         * If the ith bit is 1, the result will be 1, else it will be 0.
         */
        int mask = 1 << i;
        int result = n & mask;
        System.out.println("The "+i+"th bit of "+n+" is "+(result == 0 ? 0 : 1));
    }
    public static void setIthBit(int n, int i)
    {
        /*
         * To set the ith bit of a number, we'll use the left shift operator.
         * We'll left shift 1 by i positions and then perform the OR operation with the number.
         * This will set the ith bit to 1.
         */
        int mask = 1 << i;
        int result = n | mask;
        System.out.println("After setting the "+i+"th bit of "+n+", we get "+result);
    }
    public static void unsetIthBit(int n, int i)
    {
        /*
         * To unset the ith bit of a number, we'll use the left shift operator.
         * We'll left shift 1 by i positions and then perform the NOT operation.
         * This will set the ith bit to 0.
         */
        int mask = 1 << i;
        mask = ~mask;
        int result = n & mask;
        System.out.println("After unsetting the "+i+"th bit of "+n+", we get "+result);
    }
    public static void findBitsToConvert(int a, int b)
    {
        /*
         * To find the number of bits to convert a to b, we'll use the XOR operator.
         * The XOR operator returns 1 if the bits are different, else it returns 0.
         * We'll count the number of 1s in the result to get the number of bits to convert.
         */

        /*
         * Another Method:
          
         int result = a ^ b;
         int count = 0;
         'n & n-1 will unset the rightmost bit'
         while (result > 0) 
         {
            count ++;
           result &= (result - 1);
         }
         System.out.println("The number of bits to convert "+a+" to "+b+" is "+count);

         */
        int result = a ^ b;
        int count = 0;

        //Counting number of 1s in the result
        while (result > 0)
        {
            count += result & 1;
            result >>= 1;
        }
        System.out.println("The number of bits to convert "+a+" to "+b+" is "+count);
    }
    public static void main(String[] args)
    {
        int n = 100;
        int i = 5;
        findIthBit(n, i);
        setIthBit(n, i);
        unsetIthBit(n, i);
        int a = 10;
        int b = 20;
        findBitsToConvert(a, b);
    }
}