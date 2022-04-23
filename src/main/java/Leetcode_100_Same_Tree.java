import java.util.LinkedList;
import java.util.Queue;
import src.main.java.common.TreeNode;

public class Leetcode_100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(p);
        queue2.offer(q);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            // if (!isIdentical(queue1, queue2)) {
            //     return false;
            // }
            int size1 = queue1.size();
            int size2 = queue2.size();
            for (int i = 0; i < size1; i++) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();

                if (!(node1.left == null && node2.left == null) && (node1.left == null || node2.left == null)) {
                    return false;
                }

                if (!(node1.right == null && node2.right == null) && (node1.right == null || node2.right == null)) {
                    return false;
                }

                if (node1.val != node2.val) {
                    return false;
                }


                if (node1.left != null) {
                    queue1.add(node1.left);
                }
                if(node1.right != null) {
                    queue1.add(node1.right);
                }
                if (node2.left != null) {
                    queue2.add(node2.left);
                }
                if(node2.right != null) {
                    queue2.add(node2.right);
                }
            }
        }

        return true;
    }
}
