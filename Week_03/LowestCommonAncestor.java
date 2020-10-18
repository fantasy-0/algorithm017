package cs.com.examination.test.week03;

/**
 * Created by chenshun on 2020/10/17.
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */

public class LowestCommonAncestor {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * 时间复杂度为o(n),由于每个结点最多只遍历了一次，n为结点数
     * 空间复杂度最坏为o(n),树退化为链表，最好为o(logn),n为结点数。
     * 因为递归栈最大为树的高度，而树的高度最优为：log(2)(n + 1),最差为n得出答案
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            //根结点为空，或者p、q任意一个结点在根结点，那么根结点为最近公共祖先
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);//左子树的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);//右子树的最近公共祖先

        if (left != null && right != null) {
            //左右子树的最近公共祖先都存在，所以根结点为最近公共祖先
            return root;
        }

        if (left != null) {
            //左子树最近公共祖先存在，右子树不存在，所以左子树为最近公共祖先
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }

}
