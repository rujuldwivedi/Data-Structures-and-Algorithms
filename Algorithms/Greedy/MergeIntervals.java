import java.util.LinkedList;
public class MergeIntervals
{
    public static int[][] merge(int[][] intervals)
    {
        int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < intervals.length; i++)
        {
			min = Math.min(min, intervals[i][0]);
			max = Math.max(max, intervals[i][0]);
		}
		int[] range = new int[max-min+1];
		for (int i = 0; i < intervals.length; i++)
        range[intervals[i][0]-min] = Math.max(intervals[i][1]-min,range[intervals[i][0]-min]);
		int start = 0;
        int end = 0;
		LinkedList<int[]> result = new LinkedList<>();
		for (int i = 0; i < range.length; i++)
        {
			if (range[i] == 0)
            continue;
			if (i <= end)
            end = Math.max(range[i], end);
            else
            {
				result.add(new int[] {start + min, end + min});
				start = i;
				end = range[i];
			}
		}
		result.add(new int[] {start + min, end + min});
		return result.toArray(new int[result.size()][]);
    }    
    public static void main(String args[])
    {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for(int i=0;i<res.length;i++)
        {
            for(int j=0;j<res[i].length;j++)
            System.out.print(res[i][j] + " ");
            System.out.println();
        }
    }
}
