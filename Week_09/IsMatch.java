package cs.com.examination.test.week09;

/**
 * Created by chenshun on 2020/11/29.
 * 44. 通配符匹配
 */

public class IsMatch {
    public boolean isMatch(String s, String p) {
        if (s == null && p != null) {
            return false;
        }

        if (s != null && p == null) {
            return false;
        }

        if (s == p || s.equals(p)) {
            return true;
        }

        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            //将第0列赋值
            dp[i][0] = false;
        }

        for (int j = 1; j < dp[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = s.charAt(i - 1) == p.charAt(j - 1) ? dp[i - 1][j - 1] : false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
