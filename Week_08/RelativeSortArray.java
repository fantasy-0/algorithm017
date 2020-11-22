package cs.com.examination.test.week08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenshun on 2020/11/22.
 * 1122. 数组的相对排序
 */

public class RelativeSortArray {

    /**
     * 考察点：排序算法
     * 时间复杂度：o(m) + o(nlogn) + o(n) + o(k) + o(j)
     * n:arr2数组长度;m:arr1数组长度;K代表arr1在arr2中的元素数量k>=m && k <= n; J代表arr1不在arr2中的元素数量j>= 0 && j < n;
     * 综上时间复杂度为o(nlogn + m)
     *
     * 空间复杂度：o(m) + o(logn) + o(j) + o(m),
     * 综上时间复杂度为o(m + logn)
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return arr1;
        }

        Set<Integer> arr2Set = new HashSet<>();//存储arr2的集合
        for (int data : arr2) {
            arr2Set.add(data);
        }

        Arrays.sort(arr1);//首先将arr1升序排好序，这样可以保证不在arr2当中的元素为升序.

        List<Integer> notInArr2List = new ArrayList<>();//用来记录arr1不存在arr2当中的元素
        Map<Integer, Integer> inArr2Map = new HashMap<>();//用来记录arr1存在arr2当中的元素,key为元素，value为数量
        for (int data : arr1) {
            if (arr2Set.contains(data)) {
                if (inArr2Map.containsKey(data)) {
                    inArr2Map.put(data, inArr2Map.get(data) + 1);
                } else {
                    inArr2Map.put(data, 1);
                }
            } else {
                notInArr2List.add(data);
            }
        }

        int index = 0;
        for (int data : arr2) {
            int count = inArr2Map.get(data);
            while (count > 0) {
                arr1[index++] = data;
                count--;
            }
        }

        for (int data : notInArr2List) {
            arr1[index++] = data;
        }

        return arr1;
    }
}
