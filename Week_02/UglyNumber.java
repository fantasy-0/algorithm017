package cs.com.examination.test.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by chenshun on 2020/10/7.
 */

public class UglyNumber {

    public static void main(String args[]) {
        nthUglyNumber(103);
    }

    public static int nthUglyNumber(int n) {
        Queue<Long> cacheData = new PriorityQueue<>();
        cacheData.add(1L);
        int currentIndex = 0;
        int[] dataSource = new int[]{2,3,5};
        while (!cacheData.isEmpty()) {
            long result = cacheData.poll();
            if (++currentIndex >= n) {
                return (int) result;
            }

            for (int i : dataSource) {
                if (!cacheData.contains(i * result)) {
                    cacheData.add(i * result);
                }
            }
        }

        return 0;
    }
}
