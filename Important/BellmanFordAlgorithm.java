package Important;
import java.util.*;

public class BellmanFordAlgorithm extends Graphs implements Comparable<BellmanFordAlgorithm>
{

    /*
     * Here we'll do the following:
     * 1. Implement the Bellman Ford Algorithm
     */

    int vertex;
    int weight;

    public BellmanFordAlgorithm(int vertex, int weight)
    {
        super(vertex);
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(BellmanFordAlgorithm that)
    {
        return this.weight - that.weight;
    }

    // Implementing the Bellman Ford Algorithm
    public static ArrayList<Integer> bellmanFordAlgorithm(Graphs graph, int source)
    {

        // Get the number of vertices in the graph
        int V = graph.V;

        // Initialize the distance array
        int[] dist = new int[V];
        
        // Initialize the distance array with infinity
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }

        // Set the distance of the source vertex as 0
        dist[source] = 0;

        // Perform Dijkstra Algorithm for V-1 iterations
        for (int i = 1; i < V; i++)
        {

            // Iterate over all edges
            for (int currVertex = 0; currVertex < V; currVertex++)
            {
                
                // Iterate over all neighbors of the current vertex
                for (ArrayList<Integer> neighbor : graph.adjListWeighted.get(currVertex))
                {

                    // Get the neighbor and the weight of the edge
                    int vertex = neighbor.get(0);

                    // Get the weight of the edge
                    int weight = neighbor.get(1);

                    // Relax the edge
                    if (dist[currVertex] != Integer.MAX_VALUE && dist[currVertex] + weight < dist[vertex])
                    {
                        dist[vertex] = dist[currVertex] + weight;
                    }
                }
            }
        }

        // Check for negative-weight cycles
        for (int currVertex = 0; currVertex < V; currVertex++)
        {

            // Iterate over all neighbors of the current vertex
            for (ArrayList<Integer> neighbor : graph.adjListWeighted.get(currVertex))
            {

                // Get the neighbor vertex of the edge
                int vertex = neighbor.get(0);

                // Get the neighbor weight of the edge
                int weight = neighbor.get(1);

                // If the distance is not infinity and the new distance is shorter than the current distance then there is a negative weight cycle
                if (dist[currVertex] != Integer.MAX_VALUE && dist[currVertex] + weight < dist[vertex])
                {

                    // Throw Exception
                    throw new IllegalArgumentException("Graph contains a negative weight cycle");
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
        // Create a graph
        Graphs graph = new Graphs(4);

        // Add edges to the graph
        graph.addEdgeList(0, 1, 3);
        graph.addEdgeList(0, 2, 1);
        graph.addEdgeList(1, 2, -8);
        graph.addEdgeList(3, 1, 4);
        graph.addEdgeList(2, 3, 2);

        // Run the Bellman Ford Algorithm
        ArrayList<Integer> result = bellmanFordAlgorithm(graph, 0);

        // Print the result
        for (int i = 0; i < result.size(); i++)
        {
            System.out.println("Vertex " + i + " is at distance " + result.get(i));
        }
    }
}
