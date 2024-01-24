import java.util.*;
class MST
{
    public static ArrayList<ArrayList<Integer>> adj;
    public static ArrayList<Integer> weights;
    public static void PrimsAlgo(int vertices, ArrayList<Boolean> visited)
    {
        PriorityQueue<ArrayList<Integer>> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.get(2), b.get(2)));
        int vertex = 0;
        visited.set(vertex, true);
        for(int neighbour : adj.get(vertex))
        {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(vertex);
            edge.add(neighbour);
            edge.add(weights.get(neighbour));
            priorityQueue.add(edge);
        }
        while(!priorityQueue.isEmpty())
        {
            ArrayList<Integer> edge = priorityQueue.poll();
            int curr = edge.get(1);
            if(!visited.get(curr))
            {
                System.out.println("Edge: " + edge.get(0) + " - " + curr + " Weight: " + edge.get(2));
                visited.set(curr, true);
                for(int neighbour : adj.get(curr))
                {
                    if(!visited.get(neighbour))
                    {
                        ArrayList<Integer> neighbourEdge = new ArrayList<>();
                        neighbourEdge.add(curr);
                        neighbourEdge.add(neighbour);
                        neighbourEdge.add(weights.get(neighbour));
                        priorityQueue.add(neighbourEdge);
                    }
                }
            }
        }
    }
    public static void Graph(Scanner sc)
    {
        System.out.println("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int edges = sc.nextInt();
        adj = new ArrayList<>(vertices + 1);
        weights = new ArrayList<>();
        for(int i = 0; i <= vertices; i++)
        adj.add(new ArrayList<>());
        ArrayList<Boolean> visited = new ArrayList<>();
        for(int i = 0; i < vertices; i++)
        visited.add(false);
        System.out.println("Enter the edges and weights: ");
        for(int i = 0; i < edges; i++)
        {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            adj.get(source).add(destination);
            adj.get(destination).add(source);
            weights.add(weight);
        }
        System.out.println("Minimum Spanning Tree:");
        PrimsAlgo(vertices, visited);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Graph(sc);
        sc.close();
    }
}