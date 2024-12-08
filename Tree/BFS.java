import java.util.*;

public class BFS extends Graphs
{

    /*
     * Here we'll be doing the following:
     * 1. Perform BFS on a graph
     * 2. Find the minimum distance from a source node to a destination node
     * 3. Find the number of connected components in a graph
     */

    public BFS(int v)
    {
        super(v);
    }

    /*
     * Sample function:
     
    public static boolean bfs(ArrayList<ArrayList<Integer>> adjList, int start, int end, int v, int[] pred, int[] dist)
    {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        for(int i = 0; i < v; i++)
        {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        visited[start] = true;
        dist[start] = 0;
        queue.add(start);
        while (!queue.isEmpty())
        {
            int u = queue.poll();
            for (int i = 0; i < adjList.get(u).size(); i++)
            {
                int v = adjList.get(u).get(i);
                if (!visited[v])
                {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    pred[v] = u;
                    queue.add(v);
                    if (v == end)
                    return true;
                }
            }
        }
    }

    */

    /*
    * See that the pred[] after backtracking will give the path from start to end
    * And dist[] will give the minimum distance from start to end
     */

    // Perform BFS on a graph
    public static void bfs(Graphs graph, int start, int end)
    {
        // Create a boolean array to keep track of visited nodes
        boolean[] visited = new boolean[graph.V];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0)
        {
            // Dequeue a node from the queue and print it
            start = queue.poll();
            System.out.print(start + " ");

            // Get all the nodes connected to the current node
            // If a connected node has not been visited, mark it as visited and enqueue it
            for (int node : graph.adjList[start])
            {
                if (!visited[node])
                {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }

    // Find the minimum distance from a source node to a destination node
    public static int minDistance(Graphs graph, int start, int end)
    {
        // Create a boolean array to keep track of visited nodes
        boolean[] visited = new boolean[graph.V];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Create an array to store the distance of each node from the source node
        int[] distance = new int[graph.V];

        // Mark the current node as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0)
        {
            // Dequeue a node from the queue
            start = queue.poll();

            // Get all the nodes connected to the current node
            // If a connected node has not been visited, mark it as visited, enqueue it and update its distance
            for (int node : graph.adjList[start])
            {
                if (!visited[node])
                {
                    visited[node] = true;
                    queue.add(node);
                    distance[node] = distance[start] + 1;
                }
            }
        }

        return distance[end];
    }

    // Find the number of connected components in a graph
    public static int connectedComponents(Graphs graph)
    {
        // Create a boolean array to keep track of visited nodes
        boolean[] visited = new boolean[graph.V];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the number of connected components to 0
        int components = 0;

        for (int i = 0; i < graph.V; i++)
        {
            if (!visited[i])
            {
                // Mark the current node as visited and enqueue it
                visited[i] = true;
                queue.add(i);

                while (queue.size() != 0)
                {
                    // Dequeue a node from the queue
                    int start = queue.poll();

                    // Get all the nodes connected to the current node
                    // If a connected node has not been visited, mark it as visited and enqueue it
                    for (int node : graph.adjList[start])
                    {
                        if (!visited[node])
                        {
                            visited[node] = true;
                            queue.add(node);
                        }
                    }
                }

                // Increment the number of connected components
                components++;
            }
        }

        return components;
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

        // Perform BFS on the graph
        System.out.println("BFS traversal of the graph:");
        bfs(graph, 0, 5);
        System.out.println();

        // Find the minimum distance from node 0 to node 5
        System.out.println("Minimum distance from node 0 to node 5: " + minDistance(graph, 0, 5));

        // Find the number of connected components in the graph
        System.out.println("Number of connected components in the graph: " + connectedComponents(graph));
    }

}