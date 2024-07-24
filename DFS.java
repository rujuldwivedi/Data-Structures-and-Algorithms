import java.util.*;

public class DFS extends Graphs
{

    /*
     * Here we'll do the following:
     * 1. Perform DFS on a graph
     * 2. Find the number of connected components in a graph
     * 3. Find the minimum distance from a source node to a destination node
     */

    public DFS(int v)
    {
        super(v);
    }

    // Perform DFS on a graph
    public static void dfs(Graphs graph, int start, int end)
    {
        // Create a boolean array to keep track of visited nodes
        boolean[] visited = new boolean[graph.V];

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();

        // Mark the current node as visited and push it to the stack
        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty())
        {
            // Pop a node from the stack and print it
            start = stack.pop();
            System.out.print(start + " ");

            // Get all the nodes connected to the current node
            // If a connected node has not been visited, mark it as visited and push it to the stack
            for (int node : graph.adjList[start])
            {
                if (!visited[node])
                {
                    visited[node] = true;
                    stack.push(node);
                }
            }
        }
    }

    // Find the number of connected components in a graph
    public static int connectedComponents(Graphs graph)
    {
        // Create a boolean array to keep track of visited nodes
        boolean[] visited = new boolean[graph.V];

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();

        int count = 0;

        for (int i = 0; i < graph.V; i++)
        {
            if (!visited[i])
            {
                visited[i] = true;
                stack.push(i);
                count++;

                while (!stack.isEmpty())
                {
                    int start = stack.pop();

                    for (int node : graph.adjList[start])
                    {
                        if (!visited[node])
                        {
                            visited[node] = true;
                            stack.push(node);
                        }
                    }
                }
            }
        }

        return count;
    }

    // Find the minimum distance from a source node to a destination node
    public static int minDistance(Graphs graph, int start, int end)
    {
        // Create a boolean array to keep track of visited nodes
        boolean[] visited = new boolean[graph.V];

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();

        // Create an array to store the distance of each node from the source node
        int[] distance = new int[graph.V];

        // Mark the current node as visited and push it to the stack
        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty())
        {
            // Pop a node from the stack
            start = stack.pop();

            // Get all the nodes connected to the current node
            // If a connected node has not been visited, mark it as visited, push it to the stack and update its distance
            for (int node : graph.adjList[start])
            {
                if (!visited[node])
                {
                    visited[node] = true;
                    stack.push(node);
                    distance[node] = distance[start] + 1;
                }
            }
        }

        return distance[end];
    }

    public static void main(String[] args)
    {
        // Create a graph
        int vertices = 6;
        Graphs graph = new Graphs(vertices);

        // Add edges to the graph
        graph.addEdgeList(0, 1);
        graph.addEdgeList(0, 2);
        graph.addEdgeList(1, 4);
        graph.addEdgeList(2, 3);
        graph.addEdgeList(3, 4);
        graph.addEdgeList(4, 5);
        graph.addEdgeList(3, 5);
        graph.addEdgeList(0, 4);

        // Perform DFS on the graph
        System.out.println("DFS traversal of the graph:");
        dfs(graph, 0, 4);
        System.out.println();

        // Find the number of connected components in the graph
        System.out.println("Number of connected components in the graph: " + connectedComponents(graph));

        // Find the minimum distance from a source node to a destination node
        System.out.println("Minimum distance from source to destination: " + minDistance(graph, 0, 5));
    }
}
