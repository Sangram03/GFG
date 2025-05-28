class Solution {
    public boolean ValidCorner(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                for (int k = 0; k < m; k++) {
                    if (mat[i][k] == 1 && mat[j][k] == 1) {
                        count++;
                        if (count >= 2) {
                            return true; // Found a rectangle
                        }
                    }
                }
            }
        }
        
        return false; // No rectangle found
    }
}
