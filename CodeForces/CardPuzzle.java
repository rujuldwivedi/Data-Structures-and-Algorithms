import java.util.*;

public class CardPuzzle
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        String[] input = new String[n];

        for(int i = 0; i < n; i++)
        input[i] = sc.nextLine();

        Set<String> ans = new HashSet<>();


        Arrays.sort(input, (a, b) -> b.length() - a.length());
        
        for(String card : input)
        {
            boolean isSubSt = false;

            for(String valid : ans)
            {
                if(valid.contains(card))
                {
                    isSubSt = true;
                    break;
                }
            }

            if(!isSubSt)
            ans.add(card);
        }

        System.out.println(ans.size());
    }
}
