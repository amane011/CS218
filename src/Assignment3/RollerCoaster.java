package Assignment3;

import java.util.Collections;
import java.util.PriorityQueue;

public class RollerCoaster {
    public static void main(String[] args) {
        int[] heights = {7, 3, 5, 8, 6, 7, 4, 7};
        int k = 2;
        System.out.println(maxInterval(heights, k));  // Output should be 3
        
}

public static int maxInterval(int[] heights, int k) {
    int n = heights.length;
    int left = 0;
    int max_length = 0;
        for (int right = 1; right < n; right++) {
            if (Math.abs(heights[right] - heights[right - 1]) > k) {
                left = right;
            }
            max_length = Math.max(max_length, right - left + 1);
        }
        return max_length;
    }
}
