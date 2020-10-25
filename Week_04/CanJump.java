package cs.com.examination.test.week04;

/**
 * Created by chenshun on 2020/10/25.
 * 55. 跳跃游戏
 */

public class CanJump {

    /**
     * 时间复杂度o(n)
     * 空间复杂度为o(1)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int pre = nums[0];//记录当前开始点可以跳的最远位置
        int maxPosition = nums[0];//记录当前所遍历元素可以跳的最远的点
        for (int i = 0; i < nums.length; i++) {
            maxPosition = Math.max(nums[i] + i, maxPosition);
            if (maxPosition == i && i != (nums.length - 1)) {
                return false;
            }

            if (i == pre) {
                pre = maxPosition;
            }
        }

        return true;
    }

    /**
     * 方法2贪心算法
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int maxPosition = nums.length - 1;//记录当前所遍历的点能到达的位置
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= maxPosition) {
                maxPosition = i;
            }
        }

        return maxPosition == 0;
    }
}
