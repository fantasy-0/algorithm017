package cs.com.examination.test.week03;

import java.util.HashMap;
import java.util.Map;

import cs.com.examination.test.Test;

/**
 * Created by chenshun on 2020/10/18.
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
     注意:
     你可以假设树中没有重复的元素。
 */

public class BuildTree {

    public static void main(String args[]) {
        int[] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{3,2,1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = new BuildTree().buildTree(preorder, inorder);

        new BuildTree().inorder(root);
        System.out.println("------\n");
        new BuildTree().preorder(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, preorder.length - 1, 0, preorder, inorder, map);
    }

    /**
     *
     * @param start 遍历区间起点（中序遍历）
     * @param end   遍历区间终点（中序遍历）
     * @param index 根结点所在位置(前序遍历)
     * @param preOrder  前序遍历结果
     * @param inOrder   中序遍历结果
     */
    private TreeNode buildTree(int start, int end, int index, int[] preOrder, int[] inOrder, Map<Integer, Integer> inorderMap) {
        if (start < 0 || start > end || end >= inOrder.length || index >= preOrder.length || preOrder.length != inOrder.length) {
            //越界或者前序、中序结果不一致不做处理
            return null;
        }

        int rootValue = preOrder[index];
        TreeNode root = new TreeNode(rootValue);

        //1.判断是否还存在子树
        if (start == end) {
            //不存在子树直接返回
            return root;
        }

        //2.存在子树，判断根结点在中序遍历区间的什么位置,从而得出左子树与右子树
        int rootInorderIndex = inorderMap.get(rootValue);//根结点在中序遍历的索引
        if (rootInorderIndex > end || rootInorderIndex < start) {
            //在区间内未找到根结点，不存在子树
            return root;
        }

        //3.左子树区间
        int lStart = start;
        int lEnd = rootInorderIndex - 1;
        TreeNode left = null;
        if (lStart <= lEnd || lEnd >= 0) {
            //区间有效，寻找左根结点
            int lIndex = -1;
            //前序遍历的第一个在左子树区间的结点为左子树的根结点
            for (int i = index + 1; i < preOrder.length; i++) {
                if (inorderMap.containsKey(preOrder[i])) {
                    int temp = inorderMap.get(preOrder[i]);
                    if (temp >= lStart && temp <= lEnd) {
                        //取出每一个前序遍历结点看是否在区间内，在则找到根结点
                        lIndex = i;
                        break;
                    } else if (temp > lEnd) {
                        break;
                    }
                }
            }
            if (lIndex != -1) {
                left = buildTree(lStart, lEnd, lIndex, preOrder, inOrder, inorderMap);
            }
        }

        //4.右子树区间
        int rStart = rootInorderIndex + 1;
        int rEnd = end;
        TreeNode right = null;
        if (rStart <= rEnd || rStart < preOrder.length) {
            //区间有效，寻找右根结点
            int rIndex = -1;
            //前序遍历的第一个在右子树区间的结点为右子树的根结点
            for (int i = index + 1; i < preOrder.length; i++) {
                if (inorderMap.containsKey(preOrder[i])) {
                    int temp = inorderMap.get(preOrder[i]);
                    if (temp >= rStart && temp <= rEnd) {
                        //取出每一个前序遍历结点看是否在区间内，在则找到根结点
                        rIndex = i;
                        break;
                    } else if (temp > lEnd) {
                        break;
                    }
                }
            }
            if (rIndex != -1) {
                right = buildTree(rStart, rEnd, rIndex, preOrder, inOrder, inorderMap);
            }
        }

        //将找到的左右子树与根联系起来
        root.left = left;
        root.right = right;

        return root;
    }

    //中序遍历
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + "，");
        inorder(root.right);
    }

    //前序遍历
    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + "，");
        preorder(root.left);
        preorder(root.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
