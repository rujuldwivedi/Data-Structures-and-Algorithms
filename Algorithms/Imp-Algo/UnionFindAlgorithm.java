public class UnionFindAlgorithm
{

    /*
     * Here we'll do the following:
     * 1. Implement the Union Find Algorithm to solve 'makeFriends' and 'areFriends' problems.
     */

     /*
      * Sample code :

        public static int findparent(Map<Integer, Integer> parent, int x)
        {
            if (parent.get(x) == x)
            {
                return x;
            }

            return findparent(parent, parent.get(x));
        }
        public static void makeFriends(List<List<Integer>> friendships, int x, int y)
        {
            Map<Integer, Integer> parent = new HashMap<>();
            for (List<Integer> friendship : friendships)
            {
                parent.put(friendship.get(0), friendship.get(0));
                parent.put(friendship.get(1), friendship.get(1));
            }
            int parentX = findparent(parent, x);
            int parentY = findparent(parent, y);
            parent.put(parentX, parentY);
        }
        public static boolean areFriends(List<List<Integer>> friendships, int x, int y)
        {
            Map<Integer, Integer> parent = new HashMap<>();
            for (List<Integer> friendship : friendships)
            {
                parent.put(friendship.get(0), friendship.get(0));
                parent.put(friendship.get(1), friendship.get(1));
            }
            int parentX = findparent(parent, x);
            int parentY = findparent(parent, y);
            return parentX == parentY;
        }

      */

    // Find operation with path compression
    public static int find(int[] parent, int i)
    {

        // If the parent of the vertex is the vertex itself, then return the vertex
        if (parent[i] == i)
        {
            return i;
        }

        // Otherwise, recursively find the parent of the vertex
        parent[i] = find(parent, parent[i]); // Path compression
        return parent[i]; // Return the parent of the vertex
    }

    // Union operation by rank
    public static void unionByRank(int[] parent, int[] rank, int x, int y)
    {

        // parent of the one of the two vertices
        int xSet = find(parent, x);

        // parent of the other vertex
        int ySet = find(parent, y);

        // If the parents of the two vertices are the same, then return as they are already friends
        if (xSet != ySet)
        {

            // If the rank of the parent of the first vertex is less than the rank of the parent of the second vertex then make the parent of the first vertex the parent of the second vertex
            if (rank[xSet] < rank[ySet])
            {
                parent[xSet] = ySet;
            }

            // If the rank of the parent of the second vertex is less than the rank of the parent of the first vertex then make the parent of the second vertex the parent of the first vertex
            else if (rank[xSet] > rank[ySet])
            {
                parent[ySet] = xSet;
            }

            // If the ranks of the parents of the two vertices are the same, then make one of the parents the parent of the other vertex and increment the rank of the parent
            else
            {
                parent[ySet] = xSet;
                rank[xSet]++;
            }
        }
    }

    // Find the disjoint sets
    public static void findDisjointSets(int[] parent)
    {

        // Print the parent of each vertex
        for (int i = 0; i < parent.length; i++)
        {
            System.out.println("Vertex: " + i + " parent: " + find(parent, i));
        }
    }

    // Implementing the makeFriends method
    public static void makeFriends(int[] parent, int[] rank, int x, int y)
    {
        unionByRank(parent, rank, x, y);
    }

    // Implementing the areFriends method
    public static boolean areFriends(int[] parent, int x, int y)
    {
        return find(parent, x) == find(parent, y);
    }

    public static void main(String[] args)
    {
        int n = 8;
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }

        makeFriends(parent, rank, 0, 1);
        makeFriends(parent, rank, 2, 7);
        makeFriends(parent, rank, 3, 6);

        System.out.println(areFriends(parent, 0, 2));

        makeFriends(parent, rank, 0, 7);

        System.out.println(areFriends(parent, 0, 2));
    }
}
