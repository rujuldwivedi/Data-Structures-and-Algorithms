package GoogleOA;

import java.util.Scanner;

public class MaximumLengthSubarray
{

    public static int findMaxZeroSequence(int sequenceLength, int typeOneOps, int typeTwoOps, int[] sequence)
    {
        int windowStart = 0, maxZeroStreak = 0;

        for(int windowEnd = 0; windowEnd < sequenceLength; ++windowEnd)
        {
            while(sequence[windowEnd] > 0)
            {
                if(typeOneOps > 0)
                {
                    --typeOneOps;
                    --sequence[windowEnd];
                }
                else if(typeTwoOps > 0)
                {
                    --typeTwoOps;
                    sequence[windowEnd] = 0;
                }
                else
                {
                    while(sequence[windowStart] == 0)
                    ++windowStart;
                    if(sequence[windowStart] > 0)
                    {
                        if(sequence[windowStart] > 1)
                        typeOneOps += (sequence[windowStart] - 1);
                        ++typeTwoOps;
                        sequence[windowStart] = 0;
                    }
                    ++windowStart;
                }
            }
            maxZeroStreak = Math.max(maxZeroStreak, windowEnd - windowStart + 1);
        }
        return maxZeroStreak;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        while(testCases-- > 0)
        {
            int sequenceLength = scanner.nextInt();
            int typeOneOps = scanner.nextInt();
            int typeTwoOps = scanner.nextInt();

            int[] sequence = new int[sequenceLength];
            for(int i = 0; i < sequenceLength; ++i)
            sequence[i] = scanner.nextInt();

            int result = findMaxZeroSequence(sequenceLength, typeOneOps, typeTwoOps, sequence);

            System.out.println(result);
        }

        scanner.close();
    }
}
