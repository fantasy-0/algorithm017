package cs.com.examination.test.week01;

/**
 * Created by chenshun on 2020/9/27.
 * 移动零
 */

public class MoveZeros {

    public static void main(String args[]) {
        int[] nums = new int[] {0,1,0,3,12};
        moveZeroes(nums);//移动零
    }

    //移动零
    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }

        System.out.println(nums);
    }

}
