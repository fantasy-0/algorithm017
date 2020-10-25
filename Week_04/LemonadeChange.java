package cs.com.examination.test.week04;

/**
 * Created by chenshun on 2020/10/25.
 * 860. 柠檬水找零
 */

public class LemonadeChange {

    public static void main(String args[]) {
        int[] bills = new int[]{5,5,10,10,20};
        boolean result = new LemonadeChange().lemonadeChange(bills);
        System.out.println("result = " + result);
    }

    /**
     * 只需要遍历一次账单即可，时间复杂度为o(n),n代表账单数量
     * 由于借助了额外的空间存储零钱数量，但是零钱种类固定为3，所以空间复杂度为o(1)
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            //没有账单，找零成功
            return true;
        }

        int changes[] = new int[3];//用来存储零钱数量

        //遍历账单，看是否能够找零成功
        for (int bill : bills) {
            if (bill == 5) {
                changes[0]++;
            } else if (bill == 10) {
                if (changes[0] < 1) {
                    return false;
                }

                changes[0]--;
                changes[1]++;
            } else if (bill == 20) {
                if (changes[1] > 0 && changes[0] > 0) {
                    changes[0]--;
                    changes[1]--;
                    changes[2]++;
                } else if (changes[0] > 2) {
                    changes[0] -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
