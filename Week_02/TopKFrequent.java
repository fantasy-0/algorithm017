package cs.com.examination.test.week02;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by chenshun on 2020/10/11.
 */

public class TopKFrequent {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return new int[0];
        }

        //1.Map记录每个数字出现的频率,出现了+1
        Map<Integer, Integer> dataTimes = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!dataTimes.containsKey(num)) {
                dataTimes.put(num, 1);
            } else {
                dataTimes.put(num, dataTimes.get(num) + 1);
            }
        }

        //2.遍历Map依次丢入小顶堆，超过k个数字，pop出堆顶元素
        //降序比较器
        Comparator downSort = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];//小顶堆用降序，所以o1[1] - o2[1]小于0才调换位置
            }
        };
        PriorityQueue<int[]> data = new PriorityQueue<>(downSort);

        for (Map.Entry<Integer, Integer> entry : dataTimes.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (data.size() < k) {
                data.add(new int[] {key, value});
            } else if (value > data.peek()[1]) {
                data.poll();
                data.add(new int[] {key, value});
            }
        }

        int[] result = new int[data.size()];
        while (data.size() != 0) {
            int size = data.size();
            result[result.length - size] = data.poll()[0];
        }

        return result;
    }

}
