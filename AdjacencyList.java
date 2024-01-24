import java.util.*;
public class AdjacencyList
{
    int size;
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    AdjacencyList(int size)
    {
        this.size = size;
        for(int i = 0; i < size; i++)
        list.add(new ArrayList<Integer>());
    }
    void addEdge(int from, int to)
    {
        list.get(from).add(to);
    }
    void removeEdge(int from, int to)
    {
        list.get(from).remove((Integer)to);
    }
    boolean hasEdge(int from, int to)
    {
        return list.get(from).contains(to);
    }
    void print()
    {
        for(int i = 0; i < size; i++)
        {
            System.out.print(i + ": ");
            for(int j = 0; j < list.get(i).size(); j++)
            System.out.print(list.get(i).get(j) + " ");
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        AdjacencyList graph = new AdjacencyList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.removeEdge(1, 4);
        graph.print();
        System.out.println(graph.hasEdge(1, 4));
        System.out.println(graph.hasEdge(1, 3));
    }
}
