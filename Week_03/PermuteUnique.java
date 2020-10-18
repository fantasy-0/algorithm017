package cs.com.examination.test.week03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenshun on 2020/10/18.
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */

public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null) {
            return resultList;
        }

        Set<Integer> notSet = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        permute(resultList, null, nums.length, nums, resultSet, notSet);
        return resultList;
    }

    private void permute(List<List<Integer>> resultList, ArrayList<Integer> result, int length, int[] canUseList, Set<String> resultSet, Set<Integer> notSet) {
        int resultCount = result == null ? 0 : result.size();

        if (resultCount == length) {
            // 记录一组答案
            String resultStr = result.toString();
            if (!resultSet.contains(resultStr)) {
                resultList.add(new ArrayList<>(result));
                resultSet.add(resultStr);
            }
        }

        for (int i = 0; i < canUseList.length; i++) {
            if (!notSet.contains(i)) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                Integer data = canUseList[i];
                notSet.add(i);
                result.add(data);
                permute(resultList, result, length, canUseList, resultSet, notSet);
                result.remove(result.size() - 1);
                notSet.remove(i);
            }
        }
    }
}
