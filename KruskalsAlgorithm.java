import java.util.*;

public class KruskalsAlgorithm extends Graphs
{

    /*
     * Here we'll do the following:
     * 1. Implement the Kruskal's Algorithm
     */

    KruskalsAlgorithm(int vertices)
    {
        super(vertices);
    }

    // Implementing Kruskal's Algorithm
    public void kruskalAlgorithm()
    {
        int V = this.V;
        List<Edge> edges = new ArrayList<>();

        // Collect all edges from the weighted adjacency list
        for (int currVertex = 0; currVertex < V; currVertex++)
        {
            for (ArrayList<Integer> neighbor : adjListWeighted.get(currVertex))
            {
                int vertex = neighbor.get(0);
                int weight = neighbor.get(1);
                if (currVertex < vertex)
                {
                     // To ensure each edge is added only once
                    edges.add(new Edge(currVertex, vertex, weight));
                }
            }
        }

        // Sort edges based on weight
        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        // Initialize Union-Find
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }

        // Kruskal's Algorithm
        List<Edge> list = new ArrayList<>();
        int listWeight = 0;

        for (Edge edge : edges)
        {
            int src = edge.u;
            int dest = edge.v;

            if (UnionFindAlgorithm.find(parent, src) != UnionFindAlgorithm.find(parent, dest))
            {
                UnionFindAlgorithm.unionByRank(parent, rank, src, dest);
                list.add(edge);
                listWeight += edge.weight;
            }
        }

        // Print the list edges and their weights
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : list) 
        {
            System.out.println(edge.u + " - " + edge.v + " : " + edge.weight);
        }
        System.out.println("Total weight of the Minimum Spanning Tree: " + listWeight);
    }

    public static void main(String[] args)
    {
        // Create a graph
        KruskalsAlgorithm graph = new KruskalsAlgorithm(5);

        // Add weighted edges to the graph
        graph.addEdgeList(0, 1, 10);
        graph.addEdgeList(0, 2, 6);
        graph.addEdgeList(0, 3, 5);
        graph.addEdgeList(1, 3, 15);
        graph.addEdgeList(2, 3, 4);
        graph.addEdgeList(1, 2, 7);
        graph.addEdgeList(3, 4, 8);
        graph.addEdgeList(4, 1, 9);

        // Run Kruskal's Algorithm
        graph.kruskalAlgorithm();
    }
     
}
