import src.main.java.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_104_Maximum_Depth_of_Binary_Tree {
    //DFS
//     public int maxDepth(TreeNode root) {
//         return theLongestDepth(root, 0);
//     }

//     private int theLongestDepth(TreeNode root, int current) {
//         if (root == null) {
//             return current;
//         }

//         int left = theLongestDepth(root.left, current + 1);
//         int right = theLongestDepth(root.right, current + 1);

//         return left > right ? left : right;
//     }

    //BFS
    public int maxDepth(TreeNode root) {
        int depth = 0;

        if (root == null) {
            return depth;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
