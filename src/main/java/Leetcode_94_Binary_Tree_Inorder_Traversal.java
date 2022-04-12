package src.main.java;

import src.main.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        traverse(root, ans);
        return ans;
    }

    private void traverse(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }

        traverse(node.left, ans);
        ans.add(node.val);
        traverse(node.right, ans);
    }
}
