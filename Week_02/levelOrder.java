package cs.com.examination.test.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenshun on 2020/10/7.
 */

public class levelOrder {
    // Definition for a Node.
    class Node {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Node> cacheData = new ArrayList<>();
        List<Node> tempData;
        cacheData.add(root);
        List<Integer> values;
        while(cacheData.size() > 0) {
            values = new ArrayList<>();
            tempData = new ArrayList<>();
            for (Node node : cacheData) {
                values.add(node.val);
                if (node.children != null) {
                    tempData.addAll(node.children);
                }
            }
            cacheData = tempData;
            result.add(values);
        }

        return result;
    }
}
