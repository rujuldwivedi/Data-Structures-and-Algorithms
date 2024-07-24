public class DirectedCycle extends Graphs
{

    /*
     * Here we'll do the following:
     * 1. Detect a cycle in a directed graph
     */

    public DirectedCycle(int v)
    {
        super(v);
    }

    // Function to detect a cycle in a directed graph
    public static boolean hasCycle(Graphs graph)
    {
        boolean[] visited = new boolean[graph.V];
        boolean[] recStack = new boolean[graph.V];

        for (int i = 0; i < graph.V; i++)
        {
            if (isCyclicUtil(graph, i, visited, recStack))
                return true;
        }

        return false;
    }

    public static boolean isCyclicUtil(Graphs graph, int start, boolean[] visited, boolean[] recStack)
    {

        visited[start] = true;
        recStack[start] = true;

        for (int neighbour : graph.adjList[start])
        {
            if (!visited[neighbour] && isCyclicUtil(graph, neighbour, visited, recStack))
                return true;
            else if (recStack[neighbour])
                return true;
        }

        recStack[start] = false;

        return false;
    }

    public static void main(String[] args)
    {
        // Create a graph
        Graphs graph = new Graphs(4);

        // Add edges
        graph.addEdgeList(0, 1);
        graph.addEdgeList(0, 2);
        graph.addEdgeList(1, 2);
        graph.addEdgeList(2, 0);
        graph.addEdgeList(2, 3);
        graph.addEdgeList(3, 3);

        // Check if the graph has a cycle
        if (hasCycle(graph))
        {
            System.out.println("The graph has a cycle");
        }
        else
        {
            System.out.println("The graph doesn't has a cycle");
        }
    }
}
