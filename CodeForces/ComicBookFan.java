import java.util.*;

public class ComicBookFan
{
    static class Helper
    {
        String name;
        int price;

        Helper(String name, int price)
        {
            this.name = name;
            this.price = price;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String[] names = sc.nextLine().split(",\\s*");
        
        String[] prices = sc.nextLine().split(",\\s*");
        
        int amt = sc.nextInt();
        
        List<Helper> list = new ArrayList<>();

        for(int i=0; i<names.length; i++)
        list.add(new Helper(names[i], Integer.parseInt(prices[i])));

        list.sort((b1, b2) ->
        {
            if(b1.price != b2.price)
            return Integer.compare(b1.price, b2.price);
            else
            return b1.name.compareTo(b2.name);
        });
        
        List<String> ans = new ArrayList<>();

        for(int i=0; i<list.size(); i++)
        {
            if(amt >= 2*list.get(i).price)
            {
                ans.add(list.get(i).name);
                amt -= 2*list.get(i).price;
            }
        }

        if(ans.isEmpty())
        System.out.println("NONE");
        else
        {
            for(String st : ans)
            System.out.println(st);
        }
    }
}
