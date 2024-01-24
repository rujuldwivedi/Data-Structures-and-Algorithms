class AdjacencyMatrix
{
    int[][] matrix;
    int size;
    AdjacencyMatrix(int size)
    {
        this.size = size;
        matrix = new int[size][size];
    }
    void addEdge(int from, int to)
    {
        matrix[from][to] = 1;
    }
    void removeEdge(int from, int to)
    {
        matrix[from][to] = 0;
    }
    boolean hasEdge(int from, int to)
    {
        return matrix[from][to] == 1;
    }
    void print()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print(i + ": ");
            for (int j = 0; j < size; j++)
            {
                if (matrix[i][j] == 1)
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        AdjacencyMatrix graph = new AdjacencyMatrix(5);
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