//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(
                    token)); // Use Integer.parseInt to parse int values
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling equilibriumPoint() function
            System.out.println(obj.findEquilibrium(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // Step 1: Calculate the total sum of the array.
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Step 2: Traverse the array while maintaining the left sum.
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            // Calculate the right sum as totalSum - leftSum - arr[i].
            int rightSum = totalSum - leftSum - arr[i];
            
            // Check if leftSum equals rightSum.
            if (leftSum == rightSum) {
                return i; // Equilibrium point found.
            }

            // Update the left sum for the next index.
            leftSum += arr[i];
        }

        // Step 3: Return -1 if no equilibrium point is found.
        return -1;
    }
}

