package cs.com.examination.test.week03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenshun on 2020/10/17.
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */

public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        Set<Integer> canUseSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            canUseSet.add(i);
        }
        combine(1, resultList, canUseSet, n, null, k);
        return resultList;
    }

    /**
     * @param min 可以填充的最小数字(不包含)
     * @param resultList 有效组合集
     * @param canUseSet 可以选择的数字
     * @param result 组合后的字符串
     * @param length 需要组合多长的字符串
     */
    private void combine(int min, List<List<Integer>> resultList, Set<Integer> canUseSet, int data, List<Integer> result, int length) {
        int resultSize = result == null ? 0 : result.size();
        if (resultSize + data - min + 1 < length) {
            return;
        }

        if (result != null && result.size() == length) {
            // 记录一组答案
            List<Integer> combine = new ArrayList<>();
            combine.addAll(result);
            resultList.add(combine);
            return;
        }

        for (int i = min; i <= data; i++) {
            Integer nums = i;
            if (canUseSet.contains(nums)) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                canUseSet.remove(nums);
                result.add(nums);
                min = i + 1;
                combine(min, resultList, canUseSet, data, result, length);
                result.remove(nums);
                canUseSet.add(nums);
            }

        }
    }
}
