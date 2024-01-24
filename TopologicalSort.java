import java.util.*;
class TopologicalSort
{
    private static ArrayList<ArrayList<Integer>> adj;
    public static void helper(int vertex, ArrayList<Boolean> visited, Stack<Integer> stack)
    {
        visited.set(vertex, true);
        for(int neighbor : adj.get(vertex))
        {
            if(!visited.get(neighbor))
            helper(neighbor, visited, stack);
        }
        stack.push(vertex);
    }
    public static void topologicalSort(int vertices)
    {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Boolean> visited = new ArrayList<>(vertices);
        for(int i = 0; i < vertices; i++)
        visited.add(false);
        for(int i = 0; i < vertices; i++)
        {
            if(!visited.get(i))
            helper(i, visited, stack);
        }
        while(!stack.empty())
        System.out.print(stack.pop() + " ");
    }
    public static void Graph(Scanner sc)
    {
        System.out.println("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int edges = sc.nextInt();
        adj = new ArrayList<>(vertices);
        for(int i = 0; i < vertices; i++)
        adj.add(new ArrayList<>());
        System.out.println("Enter the edges: ");
        for(int i=0;i<edges;i++)
        {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            adj.get(vertex1).add(vertex2);
        }
        System.out.println("Following is a Topological " + "sort of the given graph");
        topologicalSort(vertices);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Graph(sc);
        sc.close();
    }
}
