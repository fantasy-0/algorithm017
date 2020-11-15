package cs.com.examination.test.week07;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenshun on 2020/11/15.
 * 22. 括号生成
 */

public class GenerateParenthesis {

    public static void main(String args[]) {
        new GenerateParenthesis().generateParenthesis(3);
    }

    /**
     * 方法1：深度优先搜索+剪枝
     *  时间复杂度为：o(2^n),由于每个位置可以选择左或者右括号，n个位置，那么就有n个2相乘个结果，所以为o(2^n)
     *  空间复杂度为:o(n),其中n代表左或者右括号的2倍.
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n, n);
        return result;
    }

    private void dfs(List<String> result, String str, int leftCount, int rightCount, int length) {
        if (str != null && str.length() == 2 * length) {
            //记录答案
            result.add(str);
            return;
        }

        if (leftCount == 0 && rightCount == 0) {
            return;
        }

        //选择左括号下沉
        if (leftCount > 0) {
            //1.左括号数量大于右括号，左括号数量大于0
            dfs(result, str + "(", leftCount - 1, rightCount, length);
        }


        //选择右括号下沉
        if (rightCount > leftCount && rightCount > 0) {
            dfs(result, str + ")", leftCount, rightCount - 1, length);
        }
    }
}
