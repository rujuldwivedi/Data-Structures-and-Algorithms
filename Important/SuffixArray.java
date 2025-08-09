package Important;
import java.util.*;
class SuffixArray {
    int[] buildSuffixArray(String s) {
        int n = s.length();
        String[] suffixes = new String[n];
        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i);
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> suffixes[a].compareTo(suffixes[b]));
        return Arrays.stream(idx).mapToInt(Integer::intValue).toArray();
    }
}

