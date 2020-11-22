package cs.com.examination.test.week08;

/**
 * Created by chenshun on 2020/11/22.
 * 191. 位1的个数
 */

public class HammingWeight {

    /**
     * 考察点：位运算
     * 时间复杂度为o(1)，int为4个字节，最多32位，为常数
     * 空间复杂度o(1)
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }
}
