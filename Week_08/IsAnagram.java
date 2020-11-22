package cs.com.examination.test.week08;

/**
 * Created by chenshun on 2020/11/22.
 */

public class IsAnagram {

    /**
     * 考察点：计数排序
     * 时间复杂度o(n)
     * 空间复杂度o(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null && t != null) {
            return false;
        }

        if (s != null && t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int result[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
            result[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
