package Important;
import java.util.*;

public class PrimsAlgorithm extends Graphs implements Comparable<PrimsAlgorithm>
{

    /*
     * Here we'll do the following:
     * 1. Solve the minimum spanning tree problem using Prim's algorithm
     */

    // Here the Prims Algorithm class is of  Pair type and implements the Comparable interface

    int vertex;
    int weight;

    public PrimsAlgorithm(int vertex, int weight)
    {
        super(vertex);
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(PrimsAlgorithm that)
    {
        return this.weight - that.weight;
    }

    // Function implement the Prim's algorithm (using Priority Queue)
    public static void primsAlgorithm(Graphs graph)
    {
        int V = graph.V;

        // This array will store whether a vertex has been visited or not
        boolean[] visited = new boolean[V];

        // This is the array that will store the edges of the minimum spanning tree
        PrimsAlgorithm[] edge = new PrimsAlgorithm[V];

        // This array will store the parent of each vertex in the minimum spanning tree
        int[] parent = new int[V];

        /*
        *Initializing the array PrimsAlgorithm with the vertices and the weight (as infinity)
        *Initializing the parent array with -1
         */
        for (int i = 0; i < V; i++)
        {
            edge[i] = new PrimsAlgorithm(i, Integer.MAX_VALUE);
            parent[i] = -1;
        }

        // Setting the weight of the first vertex as 0
        edge[0].weight = 0;

        // Creating a priority queue
        PriorityQueue<PrimsAlgorithm> queue = new PriorityQueue<>();

        // Adding all the vertices to the priority queue
        for (int i = 0; i < V; i++)
        {
            queue.add(edge[i]);
        }

        // Implementing the Prim's algorithm
        while (!queue.isEmpty())
        {

            // Removing the vertex with the minimum weight
            PrimsAlgorithm curr = queue.poll();

            // Marking the vertex as visited
            visited[curr.vertex] = true;

            // Updating the weights of the adjacent vertices
            for (ArrayList<Integer> neighbour : graph.adjListWeighted.get(curr.vertex))
            {
                /*
                * Here neighbour is an ArrayList with the vertex and the weight of the edge
                * thus neighbour.get(0) gives the vertex and neighbour.get(1) gives the weight of the edge
                */

                // If the vertex has not been visited and the weight of the edge is less than the current weight
                if (!visited[neighbour.get(0)] && neighbour.get(1) < edge[neighbour.get(0)].weight)
                {

                    // Removing the vertex from the priority queue
                    queue.remove(edge[neighbour.get(0)]);

                    // Updating the weight of the vertex
                    edge[neighbour.get(0)].weight = neighbour.get(1);

                    // Adding the vertex back to the priority queue
                    queue.add(edge[neighbour.get(0)]);

                    // Updating the parent of the vertex
                    parent[neighbour.get(0)] = curr.vertex;
                }
            }
        }
        
        // Printing the paths along with the weights
        for (int i = 1; i < V; i++)
        {
            System.out.println(parent[i] + " - " + i + " : " + edge[i].weight);
        }

        // Printing the total weight of the minimum spanning tree
        int totalWeight = 0;
        for (int i = 0; i < V; i++)
        {
            totalWeight += edge[i].weight;
        }

        System.out.println("Total weight of the minimum spanning tree: " + totalWeight);
    }


    public static void main(String[] args)
    {
        Graphs graph = new Graphs(5);
        graph.addEdgeList(0, 1, 2);
        graph.addEdgeList(1, 0, 2);
        graph.addEdgeList(0, 4, 6);
        graph.addEdgeList(4, 0, 6);
        graph.addEdgeList(1, 2, 1);
        graph.addEdgeList(2, 1, 1);
        graph.addEdgeList(2, 3, 3);
        graph.addEdgeList(3, 2, 3);
        graph.addEdgeList(0, 3, 7);
        graph.addEdgeList(3, 0, 7);
        graph.addEdgeList(0, 4, 6);
        graph.addEdgeList(4, 0, 6);
        graph.addEdgeList(2, 4, 2);
        graph.addEdgeList(4, 2, 2);
        graph.addEdgeList(1, 4, 4);
        graph.addEdgeList(4, 1, 4);

        primsAlgorithm(graph);
    }

}
