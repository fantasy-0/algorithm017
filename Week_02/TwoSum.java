package cs.com.examination.test.week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenshun on 2020/10/6.
 * 1. 两数之和
 */

public class TwoSum {

    public static void main(String args[]) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println("result:" + Arrays.toString(twoSum(nums, target)));
    }

    //方法1：暴力求解，两层for循环，第一个和第二个一直到最后一个，第二个和第三个一直到最后一个...
    //时间复杂度o(n^2),空间复杂度o(1)

    //方法2：将当前遍历的值作为key,索引作为value存入map当中，
    // 每次for循环都去寻找目标值是否存在map当中，假如存在则输出当前索引+map当中的value即可。
    // 时间复杂度为o(n),只用了一层循环每个元素都只遍历了依次，空间复杂度为o(n)
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }

        Map<Integer, Integer> cachedata = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentData = nums[i];
            int findData = target - currentData;
            if (cachedata.containsKey(findData)) {
                int index = cachedata.get(findData);
                return new int[] {index, i};
            }

            cachedata.put(currentData, i);
        }

        return new int[0];
    }
}
