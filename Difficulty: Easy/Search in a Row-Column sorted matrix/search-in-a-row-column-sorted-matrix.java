//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }

            int x = sc.nextInt();

            if (new Solution().matSearch(mat, x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // Get the dimensions of the matrix
        int n = mat.length;
        int m = mat[0].length;

        // Start from the top-right corner
        int i = 0, j = m - 1;

        // Traverse the matrix
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return true; // Element found
            } else if (mat[i][j] > x) {
                j--; // Move left
            } else {
                i++; // Move down
            }
        }

        return false; // Element not found
    }
}
