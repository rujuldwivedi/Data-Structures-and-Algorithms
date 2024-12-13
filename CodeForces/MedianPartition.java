import java.util.*;

class Solution {
    public int[] findMedianSortedArrays(int[] a, int k) {
        int n = a.length;
        if (n == 0) return new int[]{-1};

        // Sort the array in non-decreasing order
        Arrays.sort(a);

        // Check if k lies at the very left or very right
        if (k < a[0] || k > a[n - 1]) return new int[]{-1};

        // Find the index of the element closest to k
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == k) {
                // We found the exact match, create the subarrays
                return createSubarrays(a, mid, k);
            } else if (a[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Find the element closest to k
        int closestIndex = left;
        int closestElement = a[closestIndex];

        // Create subarrays around the closest element
        int[] result = createSubarrays(a, closestIndex, k);
        if (result[0] != -1) {
            return result;
        }

        // If that didn't work, try splitting the array into subarrays of length 3
        return create3ElementSubarrays(a, k);
    }

    private int[] createSubarrays(int[] a, int index, int k) {
        int n = a.length;
        int left = index, right = index;

        // Expand the subarrays equally on both sides until the median is k
        while (left >= 0 && right < n) {
            if (getMedian(a, left, right) == k) {
                // We found a valid partition
                List<Integer> borders = new ArrayList<>();
                for (int i = left; i <= right; i += 2) {
                    borders.add(i);
                }
                return borders.stream().mapToInt(i -> i).toArray();
            } else if (getMedian(a, left, right) < k) {
                right++;
            } else {
                left--;
            }
        }

        // No suitable partition found
        return new int[]{-1};
    }

    private int[] create3ElementSubarrays(int[] a, int k) {
        int n = a.length;
        for (int i = 0; i < n - 2; i += 3) {
            int[] subarray = {a[i], a[i + 1], a[i + 2]};
            Arrays.sort(subarray);
            if (subarray[1] == k) {
                return new int[]{i, i + 1, i + 2};
            }
        }
        return new int[]{-1};
    }

    private int getMedian(int[] a, int left, int right) {
        int size = right - left + 1;
        return a[left + size / 2];
    }
}