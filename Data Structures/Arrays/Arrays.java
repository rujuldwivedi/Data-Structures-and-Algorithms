public class Arrays
{
    /*
     * Here we'll do the following:
     * 1. Majority Element
     * 2. Moore's Voting Algorithm
     */

    // Function to find the majority element by brute force
    public static int majorityElement(int[] nums)
    {
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            int count = 0;
            for (int j = 0; j < n; j++)
            {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count > n / 2)
                return nums[i];
        }
        return -1;
    }

    /*
     * The time complexity of the above algorithm is O(n^2)
     */

    // Function to implement Moore's Voting Algorithm
    public static int mooreVoting(int[] nums)
    {

        /*
         * The idea behind Moore's Voting Algorithm is to cancel out each occurrence of
         * an element e with all the other elements that are different from e. This way
         * if an element has a count > n/2, it will be the only element left in the end.
         */

        int count = 0, candidate = 0;
        for (int num : nums)
        {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    /*
     * The time complexity of the above algorithm is O(n)
     */

     /*
      * Here's a modified version of the above algorithm which also checks if the majority element
        * occurs more than n/3 times.

        * The idea is to maintain two candidates and two counts. We'll iterate through the array and
        * if the current element is equal to one of the candidates, we'll increment the count of that
        * candidate. If the current element is not equal to any of the candidates, we'll decrement the
        * count of both the candidates. If the count of any candidate becomes 0, we'll update the candidate
        * with the current element. In the end, we'll check if the count of both the candidates is greater
        * than n/3. If yes, we'll add the candidate to the result.

        * The time complexity of the below algorithm is O(n) and the space complexity is O(1).

        * The code is as follows:

        public List<Integer> majorityElement(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
            for (int num : nums) {
                if (num == candidate1)
                    count1++;
                else if (num == candidate2)
                    count2++;
                else if (count1 == 0) {
                    candidate1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
            count1 = 0;
            count2 = 0;
            for (int num : nums) {
                if (num == candidate1)
                    count1++;
                else if (num == candidate2)
                    count2++;
            }
            if (count1 > nums.length / 3)
                result.add(candidate1);
            if (count2 > nums.length / 3)
                result.add(candidate2);
            return result;
        }
      */

    public static void main(String[] args)
    {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));
        System.out.println(mooreVoting(nums));
    }

    public static Object asList(int dest, int weight) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asList'");
    }
}