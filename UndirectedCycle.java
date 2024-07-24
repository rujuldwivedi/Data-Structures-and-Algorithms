public class UndirectedCycle extends Graphs
{

    /*
     * Here we'll do the following:
     * 1. Detect a cycle in an undirected graph
     */

    public UndirectedCycle(int v)
    {
        super(v);
    }

    // Detect a cycle in an undirected graph
    public static boolean isCycle(Graphs graph)
    {
        // Create a boolean array to keep track of visited neighbours
        boolean[] visited = new boolean[graph.V];

        // We will call our main dfs function for each neighbour in the graph as there can be disconnected components
        for (int i = 0; i < graph.V; i++)
        {
            if (!visited[i])
            {
                if (isCycleUtil(graph, i, visited, -1))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCycleUtil(Graphs graph, int start, boolean[] visited, int parent)
    {
        // Mark the current neighbour as visited
        visited[start] = true;

        // Get all the neighbours connected to the current neighbour
        // If a connected neighbour has not been visited, mark it as visited and call the function recursively
        for (int neighbour : graph.adjList[start])
        {
            if (!visited[neighbour])
            {
                if (isCycleUtil(graph, neighbour, visited, start))
                {
                    return true;
                }
            }
            else if (neighbour != parent)
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        // Create a graph
        Graphs graph = new Graphs(5);

        // Add edges
        graph.addEdgeList(0, 1);
        graph.addEdgeList(1, 2);
        graph.addEdgeList(2, 3);
        graph.addEdgeList(3, 4);
        graph.addEdgeList(4, 0);

        // Check if the graph has a cycle
        if (isCycle(graph))
        {
            System.out.println("The graph has a cycle");
        }
        else
        {
            System.out.println("The graph doesn't have a cycle");
        }
    }
}
