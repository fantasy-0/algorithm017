package cs.com.examination.test.week01;

/**
 * Created by chenshun on 2020/9/27.
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例:
    输入: [0,1,0,2,1,0,1,3,2,1,2,1]
    输出: 6
 */

public class Trap {

    public static void main(String args[]) {
        int[] nums = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(nums);
    }

    //接雨水
    public static int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        //首先将指针指向两端，那么可以得到最少接到的雨水，
        //如果雨水还能增加，在宽度减少的情况下，那么肯定是两端高度低的往前挪动才可以能
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;//左边最大高度
        int rightMax = 0;//右边最大高度
        int sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                //左边界柱子小于右边界柱子，从左往右遍历出现低洼，面积才可能增加
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    sum = sum + leftMax - height[left];
                }
                left++;
            } else {
                //右边界柱子小于或者等于左边界柱子，从右往左遍历，出现低洼，面积才可能增加
                if (rightMax <= height[right]) {
                    rightMax = height[right];
                } else {
                    sum = sum + rightMax - height[right];
                }
                right--;
            }
        }

        return sum;
    }
}
