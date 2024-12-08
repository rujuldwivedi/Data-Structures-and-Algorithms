import java.util.ArrayList;
import java.util.List;
public class CombinationSum
{
    public static void helper(int i, List<Integer> list, List<List<Integer>> result, int k, int sum, int tempSum)
    {
        if (list.size() == k && tempSum == sum)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < 10; j++)
        {
            list.add(j);
            helper(j + 1, list, result, k, sum, tempSum + j);
            list.remove(list.size() - 1);
        }
    }    
    public static List<List<Integer>> combinationSum(int k, int n)
    {
        if (n <= k || n > 55) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(1, new ArrayList<>(), result, k, n, 0);
        return result;
    }
    public static void main(String args[])
    {
        int k = 3;
        int n = 7;
        List<List<Integer>> ans = combinationSum(k, n);
        System.out.println(ans);
    }
}
