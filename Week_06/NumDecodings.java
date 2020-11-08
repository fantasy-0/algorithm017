package cs.com.examination.test.week06;

/**
 * Created by chenshun on 2020/11/8.
 * 91. 解码方法
 */

public class NumDecodings {

    public static void main(String args[]) {
        String a = "2101";
        int b = new NumDecodings().numDecodings(a);
        System.out.println("b=" + b);
    }

    /**
     * 方法1：暴力求解每个位置都是选一个数字或者选两个数字，所以时间复杂度o(2^n)
     * 空间复杂度为o(n),栈的深度,每次都是选择一个字母,栈的深度就是o(n)
     * 跑不过用例，超出时间限制
     */


    /**
     * 方法2：动态规划，用数组dp[i]表示,长度为i的字符串有多少种解码可能性
     * 由于到达最后一步有两种可能性，要不就前面是选择1个字符，要不就是选择两个字符，所以当i>1的时候可以得出以下方程：
     * dp[i] = dp[i - 1] + dp[i - 2];其中substring(i,i+1)有效,才能取值dp[i - 1]，substring(i-1,i+1)有效，才能取值dp[i - 2]
     * 时间复杂度为o(n)
     * 空间复杂度为o(n)
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }

        int dp[] = new int[s.length()];
        dp[0] = 1;

        if (s.length() == 1) {
            return 1;
        }

        String data1 = s.substring(0, 2);
        String data2 = s.substring(1, 2);
        int cur = Integer.valueOf(data1);
        if (cur > 0 && cur <= 26) {
            if (!data2.startsWith("0")) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        } else {
            if (!data2.startsWith("0")) {
                dp[1] = 1;
            } else {
                dp[1] = 0;
            }
        }

        int str1Count;
        int str2Count;
        for (int i = 2; i < s.length(); i++) {
            data2 = s.substring(i, i + 1);//前一个字符
            if (data2.startsWith("0")) {
                str1Count = 0;
            } else {
                str1Count = dp[i - 1];
            }

            data1 = s.substring(i - 1, i + 1);
            cur = Integer.valueOf(data1);
            if (cur > 0 && cur <= 26) {
                if (!data1.startsWith("0")) {
                    str2Count = dp[i - 2];
                } else {
                    str2Count = 0;
                }
            } else {
                str2Count = 0;
            }

            dp[i] = str1Count + str2Count;
        }

        return dp[s.length() - 1];
    }
}
