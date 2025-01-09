//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // Edge case: if array has less than 2 elements, return empty list
        if (arr.length < 2) return new ArrayList<>();
        
        // Sort the array
        Arrays.sort(arr);
        
        // Initialize pointers and variables
        int i = 0, j = arr.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        
        // Two-pointer traversal
        while (i < j) {
            int sum = arr[i] + arr[j];
            
            // Update result if this sum is closer to the target
            if (Math.abs(target - sum) < Math.abs(target - closestSum) || 
                (Math.abs(target - sum) == Math.abs(target - closestSum) && 
                 Math.abs(arr[j] - arr[i]) > maxDiff)) {
                closestSum = sum;
                maxDiff = Math.abs(arr[j] - arr[i]);
                result = Arrays.asList(arr[i], arr[j]);
            }
            
            // Move pointers
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        
        return result;
    }
}
