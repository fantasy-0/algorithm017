package cs.com.examination.test.week02;

/**
 * Created by chenshun on 2020/10/6.
 * 242. 有效的字母异位词
 */

public class IsAnagram {

    public static void main(String args[]) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("result:" + isAnagram(s, t));
    }

    //方法1，调用Arrays.sort方法给s、t排序然后比较字符串内容是否一致，
    // 一致则为有效，否则无效,
    // 此方法时间复杂度为n*logn，由于入参空间复杂度忽略，我们假如采用堆排序的话空间复杂度为o(1)

    //方法2，由于字母只有小写且只有26个英文字母，所以可以用一个大小为26的数组存储，
    // s字符串出现的字母数组+1,t字符串出现的字母，数组对应位置-1，
    // 最后遍历下数组是否元素都为0，是的则为有效,
    // 时间复杂度为n,空间复杂度为o(1),因为开辟数组大小为26.
    public static boolean isAnagram(String s, String t) {
        if (s == t) {
            return true;
        }

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int a[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }

        for (int data : a) {
            if (data != 0) {
                return false;
            }
        }

        return true;
    }
}
