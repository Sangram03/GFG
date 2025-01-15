//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Initialize a hashmap to store prefix sums and their first occurrences
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Update the current sum
            currentSum += arr[i];

            // If the currentSum equals k, update maxLength
            if (currentSum == k) {
                maxLength = i + 1;
            }

            // Check if (currentSum - k) exists in the map
            if (sumIndexMap.containsKey(currentSum - k)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(currentSum - k));
            }

            // If currentSum is not in the map, add it
            if (!sumIndexMap.containsKey(currentSum)) {
                sumIndexMap.put(currentSum, i);
            }
        }

        return maxLength;
    }
}
