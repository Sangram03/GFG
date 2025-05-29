/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    class Result {
        int maxLen = 0;
        int maxSum = 0;
    }

    public int sumOfLongRootToLeafPath(Node root) {
        Result res = new Result();
        solve(root, 0, 0, res);
        return res.maxSum;
    }

    private void solve(Node node, int currLen, int currSum, Result res) {
        if (node == null) return;

        currSum += node.data;
        currLen++;

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            if (currLen > res.maxLen) {
                res.maxLen = currLen;
                res.maxSum = currSum;
            } else if (currLen == res.maxLen) {
                res.maxSum = Math.max(res.maxSum, currSum);
            }
        }

        // Traverse left and right children
        solve(node.left, currLen, currSum, res);
        solve(node.right, currLen, currSum, res);
    }
}
