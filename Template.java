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
    public static void main(String[] args) throws Exception
    {
        /*
        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(infile.readLine());

        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(T-->0)
        {
            st = new StringTokenizer(infile.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[] arr = readArr(n, infile, st);
        }
        */

        //BufferedReader infile = new BufferedReader(new FileReader("input.txt"));
        //System.setOut(new PrintStream(new File("output.txt")));
    }
    
    public static int[] readArr(int N, BufferedReader infile, StringTokenizer st) throws Exception
    {
        int[] arr = new int[N];
        st = new StringTokenizer(infile.readLine());
        for(int i=0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    public static void print(int[] arr)
    {
        for(int x: arr)
            out.print(x+" ");
        out.println();
    }

    public static boolean isPrime(long n)
    {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

    public static long gcd(long a, long b)
    {
        if(a > b)
            a = (a+b)-(b=a);
        if(a == 0L)
            return b;
        return gcd(b%a, a);
    }

    public static long totient(long n)
    {
        long result = n;
        for (int p = 2; p*p <= n; ++p)
            if (n % p == 0)
            {
                while(n%p == 0)
                    n /= p;
                result -= result/p;
            }
        if (n > 1)
            result -= result/n;
        return result;
    }

    public static int[] sieve(int N)
    {
        int[] res = new int[N+1];
        for(int i=2; i <= N; i++)
            if(res[i] == 0)
                for(int j=i; j <= N; j += i)
                    res[j] = i;
        return res;
    }

    public static ArrayList<Integer> findDiv(int N)
    {
        ArrayList<Integer> ls1 = new ArrayList<Integer>();
        ArrayList<Integer> ls2 = new ArrayList<Integer>();
        for(int i=1; i <= (int)(sqrt(N)+0.00000001); i++)
            if(N%i == 0)
            {
                ls1.add(i);
                ls2.add(N/i);
            }
        Collections.reverse(ls2);
        for(int b: ls2)
            if(b != ls1.get(ls1.size()-1))
                ls1.add(b);
        return ls1;
    }

    public static void sort(int[] arr)
    {
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int x: arr)
            ls.add(x);
        Collections.sort(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }

    public static long power(long x, long y, long p)
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

    public static void push(TreeMap<Integer, Integer> map, int k, int v)
    {
        if(!map.containsKey(k))
            map.put(k, v);
        else
            map.put(k, map.get(k)+v);
    }

    public static void pull(TreeMap<Integer, Integer> map, int k, int v)
    {
        int lol = map.get(k);
        if(lol == v)
            map.remove(k);
        else
            map.put(k, lol-v);
    }

    public static int[] compress(int[] arr)
    {
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int x: arr)
            ls.add(x);
        Collections.sort(ls);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int boof = 1;
        for(int x: ls)
            if(!map.containsKey(x))
                map.put(x, boof++);
        int[] brr = new int[arr.length];
        for(int i=0; i < arr.length; i++)
            brr[i] = map.get(arr[i]);
        return brr;
    }

    public static long[][] multiply(long[][] left, long[][] right)
    {
        long MOD = 1000000007L;
        int N = left.length;
        int M = right[0].length;
        long[][] res = new long[N][M];
        for(int a=0; a < N; a++)
            for(int b=0; b < M; b++)
                for(int c=0; c < left[0].length; c++)
                {
                    res[a][b] += (left[a][c]*right[c][b])%MOD;
                    if(res[a][b] >= MOD)
                        res[a][b] -= MOD;
                }
        return res;
    }

    public static long[][] power(long[][] grid, long pow)
    {
        long[][] res = new long[grid.length][grid[0].length];
        for(int i=0; i < res.length; i++)
            res[i][i] = 1L;
        long[][] curr = grid.clone();
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

class DSU
{
    public int[] dsu;
    public int[] size;

    public DSU(int N)
    {
        dsu = new int[N+1];
        size = new int[N+1];
        for(int i=0; i <= N; i++)
        {
            dsu[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x)
    {
        return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
    }
    public void merge(int x, int y)
    {
        int fx = find(x);
        int fy = find(y);
        dsu[fx] = fy;
    }
    public void merge(int x, int y, boolean sized)
    {
        int fx = find(x);
        int fy = find(y);
        size[fy] += size[fx];
        dsu[fx] = fy;
    }
}

class FenwickTree
{

    public int[] tree;
    public int size;

    public FenwickTree(int size)
    {
        this.size = size;
        tree = new int[size+5];
    }
    public void add(int i, int v)
    {
        while(i <= size)
        {
            tree[i] += v;
            i += i&-i;
        }
    }
    public int find(int i)
    {
        int res = 0;
        while(i >= 1)
        {
            res += tree[i];
            i -= i&-i;
        }
        return res;
    }
    public int find(int l, int r)
    {
        return find(r)-find(l-1);
    }
}

class SegmentTree
{
    final int[] val;
    final int treeFrom;
    final int length;

    public SegmentTree(int treeFrom, int treeTo)
    {
        this.treeFrom = treeFrom;
        int length = treeTo - treeFrom + 1;
        int l;
        for (l = 0; (1 << l) < length; l++);
        val = new int[1 << (l + 1)];
        this.length = 1 << l;
    }
    public void update(int index, int delta)
    {

        int node = index - treeFrom + length;
        val[node] = delta;
        for (node >>= 1; node > 0; node >>= 1)
            val[node] = comb(val[node << 1], val[(node << 1) + 1]);
    }
    public int query(int from, int to)
    {
        
        if (to < from)
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
    public int comb(int a, int b)
    {

        return max(a,b);
    }
}

class SparseTable
{
    public int[] log;
    public int[][] table;
    public int N;  public int K;

    public SparseTable(int N)
    {
        this.N = N;
        log = new int[N+2];
        K = Integer.numberOfTrailingZeros(Integer.highestOneBit(N));
        table = new int[N][K+1];
        sparsywarsy();
    }
    private void sparsywarsy()
    {
        log[1] = 0;
        for(int i=2; i <= N+1; i++)
            log[i] = log[i/2]+1;
    }
    public void lift(int[] arr)
    {
        int n = arr.length;
        for(int i=0; i < n; i++)
            table[i][0] = arr[i];
        for(int j=1; j <= K; j++)
            for(int i=0; i + (1 << j) <= n; i++)
                table[i][j] = min(table[i][j-1], table[i+(1 << (j - 1))][j-1]);
    }
    public int query(int L, int R)
    {

        L--;  R--;
        int mexico = log[R-L+1];
        return min(table[L][mexico], table[R-(1 << mexico)+1][mexico]);
    }
}

class BitSet
{
    private int CONS = 62;
    public long[] sets;
    public int size;

    public BitSet(int N)
    {
        size = N;
        if(N%CONS == 0)
            sets = new long[N/CONS];
        else
            sets = new long[N/CONS+1];
    }
    public void add(int i)
    {
        int dex = i/CONS;
        int thing = i%CONS;
        sets[dex] |= (1L << thing);
    }
    public int and(BitSet oth)
    {
        int boof = min(sets.length, oth.sets.length);
        int res = 0;
        for(int i=0; i < boof; i++)
            res += Long.bitCount(sets[i] & oth.sets[i]);
        return res;
    }
    public int xor(BitSet oth)
    {
        int boof = min(sets.length, oth.sets.length);
        int res = 0;
        for(int i=0; i < boof; i++)
            res += Long.bitCount(sets[i] ^ oth.sets[i]);
        return res;
    }
}

class FastScanner
{
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;

    public FastScanner() {
        in = new BufferedInputStream(System.in, BS);
    }

    public FastScanner(String s) {
        try {
            in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
        } catch (Exception e) {
            in = new BufferedInputStream(System.in, BS);
        }
    }

    private char getChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }

    public int nextInt() {
        return (int) nextLong();
    }

    public int[] nextInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) nextLong();
        }
        return res;
    }

    public long[] nextLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextLong();
        }
        return res;
    }

    public long nextLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = getChar();
        for (; (c < '0' || c > '9'); c = getChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = getChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }

    public double nextDouble() {
        double cur = nextLong();
        return c != '.' ? cur : cur + nextLong() / cnt;
    }

    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    public String next() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c > 32) {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }

    public String nextLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c != '\n') {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }

    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = getChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}