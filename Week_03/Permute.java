package cs.com.examination.test.week03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenshun on 2020/10/18.
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */

public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resultList;
        }

        //构建可用元素集合
        Set<Integer> temp = new HashSet<>();
        for (Integer data : nums) {
            temp.add(data);
        }

        permute(resultList, nums.length, null, temp);
        return resultList;
    }

    private void permute(List<List<Integer>> resultList, int length, List<Integer> result, Set<Integer> canUse) {
        int resultCount = result == null ? 0 : result.size();

        if(resultCount + canUse.size() < length) {
            //当前数量+可用数量如果不大于length，则此分支不能构建答案舍弃
            return;
        }

        if (resultCount == length) {
            //当前长度与目标长度一致，找到一个有效答案
            resultList.add(new ArrayList(result));
        }

        for (Integer data : canUse) {
            if (result == null) {
                result = new ArrayList<>();
            }

            //当前元素被选中，下一次不能再用
            Set<Integer> temp = new HashSet<>(canUse);
            temp.remove(data);
            result.add(data);

            //继续选择下一个元素
            permute(resultList, length, result, temp);

            //重新回溯
            result.remove(data);
        }
    }
}
