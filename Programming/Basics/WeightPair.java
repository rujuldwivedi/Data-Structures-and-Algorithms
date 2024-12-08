public class WeightPair implements Comparable<WeightPair>
{
    int vertex;
    int weight;

    public WeightPair(int vertex, int weight)
    {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightPair that)
    {
        return this.weight - that.weight;
    }

    public static void main(String[] args)
    {
        System.out.println();
    }
}
