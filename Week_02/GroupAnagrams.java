package cs.com.examination.test.week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenshun on 2020/10/6.
 * 49. 字母异位词分组
 */

public class GroupAnagrams {

    public static void main(String args[]) {
        String strs[] = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("" + groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return null;
        }

        Map<String, List<String>> cacheData = new HashMap<>();

        for (String str : strs) {
            byte[] bytes = str.getBytes();
            Arrays.sort(bytes);
            String sortStr = new String(bytes);
            if (cacheData.containsKey(sortStr)) {
                List<String> strList = cacheData.get(sortStr);
                strList.add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                cacheData.put(sortStr, strList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : cacheData.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
