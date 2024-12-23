//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchRowMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in a row-wise sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // Get the dimensions of the matrix
        int n = mat.length;    // number of rows
        int m = mat[0].length; // number of columns
        
        // Iterate over each row and perform binary search
        for (int i = 0; i < n; i++) {
            if (binarySearch(mat[i], x)) {
                return true; // Element found
            }
        }
        
        return false; // Element not found
    }

    // Helper function for binary search on a row
    private boolean binarySearch(int[] row, int target) {
        int low = 0, high = row.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false; // Target not found in this row
    }
}

