package cs.com.examination.test.week04;

/**
 * Created by chenshun on 2020/10/25.
 * 153. 寻找旋转排序数组中的最小值
 */

public class FindMin {
    /**
     * 时间复杂度为o(logn),因为每次舍弃一半的数组,树的层最大为K = log(2)(N + 1)
     * 空间复杂度为o(1),没有借助额外的内存空间
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        int index = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] >= nums[left] && nums[mid] <= nums[right]) {
                return nums[index];
            }

            if (nums[mid] < nums[left]) {
                right = mid - 1;
                index = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
                index = left;
            }
        }

        return nums[index];
    }
}
