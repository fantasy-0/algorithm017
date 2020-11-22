package cs.com.examination.test.week08;

/**
 * Created by chenshun on 2020/11/22.
 * 190. 颠倒二进制位
 */

public class ReverseBits {

    /**
     * 考察点：位运算
     * 时间复杂度o(1)
     * 空间复杂度o(1)
     * @param n
     * @return
     */
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            int temp = (n >> i) & 1;//获取最后一位
            temp = temp << (31 - i);//反转最后一位
            result |= temp;//加到结果里面去
        }

        return result;
    }
}
