import src.main.java.common.TreeNode;

public class Leetcode_110_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        }
    }

    // private int getDepth(TreeNode root, int current) {
    //     if (root == null) {
    //         return current;
    //     } else {
    //         int leftDepth = getDepth(root.left, current + 1);
    //         int rightDepth = getDepth(root.right, current + 1);
    //         return leftDepth > rightDepth ? leftDepth : rightDepth;
    //     }
    // }
}
