public class MaximumXOR
{

    /*
     * Here we'll do the following:
     * 1. Solve the Maximum XOR problem using a Trie.
     */

     // Function to find the maximum XOR value
    public int findMaximumXOR(int[] nums)
    {
        // Create a new Trie
        Trie root = new Trie();
        int max = 0;

        // Insert all the numbers in the Trie
        for (int num : nums)
        {
            Trie node = root;
            Trie xorNode = root;
            int value = 0;

            for (int i = 31; i >= 0; i--)
            {
                int bit = (num >> i) & 1;

                if (node.children[bit] == null)
                {
                    node.children[bit] = new Trie();
                }

                node = node.children[bit];

                int xorBit = bit == 0 ? 1 : 0;

                if (xorNode.children[xorBit] != null)
                {
                    value = value | (1 << i);
                    xorNode = xorNode.children[xorBit];
                }
                else
                {
                    xorNode = xorNode.children[bit];
                }
            }

            max = Math.max(max, value);
        }

        return max;
    }

    public static void main(String[] args)
    {
        MaximumXOR maximumXOR = new MaximumXOR();
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(maximumXOR.findMaximumXOR(nums));
    }
}
