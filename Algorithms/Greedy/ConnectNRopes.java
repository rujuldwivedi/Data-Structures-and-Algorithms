import java.util.*;

public class ConnectNRopes
{

    /*
     * Here we'll do the following:1
     * 1. Connect N Ropes with minimum cost.
     */

    // Function to connect N ropes with minimum cost
    public static int connectNRopes(int[] ropes)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < ropes.length; i++)
        {
            pq.add(ropes[i]);
        }

        int cost = 0;

        while(pq.size() > 1)
        {
            int first = pq.poll();
            int second = pq.poll();

            // We're basically removing the two smallest ropes and adding their sum to the cost
            // and then adding the sum back to the priority queue

            cost += first + second;

            pq.add(first + second);
        }

        return cost;
    }

    public static void main(String[] args)
    {
        int[] ropes = {2, 5, 4, 8, 6, 9};

        System.out.println(connectNRopes(ropes));
    }
}
