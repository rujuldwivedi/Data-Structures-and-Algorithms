import java.util.*;
class BFSGraph
{
    public static boolean bfs(int size, int source, int destination, ArrayList<Integer> distance, ArrayList<Integer> predecessor, ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Boolean> visited = new ArrayList<>(size);
        for(int i = 0; i < size; i++)
        {
            visited.add(false);
            distance.add(Integer.MAX_VALUE);
            predecessor.add(-1);
        }
        visited.set(source, true);
        distance.set(source, 0);
        queue.add(source);
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            for(int neighbour : adj.get(curr))
            {
                if(!visited.get(neighbour))
                {
                    visited.set(neighbour, true);
                    distance.set(neighbour, distance.get(curr) + 1);
                    predecessor.set(neighbour, curr);
                    queue.add(neighbour);
                    if(neighbour == destination)
                    return true;
                }
            }
        }
        return false;
    }
    public static void printPath(ArrayList<Integer> predecessor, int source, int destination)
    {
        ArrayList<Integer> path = new ArrayList<>();
        int curr = destination;
        while(curr != source)
        {
            path.add(0, curr);
            curr = predecessor.get(curr);
        }
        path.add(0, source);
        System.out.println("Path: " + path);
    }
    public static void Graph(Scanner sc)
    {
        System.out.print("Enter the number of vertices: ");
        int size = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < size; i++)
        adj.add(new ArrayList<>());
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();
        System.out.println("Enter the edges: ");
        for(int i = 0; i < edges; i++)
        {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            adj.get(vertex1).add(vertex2);
            adj.get(vertex2).add(vertex1);
        }
        System.out.print("Enter the source vertex: ");
        int source = sc.nextInt();
        System.out.print("Enter the destination vertex: ");
        int destination = sc.nextInt();
        ArrayList<Integer> distance = new ArrayList<>();
        ArrayList<Integer> predecessor = new ArrayList<>();
        if(bfs(size, source, destination, distance, predecessor, adj))
        {
            System.out.println("Distance: " + distance.get(destination));
            printPath(predecessor, source, destination);
        }
        else
        System.out.println("No path exists");
        sc.close();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Graph(sc);
    }
}