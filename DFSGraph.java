import java.util.*;
public class DFSGraph
{
    public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static void dfs(ArrayList<Boolean> visited, int vertex)
    {
        visited.set(vertex, true);
        System.out.print(vertex+" ");
        for(int neighbour : adj.get(vertex))
        {
            if(!visited.get(neighbour))
            dfs(visited,neighbour);
        }
    }
    public static void printPath(int vertices, int source, int destination, ArrayList<Boolean> visited)
    {
        dfs(visited, source);
        System.out.println();
        if(visited.get(destination))
        System.out.println("Path exists from "+source+" to "+destination);
        else
        System.out.println("No path exists from "+source+" to "+destination);
    }
    public static void Graph(Scanner sc)
    {
        System.out.println("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        ArrayList<Boolean> visited = new ArrayList<>();
        for(int i=0;i<vertices;i++)
        {
            visited.add(false);
            adj.add(new ArrayList<Integer>());
        }
        System.out.println("Enter the number of edges: ");
        int edges = sc.nextInt();
        System.out.println("Enter the edges: ");
        for(int i=0;i<edges;i++)
        {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            adj.get(vertex1).add(vertex2);
            adj.get(vertex2).add(vertex1);
        }
        System.out.println("Enter the source: ");
        int source = sc.nextInt();
        System.out.println("Enter the destination: ");
        int destination = sc.nextInt();
        printPath(vertices, source, destination, visited);
        sc.close();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Graph(sc);
    }
}