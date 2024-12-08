import java.util.*;

public class KahnsAlgorithm extends Graphs
{

    /*
     * Here we'll dot he following:
     * 1. Topologically sort the graph using Kahns Algorithm
     */

    KahnsAlgorithm(int V)
    {
        super(V);
    }

    // Function to perform Kahns Algorithm
    public static void kahnAlgo(Graphs graph, int[] inDegree, ArrayList<Integer> ans)
    {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < graph.V; i++)
        {
            if(inDegree[i] == 0)
            {
                queue.add(i);
            }
        }

        while(!queue.isEmpty())
        {
            int node = queue.poll();
            ans.add(node);

            for(int neighbour : graph.adjList[node])
            {
                if(--inDegree[neighbour] == 0)
                {
                    queue.add(neighbour);
                }
            }
        }

    }

    public static void topologicalSort(Graphs graph)
    {
        int[] inDegree = new int[graph.V];

        for(int i = 0; i < graph.V; i++)
        {
            for(int neighbour : graph.adjList[i])
            {
                inDegree[neighbour]++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        kahnAlgo(graph, inDegree, ans);

        for(int i : ans)
        {
            System.out.print(i + " ");
        }
    }
     
        public static void main(String[] args)
        {
            // Create a graph
            Graphs graph = new Graphs(6);
    
            // Add edges to the graph
            graph.addEdgeList(5, 2);
            graph.addEdgeList(5, 0);
            graph.addEdgeList(4, 0);
            graph.addEdgeList(4, 1);
            graph.addEdgeList(2, 3);
            graph.addEdgeList(3, 1);
    
            // Print the topological order of the graph
            topologicalSort(graph);
        }
}
