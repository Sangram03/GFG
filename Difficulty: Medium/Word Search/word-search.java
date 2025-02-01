//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Directions for moving in the grid: up, down, left, right
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static boolean isWordExist(char[][] mat, String word) {
        int n = mat.length, m = mat[0].length;

        // Try to find the word starting from each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0) && dfs(mat, word, i, j, 0, new boolean[n][m])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] mat, String word, int i, int j, int index, boolean[][] visited) {
        // Base case: if we found the whole word
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and constraints
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j] || mat[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited
        visited[i][j] = true;

        // Explore all four directions
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (dfs(mat, word, newRow, newCol, index + 1, visited)) {
                return true;
            }
        }

        // Backtrack
        visited[i][j] = false;
        return false;
    }

    // Test cases
    public static void main(String[] args) {
        char[][] mat1 = {
            {'T', 'E', 'E'},
            {'S', 'G', 'K'},
            {'T', 'E', 'L'}
        };
        String word1 = "GEEK";
        System.out.println(isWordExist(mat1, word1)); // Output: true

        char[][] mat2 = {
            {'T', 'E', 'U'},
            {'S', 'G', 'K'},
            {'T', 'E', 'L'}
        };
        String word2 = "GEEK";
        System.out.println(isWordExist(mat2, word2)); // Output: false

        char[][] mat3 = {
            {'A', 'B', 'A'},
            {'B', 'A', 'B'}
        };
        String word3 = "AB";
        System.out.println(isWordExist(mat3, word3)); // Output: true
    }
}
