package cs.com.examination.test.week04;

/**
 * Created by chenshun on 2020/10/25.
 * 33. 搜索旋转排序数组
 */

public class searchSpinSortArray {

    public int search(int[] nums, int target) {
        int index = -1;
        if (nums == null || nums.length == 0) {
            return index;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                //左边有序
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //右边有序
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return index;
    }
}
