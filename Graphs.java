import java.util.*;

public class Graphs
{
    int V; // Number of vertices
    LinkedList<Integer>[] adjList; // Adjacency list
    int[][] adjMatrix; // Adjacency matrix
    ArrayList<ArrayList<ArrayList<Integer>>> adjListWeighted; // Adjacency list with weights

    // Constructor to initialize the graph
    @SuppressWarnings("unchecked")
    public Graphs(int v)
    {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++)
        {
            adjList[i] = new LinkedList<>();
        }
        adjMatrix = new int[v][v];
        adjListWeighted = new ArrayList<>();
        for (int i = 0; i < v; i++)
        {
            adjListWeighted.add(new ArrayList<>());
        }
    }

    // Implementing a graph using adjacency list
    public void addEdgeList(int src, int dest)
    {
        adjList[src].add(dest);
        // adjList[dest].add(src); Only for undirected graphs
    }

    public void printGraphList()
    {
        // Printing the nodes connected to each node in the adjacency list
        for (int i = 0; i < V; i++)
        {
            System.out.print(i + " -> ");
            for (int node : adjList[i])
            {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    // Adding weights to the edges
    public void addEdgeList(int src, int dest, int weight)
    {
        ArrayList<Integer> node = new ArrayList<>();
        node.add(dest);
        node.add(weight);
        adjListWeighted.get(src).add(node);
        // adjListWeighted.get(dest).add(new ArrayList<>(Arrays.asList(src, weight))); Only for undirected graphs
    }

    // Printing the adjacency list with weights
    public void printGraphListWeighted()
    {
        for (int i = 0; i < V; i++)
        {
            System.out.print(i + " -> ");
            for (ArrayList<Integer> node : adjListWeighted.get(i))
            {
                System.out.print(node.get(0) + " (" + node.get(1) + ") ");
            }
            System.out.println();
        }
    }

    // Implementing a graph using adjacency matrix
    public void addEdgeMatrix(int src, int dest)
    {
        adjMatrix[src][dest] = 1;
        // adjMatrix[dest][src] = 1; Only for undirected graphs
    }

    public void printGraphMatrix()
    {
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Graphs graph = new Graphs(5);

        // Adding edges to the adjacency list
        graph.addEdgeList(0, 1);
        graph.addEdgeList(0, 4);
        graph.addEdgeList(1, 2);
        graph.addEdgeList(1, 3);
        graph.addEdgeList(1, 4);
        graph.addEdgeList(2, 3);
        graph.addEdgeList(3, 4);

        // Printing the adjacency list
        graph.printGraphList();

        // Adding edges to the adjacency matrix
        graph.addEdgeMatrix(0, 1);
        graph.addEdgeMatrix(0, 4);
        graph.addEdgeMatrix(1, 2);
        graph.addEdgeMatrix(1, 3);
        graph.addEdgeMatrix(1, 4);
        graph.addEdgeMatrix(2, 3);
        graph.addEdgeMatrix(3, 4);

        // Printing the adjacency matrix
        graph.printGraphMatrix();

        // Adding weights to the edges
        graph.adjListWeighted = new ArrayList<>();
        for (int i = 0; i < graph.V; i++)
        {
            graph.adjListWeighted.add(new ArrayList<>());
        }

        graph.addEdgeList(0, 1, 2);
        graph.addEdgeList(0, 4, 6);
        graph.addEdgeList(1, 2, 1);
        graph.addEdgeList(1, 3, 3);
        graph.addEdgeList(1, 4, 4);
        graph.addEdgeList(2, 3, 3);
        graph.addEdgeList(3, 4, 2);

        // Printing the adjacency list with weights
        graph.printGraphListWeighted();
    }
}
