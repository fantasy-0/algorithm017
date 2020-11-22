package cs.com.examination.test.week08;

/**
 * Created by chenshun on 2020/11/22.
 * 231. 2的幂
 */

public class IsPowerOfTwo {

    /**
     * 考察点：位运算
     * 时间复杂度o(1)
     * 空间复杂度o(1)
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
