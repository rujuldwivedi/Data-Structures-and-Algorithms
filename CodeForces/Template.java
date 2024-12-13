/*
* Author: Rujul Dwivedi
 */
import static java.lang.Math.max;
import static java.lang.Math.min;
// import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.System.out;
import java.util.*;
import java.io.*;

public class Template
{
    public static void helper(FastScanner sc) throws Exception
    {
        int n = sc.nextInt();

        int[] dp = new int[n+1];

        dp[0] = 0;

        for(int i=1;i<10;i++)
        dp[i] = 1;

        for(int i=10;i<=n;i++)
        {
            int num1 = i - (i%10);
            int num2 = i - (i/10);

            dp[i] = min(dp[num1], dp[num2]);
        }

        out.println(dp[n]);

    }
    public static void main(String[] args) throws Exception
    {
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();

        // StringBuilder sb = new StringBuilder();

        while(t-- > 0)
        {
            // int n = sc.nextInt();
            // int[] arr = readArr(n, sc);

            helper(sc);
        }

    }
    
    public static int[] readArr(int N, FastScanner sc) throws Exception // Reads an array of size N-
    {
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
        arr[i] = sc.nextInt();

        return arr;
    }

    public static void print(int[] arr) // Prints an array
    {
        for(int x: arr)
        out.print(x+" ");

        out.println();
    }

    public static boolean isPrime(long n) // Checks if a number is prime
    {
        if(n < 2)
        return false;

        if(n == 2 || n == 3)
        return true;

        if(n%2 == 0 || n%3 == 0)
        return false;

        long sqrtN = (long)sqrt(n)+1;

        for(long i = 6L; i <= sqrtN; i += 6)
        {
            if(n%(i-1) == 0 || n%(i+1) == 0)
            return false;
        }

        return true;
    }
 
    public static long gcd(long a, long b) // Uses Euclid's Algorithm to calculate the GCD
    {
        if(a > b)
        a = (a+b)-(b=a); // This is basically a swap function for a and b

        if(a == 0L)
        return b;
        
        return gcd(b%a, a);
    }

    public static long totient(long n) // Calculates the Euler Totient Function for a number, which is the number of integers less than n that are coprime to n
    {
        long result = n;

        for(int p = 2; p*p <= n; ++p)
        {
            if(n%p == 0)
            {
                while(n%p == 0)
                n /= p;

                result -= result/p;
            }
        }

        if(n > 1)
        result -= result/n;

        return result;
    }

    public static int[] sieve(int N) // Calculates the smallest prime factor for each number from 1 to N
    {
        int[] res = new int[N+1];

        for(int i=2; i <= N; i++)
        {
            if(res[i] == 0)
            {
                for(int j=i; j <= N; j += i)
                res[j] = i;
            }
        }

        return res;
    }

    public static ArrayList<Integer> findDiv(int N) // Finds all the divisors of a number
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        for(int i=1; i <= (int)(sqrt(N)+0.00000001); i++)
        {
            if(N%i == 0)
            {
                list1.add(i);
                list2.add(N/i);
            }
        }

        Collections.reverse(list2);

        for(int b: list2)
        {
            if(b != list1.get(list1.size()-1))
            list1.add(b);
        }

        return list1;
    }

    public static void sort(int[] arr) // Sorts an array using Collections.sort() which uses merge sort instead of Arrays.sort() which uses quicksort
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int x: arr)
        list.add(x);

        Collections.sort(list);

        for(int i=0; i < arr.length; i++)
        arr[i] = list.get(i);
    }

    public static long power(long x, long y, long p) // Calculates x^y mod p in O(log y) time
    {
        long res = 1L;

        x = x%p;

        while(y > 0)
        {
            if((y&1)==1)
            res = (res*x)%p;

            y >>= 1;

            x = (x*x)%p;
        }

        return res;
    }

    public static void push(TreeMap<Integer, Integer> mpp, int key, int value) // Same as treemap where push adds v to the value k
    {
        if(!mpp.containsKey(key))
        mpp.put(key, value);

        else
        mpp.put(key, mpp.get(key)+value);
    }

    public static void pull(TreeMap<Integer, Integer> mpp, int key, int value) // Same as treemap where pull subtracts v from the value k
    {
        int keyValue = mpp.get(key);

        if(keyValue == value)
        mpp.remove(key);

        else
        mpp.put(key, keyValue-value);
    }

    public static int[] compress(int[] arr) // Compresses an array to a range of 1 to N by sorting the array and assigning each element a value from 1 to N
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int num: arr)
        list.add(num);

        Collections.sort(list);

        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int next = 1; // Next value to assign

        for(int num: list)
        {
            if(!mpp.containsKey(num))
            mpp.put(num, next++);
        }

        int[] res = new int[arr.length];

        for(int i=0; i < arr.length; i++)
        res[i] = mpp.get(arr[i]);

        return res;
    }

    public static long[][] multiply(long[][] matrix1, long[][] matrix2) // Multiplies two matrices in O(n^3) time using modular arithmetic
    {
        long MOD = 1000000007L;

        int N = matrix1.length;

        int M = matrix2[0].length;

        long[][] res = new long[N][M];

        for(int i=0; i < N; i++)
        {
            for(int j=0; j < M; j++)
            {
                for(int k=0; k < matrix1[0].length; k++)
                {
                    res[i][j] += (matrix1[i][k]*matrix2[k][j])%MOD; // MOD is used to prevent overflow

                    if(res[i][j] >= MOD)
                    res[i][j] -= MOD;
                }
            }
        }
        return res;
    }

    public static long[][] power(long[][] matrix, long pow) // Calculates matrix^pow in O(n^3 log pow) time using binary exponentiation
    {
        long[][] res = new long[matrix.length][matrix[0].length];

        for(int i=0; i < res.length; i++)
        res[i][i] = 1L;

        long[][] curr = matrix.clone(); // Creates a shallow copy of the matrix

        while(pow > 0)
        {
            if((pow&1L) == 1L)
            res = multiply(curr, res);

            pow >>= 1;
            curr = multiply(curr, curr);
        }

        return res;
    }
}

class DSU // Disjoint Set Union data structure with path compression and union by size
{
    public int[] parent; // Parent array
    public int[] len; // Size array

    public DSU(int N)
    {
        parent = new int[N+1];
        len = new int[N+1];

        for(int i=0; i <= N; i++)
        {
            parent[i] = i;
            len[i] = 1;
        }
    }

    public int find(int x) // Finds the parent of x
    {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
    public void merge(int x, int y) // Merges the sets containing x and y
    {
        int fx = find(x);
        int fy = find(y);
        parent[fx] = fy;
    }
    public void merge(int x, int y, boolean sized) // This will be used over normal merge function when the tree is becoming too tall
    {
        int fx = find(x);
        int fy = find(y);
        len[fy] += len[fx];
        parent[fx] = fy;
    }
}

class SegmentTree // Segment tree data structure for range queries and point updates
{
    final int[] val; // Segment tree array
    final int treeFrom; // Start of the range of the segment tree
    final int length; // Length of the segment tree

    public SegmentTree(int treeFrom, int treeTo)
    {
        this.treeFrom = treeFrom;

        int length = treeTo - treeFrom + 1;

        int l;

        for (l = 0; (1 << l) < length; l++);
        val = new int[1 << (l + 1)];

        this.length = 1 << l;
    }
    public void update(int index, int delta) // Updates the value at index by adding delta
    {

        int node = index - treeFrom + length;

        val[node] = delta;

        for (node >>= 1; node > 0; node >>= 1)
        val[node] = comb(val[node << 1], val[(node << 1) + 1]);
    }
    public int query(int from, int to) // Queries the range from 'from' to 'to'
    {
        
        if(to < from)
        return 0;

        from += length - treeFrom;
        to += length - treeFrom + 1;

        int res = 0;

        for (; from + (from & -from) <= to; from += from & -from)
        res = comb(res, val[from / (from & -from)]);

        for (; to - (to & -to) >= from; to -= to & -to)
        res = comb(res, val[(to - (to & -to)) / (to & -to)]);

        return res;
    }
    public int comb(int a, int b) // Combines two values
    {
        return max(a,b);
    }
}

class FenwickTree // Used over segment tree when the array is too large to fit in memory
{

    public int[] tree; // Fenwick tree array
    public int size; // Size of the Fenwick tree

    public FenwickTree(int size)
    {
        this.size = size;
        tree = new int[size+5];
    }
    public void add(int i, int v) // Adds v to the value at index i
    {
        while(i <= size)
        {
            tree[i] += v;
            i += i&-i;
        }
    }
    public int find(int i) // Finds the sum of the values from 1 to i
    {
        int res = 0;

        while(i >= 1)
        {
            res += tree[i];
            i -= i&-i;
        }

        return res;
    }
    public int find(int l, int r) // Finds the sum of the values from l to r
    {
        return find(r)-find(l-1);
    }
}

class SparseTable // Sparse table data structure for range queries in O(1) time
{
    public int[] log; // Log array
    public int[][] table; // Sparse table array
    public int N; // Size of the array
    public int K;  // Log of the size of the array

    public SparseTable(int N)
    {
        this.N = N;

        log = new int[N+2];

        K = Integer.numberOfTrailingZeros(Integer.highestOneBit(N));

        table = new int[N][K+1];

        sparsywarsy();
    }
    private void sparsywarsy() // Precomputes the log array
    {
        log[1] = 0;

        for(int i=2; i <= N+1; i++)
        log[i] = log[i/2]+1;
    }
    public void lift(int[] arr) // Builds the sparse table
    {
        int n = arr.length;

        for(int i=0; i < n; i++)
            table[i][0] = arr[i];

        for(int j=1; j <= K; j++)
        {
            for(int i=0; i + (1 << j) <= n; i++)
            table[i][j] = min(table[i][j-1], table[i+(1 << (j - 1))][j-1]);
        }
    }
    public int query(int L, int R) // Queries the range from L to R
    {

        L--; 
        R--;

        int mexico = log[R-L+1];

        return min(table[L][mexico], table[R-(1 << mexico)+1][mexico]);
    }
}
 
class BitSet // Bitset data structure for bitwise operations
{
    private int CONS = 62; // Number of bits in a long
    public long[] sets; // Array of longs
    public int size; // Size of the bitset

    public BitSet(int N)
    {
        size = N;

        if(N%CONS == 0)
        sets = new long[N/CONS];

        else
        sets = new long[N/CONS+1];
    }
    public void add(int i) // Adds the value i to the bitset
    {
        int dex = i/CONS;

        int thing = i%CONS;

        sets[dex] |= (1L << thing);
    }
    public int and(BitSet oth) // Finds the number of bits that are set in both bitsets
    {
        int boof = min(sets.length, oth.sets.length);

        int res = 0;

        for(int i=0; i < boof; i++)
        res += Long.bitCount(sets[i] & oth.sets[i]);

        return res;
    }
    public int xor(BitSet oth) // Finds the number of bits that are set in only one of the bitsets
    {
        int boof = min(sets.length, oth.sets.length);

        int res = 0;

        for(int i=0; i < boof; i++)
        res += Long.bitCount(sets[i] ^ oth.sets[i]);

        return res;
    }
}

class FastScanner // Fast I/O class
{ 
    BufferedReader br;  // To read data from console
    StringTokenizer st;   // To read data from console

    public FastScanner() 
    { 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next()  // Returns the next word
    { 
        while (st == null || !st.hasMoreElements())
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException e)
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() // Returns the next integer
    {
        return Integer.parseInt(next());
    }
 
    long nextLong() // Returns the next long
    {
        return Long.parseLong(next());
    }

    double nextDouble()  // Returns the next double
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine()  // Returns the next line
    { 
        String str = ""; 

        try
        { 
            if(st.hasMoreTokens())
            str = st.nextToken("\n"); 
            else
            str = br.readLine(); 
        } 
        catch (IOException e)
        { 
            e.printStackTrace(); 
        } 

        return str; 
    } 
} 