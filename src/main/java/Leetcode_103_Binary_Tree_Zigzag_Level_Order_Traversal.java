import java.util.*;

import src.main.java.common.TreeNode;

public class Leetcode_103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null)
            return ans;
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // 当前层元素的个数
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    if ((level % 2) == 0) {
                        subList.add(curNode.val);
                    } else {
                        subList.add(0, curNode.val);
                    }
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
            //因为上边 queue.offer(curNode.left) 没有判断是否是 null
            //所以要判断当前是否有元素
            if (subList.size() > 0) {
                ans.add(subList);
            }
            level++;
        }
        return ans;
    }
}
