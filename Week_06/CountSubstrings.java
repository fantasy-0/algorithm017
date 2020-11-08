package cs.com.examination.test.week06;

/**
 * Created by chenshun on 2020/11/8.
 * 647. 回文子串
 */

public class CountSubstrings {

    /**
     *  方法1:遍历每一个字符，然后从这个字符扩散看有多少个回文串
     *  时间复杂度为o(n^2)
     *  空间复杂度为o(1)
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 1;//用来记录有多少个回文串
        int left;
        int right;
        for (int i = 1; i < s.length(); i++) {
            count++;//每一个字符都是一个回文子串

            //假如是奇数
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }

            //假如是偶数
            left = i - 1;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
        }

        return count;
    }

    /**
     * 方法2：动态规划，dp[i][j]表示，从i到j的字符串是否为回文串
     * 字符串长度为1的时候，都是回文串
     * 长度为2的时候如果相等那么也是回文串
     * 长度大于2的时候是否是子串取决于s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]
     * 时间复杂度为o(n^2)
     * 空间复杂度为o(n^2)
     */
    public int countSubstrings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        //用来表示总共有多少个回文子串
        int count = 0;
        //用来表示从i到j的字符串是否为回文串
        boolean dp[][] = new boolean[s.length()][s.length()];

        int left;//当前遍历字符串起点
        int right;//当前遍历字符串终点
        //枚举所有可能的子串长度
        for (int l = 0; l < s.length(); l++) {
            //枚举从所有位置开始
            for (int i = 0; i < s.length() - l; i++) {
                left = i;
                right = i + l;
                if (l == 0) {
                    //长度为1
                    dp[left][right] = true;
                } else if (l == 1) {
                    //长度为2
                    dp[left][right] = s.charAt(left) == s.charAt(right);
                } else {
                    //长度大于2
                    dp[left][right] = s.charAt(left) == s.charAt(right) && dp[left + 1][right - 1];
                }

                if (dp[left][right]) {
                    count++;
                }
            }
        }

        return count;
    }
}
