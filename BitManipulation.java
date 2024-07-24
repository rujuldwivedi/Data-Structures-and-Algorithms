public class BitManipulation
{
    /*
    Here we'll see the different bitwise operators in Java
    */    
    public static void AND(int a, int b)
    {

        /*
         * The AND operator is represented by &.
         * It returns 1 if both the bits are 1, otherwise 0.
         * It is equivalent to multiplying the numbers.
         */

        int c = a & b;

        /*

        Here's the table showing how the AND operator works:

        a   |    b   |    c
        --------------
        0   |   0   |    0
        0   |   1    |   0
        1    |  0    |   0
        1    |  1     |   1 
        
        */

        System.out.println(a+" & "+b+" = "+c);
    }
    public static void OR(int a, int b)
    {

        /*
         * The OR operator is represented by |.
         * It returns 1 if any of the bits is 1, otherwise 0.
         * It is equivalent to adding the numbers.
         */

        int c = a | b;

        /*

        Here's the table showing how the OR operator works:

        a   |    b   |    c
        --------------
        0   |   0   |    0
        0   |   1    |   1
        1    |  0    |   1
        1    |  1     |   1 
        
        */

        System.out.println(a+" | "+b+" = "+c);
    }
    public static void XOR(int a, int b)
    {

        /*
         * The XOR operator is represented by ^.
         * It returns 1 if the bits are different, otherwise 0.
         * It is also known as the inequality operator.
         */

        int c = a ^ b;

        /*

        Here's the table showing how the XOR operator works:

        a   |    b   |    c
        --------------
        0   |   0   |    0
        0   |   1    |   1
        1    |  0    |   1
        1    |  1     |   0 
        
        */

        System.out.println(a+" ^ "+b+" = "+c);
    }
    public static void NOT(int a)
    {

        /*
         * The NOT operator is represented by ~.
         * It returns the complement of the number.
         * It is equivalent to subtracting the number from 1.
         */

        int c = ~a;

        /*

        Here's the table showing how the NOT operator works:

        a   |    c
        --------------
        0   |   1
        1   |   0
        
        */

        System.out.println("~"+a+" = "+c);
    }
    public static void leftShift(int a, int b)
    {

        /*
         * The left shift operator is represented by <<.
         * It shifts the bits to the left by the number of positions specified.
         * It is equivalent to multiplying the number by 2^b, 'b' being the number of positions shifted.
         */

        int c = a << b;

        /*

        Here's the table showing how the left shift operator works:

        a   |    b   |    c
        --------------
        1   |   1   |    2
        1   |   2    |   4
        2    |  1    |   4
        2    |  2     |   8 
        
        */

        System.out.println(a+" << "+b+" = "+c);
    }
    public static void rightShift(int a, int b)
    {

        /*
         * The right shift operator is represented by >>.
         * It shifts the bits to the right by the number of positions specified.
         * It is equivalent to dividing the number by 2^b, 'b' being the number of positions shifted.
         */
        int c = a >> b;

        /*

        Here's the table showing how the right shift operator works:

        a   |    b   |    c
        --------------
        2   |   1   |    1
        4   |   2    |   1
        4    |  1    |   2
        8    |  2     |   2 
        
        */

        System.out.println(a+" >> "+b+" = "+c);
    }
    public static void rightShiftZero(int a, int b)
    {

        /*
         * The right shift zero operator is represented by >>>.
         * The difference between >> and >>> is that the leftmost bit is always 0 in >>>.
         */
        int c = a >>> b;

        /*

        Here's the table showing how the right shift zero operator works:

        a   |    b   |    c
        --------------
        2   |   1   |    1
        4   |   2    |   1
        4    |  1    |   2
        8    |  2     |   2 
        
        */

        System.out.println(a+" >>> "+b+" = "+c);
    }
    public static void main(String[] args)
    {
        AND(2, 3);
        OR(2, 3);
        XOR(2, 3);
        NOT(2);
        leftShift(2, 1);
        rightShift(2, 1);
        rightShiftZero(2, 1);
    }
}