package cs.com.examination.test.week07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenshun on 2020/11/15.
 * 547. 朋友圈
 */

public class FindCircleNum {

//    /**
//     * 方法1：深度优先遍历
//     * 时间复杂度:o(n^2)：遍历每一个元素
//     * 空间复杂度:o(n)：栈的深度为n
//     * @param M
//     * @return
//     */
//    public int findCircleNum(int[][] M) {
//        if (M == null || M.length == 0) {
//            return 0;
//        }
//
//        int count = 0;
//        Set<Integer> set = new HashSet<>();//用来标记当前学生是否被访问了，防止死循环
//        for (int i = 0; i < M.length; i++) {
//            if (!set.contains(i)) {
//                //寻找这个学生的所有朋友，并且标记
//                count++;
//                set.add(i);
//                dfs(i, M, set);
//            }
//        }
//
//        return count;
//    }
//    private void dfs(int row, int[][] M, Set<Integer> set) {
//        if (row >= M.length || row < 0) {
//            return;
//        }
//
//        for (int i = 0; i < M[0].length; i++) {
//            if (!set.contains(i) && M[row][i] == 1) {
//                dfs(i, M, set);
//            }
//        }
//    }

    /**
     * 方法2：并查集
     * 时间复杂度o(n^3)合并的时候找老大有可能会找n次有n^2个元素，每个都找n次，所以是o(n^3)
     * 空间复杂度，借用额外空间o(n)
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);

        //1.遍历每一个学生，加入到相应团体
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                //将第i个学生与第j个学生是团体的合并
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        //2.查找团体老大个数就是答案
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }

        return count;
    }

    //合并团体
    private void union(int[] parent, int i, int j) {
        int xParent = find(parent, i);
        int yParent = find(parent, j);
        if (xParent != yParent) {
            //两个小团体老大不是同一个,任意选一个当老大
            parent[xParent] = yParent;
        }
    }

    //查找团体老大
    private int find(int[] parent, int i) {
        while (parent[i] != -1) {
            i = parent[i];
        }

        return i;
    }
}
