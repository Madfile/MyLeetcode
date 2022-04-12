package src.main.java;

import src.main.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_144_Binary_Tree_Preorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, ans);
        return ans;
    }

    private void traverse(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }

        ans.add(node.val);
        traverse(node.left, ans);
        traverse(node.right, ans);
    }
}
