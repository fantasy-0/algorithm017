package cs.com.examination.test.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenshun on 2020/10/6.
 * 144. 二叉树的前序遍历
 */

public class PreOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> cacheData = new Stack<>();
        cacheData.push(root);
        while (!cacheData.empty()) {
            TreeNode node = cacheData.pop();
            result.add(node.val);
            if (node.right != null) {
                cacheData.push(node.right);
            }

            if (node.left != null) {
                cacheData.push(node.left);
            }
        }

        return result;
    }
}
