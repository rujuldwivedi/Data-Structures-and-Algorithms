import java.util.*;
public class UnionFind
{
    public static int find(int x, List<Integer> set)
    {
        if(set.get(x) == x)
        return x;
        set.set(x, find(set.get(x), set));
        return set.get(x);
    }
    public static void union(int x, int y, List<Integer> set)
    {
        int xx = find(x, set);
        int yy = find(y, set);
        set.set(yy, xx);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the set: ");
        int size = sc.nextInt();
        List<Integer> set = new ArrayList<>();
        for (int element = 0; element < size; element++)
        set.add(element);
        System.out.println("Enter the number of operations: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            System.out.println("Enter the elements to union: ");
            int element1 = sc.nextInt();
            int element2 = sc.nextInt();
            union(element1, element2, set);
        }
        System.out.println("Enter the number of elements to find: ");
        int m = sc.nextInt();
        for (int i = 0; i < m; i++)
        {
            System.out.println("Enter the element to find: ");
            int element = sc.nextInt();
            System.out.println("The set containing the element is: " + find(element, set));
        }
        sc.close();
    }
}
