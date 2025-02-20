//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> result = new ArrayList<>();
        
        // Max Heap for the left half
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        // Min Heap for the right half
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        for (int num : arr) {
            // Step 1: Add number to appropriate heap
            if (left.isEmpty() || num <= left.peek()) {
                left.add(num);
            } else {
                right.add(num);
            }
            
            // Step 2: Balance the heaps
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            } else if (right.size() > left.size()) {
                left.add(right.poll());
            }
            
            // Step 3: Calculate the median
            if (left.size() == right.size()) {
                double median = (left.peek() + right.peek()) / 2.0;
                result.add(median);
            } else {
                result.add((double) left.peek());
            }
        }
        
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {5, 15, 1, 3, 2, 8};
        System.out.println("Output 1: " + sol.getMedian(arr1)); // [5.0, 10.0, 5.0, 4.0, 3.0, 4.0]
        
        int[] arr2 = {2, 2, 2, 2};
        System.out.println("Output 2: " + sol.getMedian(arr2)); // [2.0, 2.0, 2.0, 2.0]
    }
}
