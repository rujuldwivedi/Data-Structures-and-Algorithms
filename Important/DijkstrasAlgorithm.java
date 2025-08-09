package Important;
import java.util.*;

public class DijkstrasAlgorithm extends Graphs implements Comparable<DijkstrasAlgorithm>
{

    /*
     * Here we'll do the following:
     * 1. Implement the Dijkstra's Algorithm
     */

    int vertex;
    int weight;
    
    public DijkstrasAlgorithm(int vertex, int weight)
    {
        super(vertex);
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(DijkstrasAlgorithm that)
    {
        return this.weight - that.weight;
    }
    
    // Implementing the Dijkstra's Algorithm
    public static ArrayList<Integer> dijsktrasAlgorithm(Graphs graph, int source)
    {

        // Get the number of vertices in the graph
        int V = graph.V;

        // Initialize the distance array, visited array and the priority queue
        int[] dist = new int[V];

        // This array will store whether a vertex has been visited or not
        boolean[] visited = new boolean[V];

        // Creating a priority queue of class DijkstrasAlgorithm (similar to Pair type) which stores the vertex and the weight
        PriorityQueue<DijkstrasAlgorithm> queue = new PriorityQueue<>();

        // Initialize distances with infinity
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }

        // Set the distance of the source vertex as 0
        dist[source] = 0;

        // Create a priority queue and add the source vertex
        queue.add(new DijkstrasAlgorithm(source, 0));

        while (!queue.isEmpty())
        {
            // Extract the vertex with the minimum distance
            DijkstrasAlgorithm curr = queue.poll();

            // Get the current vertex
            int currVertex = curr.vertex;

            // If the vertex is already visited, skip it
            if (visited[currVertex])
                continue;

            // Mark the vertex as visited
            visited[currVertex] = true;

            // Update the distance for each adjacent vertex
            for (ArrayList<Integer> neighbor : graph.adjListWeighted.get(currVertex))
            {

                // Get the adjacent vertex of the edge
                int vertex = neighbor.get(0);

                // Get the adjacent weight of the edge
                int weight = neighbor.get(1);

                // If the vertex has not been visited and the new distance is shorter
                if (!visited[vertex] && dist[currVertex] + weight < dist[vertex])
                {

                    // Update the distance of the vertex
                    dist[vertex] = dist[currVertex] + weight;

                    // Add the vertex to the priority queue
                    queue.add(new DijkstrasAlgorithm(vertex, dist[vertex]));
                }
            }
        }

        // Convert the distance array to ArrayList for return
        ArrayList<Integer> distances = new ArrayList<>();
        for (int distance : dist)
        {
            distances.add(distance);
        }

        return distances;
    }

    public static void main(String[] args)
    {
        // Creating a graph
        Graphs graph = new Graphs(6);
        
        // Adding edges to the graph
        graph.addEdgeList(0, 2, 4);
        graph.addEdgeList(0, 3, 2);
        graph.addEdgeList(2, 0, 4);
        graph.addEdgeList(3, 0, 2);
        graph.addEdgeList(1, 2, 9);
        graph.addEdgeList(1, 4, 1);
        graph.addEdgeList(2, 1, 9);
        graph.addEdgeList(4, 1, 1);
        graph.addEdgeList(2, 3, 3);
        graph.addEdgeList(2, 5, 1);
        graph.addEdgeList(3, 2, 3);
        graph.addEdgeList(5, 2, 1);
        graph.addEdgeList(3, 5, 1);
        graph.addEdgeList(5, 3, 1);
        graph.addEdgeList(4, 5, 2);
        graph.addEdgeList(5, 4, 2);
        
        // Calling the Dijkstra's Algorithm function
        ArrayList<Integer> path = dijsktrasAlgorithm(graph, 0);
        
        // Printing the path along with the vertices
        for (int i = 0; i < path.size(); i++)
        {
            System.out.println("0 - " + i + " : " + path.get(i));
        }
    }
}
