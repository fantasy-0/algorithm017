package cs.com.examination.test.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenshun on 2020/10/6.
 * 589. N叉树的前序遍历
 */

public class NPreOrder {
// Definition for a Node.
static class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

    public static void main(String args[]) {
        Node root = new Node();
        List<Node> children = new ArrayList<>();
        root.val = 1;
        root.children = children;

        Node node1 = new Node();
        node1.val = 3;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 4;
        children.add(node1);
        children.add(node2);
        children.add(node3);

        List<Node> children2 = new ArrayList<>();
        node1.children = children2;
        Node node4 = new Node();
        node4.val = 5;
        Node node5 = new Node();
        node5.val = 6;
        children2.add(node4);
        children2.add(node5);

        System.out.println("result:" + preorder(root));
    }

    public static List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        return preOrder(root, result);
    }

    /**
     * 方法1，递归。
     */
//    private static List<Integer> preOrder(Node root, List<Integer> result) {
//        if (root == null) {
//            return result;
//        }
//
//        result.add(root.val);
//        if (root.children == null) {
//            return result;
//        }
//
//        for (Node node : root.children) {
//            preOrder(node, result);
//        }
//
//        return result;
//    }

    //方法2，栈
    private static List<Integer> preOrder(Node root, List<Integer> result) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<Node> cacheData = new Stack<>();
        cacheData.push(root);

        while (!cacheData.empty()) {
            Node node = cacheData.pop();
            result.add(node.val);
            if (node.children == null) {
                continue;
            }

            for (int i = node.children.size() - 1; i >= 0; i--) {
                Node child = node.children.get(i);
                if (child != null) {
                    cacheData.push(child);
                }
            }
        }

        return result;
    }
}
