package cs.com.examination.test.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenshun on 2020/10/6.
 * 94. 二叉树的中序遍历
 */

public class InOrderTraversal {

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


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> cacheData = new Stack<>();
        while (root != null || !cacheData.empty()) {
            while (root != null) {
                cacheData.push(root);
                root = root.left;
            }
            TreeNode node = cacheData.pop();
            result.add(node.val);
            root = node.right;
        }

        return result;
    }
}
