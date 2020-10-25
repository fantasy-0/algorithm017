package cs.com.examination.test.week04;

/**
 * Created by chenshun on 2020/10/25.
 * 122. 买卖股票的最佳时机 II
 */

public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        MaxProfit maxProfit = new MaxProfit();
        int max = maxProfit.maxProfit(prices);
        System.out.println("max = " + max);
    }

    /**
     * 只需要一次遍历数组，时间复杂度为o(n),n代表prices的长度
     * 未借助额外的内存空间，所以空间复杂度为o(1)
     *
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices == null || prices.length == 0) {
            return max;
        }

        int pre = prices[0];//记录前一天股票价格

        for (int i = 1; i < prices.length; i++) {
            if (pre < prices[i]) {
                //单调递增的时候一直不卖,可以转化为增加就算收益
                max += prices[i] - pre;
            } else {
                //单调递减或者持平的时候一直不买,可以转化为收益一直不变
            }

            pre = prices[i];
        }

        return max;
    }
}
