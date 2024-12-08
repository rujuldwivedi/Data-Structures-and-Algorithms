import java.util.*;

public class TopologicalSorting extends Graphs
{

    /*
     * Here we'll do the following:
     * 1. Topologically sort a graph
     */

    public TopologicalSorting(int v)
    {
        super(v);
    }

    // Function to topologically sort a graph
    public static void topologicalSort(Graphs graph)
    {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.V];

        // The for loops and separate utility functions are made to handle disconnected graphs
        for (int i = 0; i < graph.V; i++)
        {
            if (!visited[i])
                topologicalSortUtil(graph, i, visited, stack);
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    // Utility function to topologically sort a graph
    public static void topologicalSortUtil(Graphs graph, int v, boolean[] visited, Stack<Integer> stack)
    {
        visited[v] = true;

        for (int i : graph.adjList[v])
        {
            if (!visited[i])
                topologicalSortUtil(graph, i, visited, stack);
        }

        stack.push(v);
    }

    /*
     * Another approach via Queues
    
    public static void topologicalSort(Graphs graph)
    {
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[graph.V];
        for (int i = 0; i < graph.V; i++)
        {
            for (int j : graph.adjList[i])
            {
                indegree[j]++;
            }
        }
        for (int i = 0; i < graph.V; i++)
        {
            if (indegree[i] == 0)
            queue.add(i);
        } 
        while (!queue.isEmpty())
        {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int i : graph.adjList[u])
            {
                indegree[i]--;
                if (indegree[i] == 0)
                queue.add(i);
            }
        }
    }
      
     */

    public static void main(String[] args)
    {
        Graphs graph = new Graphs(6);
        graph.addEdgeList(5, 2);
        graph.addEdgeList(5, 0);
        graph.addEdgeList(4, 0);
        graph.addEdgeList(4, 1);
        graph.addEdgeList(2, 3);
        graph.addEdgeList(3, 1);

        System.out.println("Topological Sort of the graph is: ");
        topologicalSort(graph);
    }

}
