//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find H-Index
    public int hIndex(int[] citations) {
        // Step 1: Sort the citations array in ascending order
        java.util.Arrays.sort(citations);
        int n = citations.length;

        // Step 2: Traverse the sorted array to find the H-Index
        for (int i = 0; i < n; i++) {
            int h = n - i; // Number of papers with at least 'h' citations
            if (citations[i] >= h) {
                return h;
            }
        }

        // Step 3: If no valid H-Index is found, return 0
        return 0;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] citations1 = {3, 0, 5, 3, 0};
        int[] citations2 = {5, 1, 2, 4, 1};
        int[] citations3 = {0, 0};

        System.out.println("H-Index (Example 1): " + solution.hIndex(citations1)); // Output: 3
        System.out.println("H-Index (Example 2): " + solution.hIndex(citations2)); // Output: 2
        System.out.println("H-Index (Example 3): " + solution.hIndex(citations3)); // Output: 0
    }
}
