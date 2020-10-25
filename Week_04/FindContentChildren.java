package cs.com.examination.test.week04;

import java.util.Arrays;

/**
 * Created by chenshun on 2020/10/25.
 * 455. 分发饼干
 */

public class FindContentChildren {

    public static void main(String[] args) {
        FindContentChildren findContentChildren = new FindContentChildren();
        int g[] = new int[]{1,2,3};
        int s[] = new int[]{1,1};
        int count = findContentChildren.findContentChildren(g, s);
        System.out.println("count = " + count);
    }


    /**
     * 时间复杂度
     * 一开始进行了排序耗时n * logn + m * logm，n代表孩子数量，m代表饼干数量
     * 接着进行for循环由于饼干最大只会遍历一次，孩子也只会遍历一次，因此为为n、m当中最大值
     * 所以得出时间复杂度为o(N*logN)其中N为n、m中的最大值.
     *
     * 空间复杂度
     * 由于排序是原地排序，程序也未借助额外的空间，因此空间复杂度为o(1)
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        if (s == null || s.length == 0 || g == null || g.length == 0) {
            //没有孩子或者没有饼干，那么条件终止
            return count;
        }

        //为了满足让更多的孩子满足，需要将胃口大的孩子放到最后满足
        Arrays.sort(g);
        Arrays.sort(s);

        int cookieIndex = 0;//饼干索引

        //遍历所有的孩子，寻找满足胃口的饼干
        for (int i = 0; i < g.length; i++) {
            int child = g[i];//当前索引孩子的胃口
            while (cookieIndex < s.length) {
                if (s[cookieIndex] >= child) {
                    count++;
                    cookieIndex++;
                    break;
                }
                cookieIndex++;
            }
            //未找到满足当前孩子的饼干结束
            if (cookieIndex >= s.length) {
                return count;
            }
        }

        return count;
    }
}
