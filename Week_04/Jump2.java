package cs.com.examination.test.week04;

/**
 * Created by chenshun on 2020/10/25.
 * 45. 跳跃游戏 II
 */

public class Jump2 {

    public int jump(int[] nums) {
        int minTimes = 0;//最少的跳跃次数
        if (nums == null || nums.length < 2) {
            return minTimes;
        }

        int pre = nums[0];//第一次可以跳的最远的距离
        int maxPostion = pre;//所遍历位置可以到达的最远的距离

        for (int i = 0; i < nums.length; i++) {
            maxPostion = Math.max(maxPostion, nums[i] + i);
            if (maxPostion == i && i != nums.length - 1) {
                return -1;
            }

            if (i == pre || ((i == nums.length - 1) && pre > i)) {
                //已经到达分区间的终点或者已遍历完数组了
                minTimes++;
                pre = maxPostion;
            }
        }

        return minTimes;
    }
}
