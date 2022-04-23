import src.main.java.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(left);
        queue2.offer(right);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val != node2.val) {
                return false;
            }

            if (!(node1.left == null && node2.right == null) && (node1.left == null || node2.right == null)) {
                return false;
            }

            if (node1.left != null) {
                if (node2.right != null) {
                    queue1.offer(node1.left);
                    queue2.offer(node2.right);
                } else {
                    return false;
                }
            }

            if (!(node1.right == null && node2.left == null) && (node1.right == null || node2.left == null)) {
                return false;
            }

            if (node1.right != null) {
                if (node2.left != null) {
                    queue1.offer(node1.right);
                    queue2.offer(node2.left);
                } else {
                    return false;
                }
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}
