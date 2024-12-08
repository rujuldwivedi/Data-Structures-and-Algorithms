import java.util.*;

public class GroupAnagrams
{
    public List<List<String>> groupAnagrams(String[] strs)
    {   
        Map<String,List<String>> mpp = new HashMap<>();
        for(String st: strs)
        {
            char[] charArr = st.toCharArray();
            Arrays.sort(charArr);
            String chArr = new String(charArr);
            if(!mpp.containsKey(chArr))
            mpp.put(chArr,new ArrayList<>());
            mpp.get(chArr).add(st);
        }
        return new ArrayList<>(mpp.values());
    }
    public static void main(String[] args)
    {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat","tab","tub","but"};
        List<List<String>> ans = ga.groupAnagrams(strs);
        System.err.println(ans);
    }
}
