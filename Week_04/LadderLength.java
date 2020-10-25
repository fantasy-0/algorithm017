package cs.com.examination.test.week04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chenshun on 2020/10/25.
 * 127. 单词接龙
 */

public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //beginWord与endWord非空，不做判断了。
        if (wordList== null || !wordList.contains(endWord)) {
            //首先判断单词是否存在字典当中，不存在则找不到
            return 0;
        }

        //假如存在，则开始构建层次结构图
        int level = 1;//记录层次

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int queueSize = queue.size();
        while (queueSize > 0) {
            for (int i = 0; i < queueSize; i++) {
                String data = queue.poll();
                if (endWord.equals(data)) {
                    //已经找到目标值
                    return level;
                }
                findWord(data, wordList, queue);
            }

            level++;
            queueSize = queue.size();
        }


        return 0;
    }

    //寻找相差一个字符的字符串
    private void findWord(String word, List<String> wordList, Queue<String> queue) {
        if (wordList.size() == 0) {
            return;
        }

        List<String> temp = new ArrayList<>(wordList);
        for (String data : temp) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (data.charAt(i) != word.charAt(i)) {
                    count++;
                }

                if (count > 1) {
                    break;
                }
            }

            if (count == 1) {
                queue.offer(data);
                wordList.remove(data);
            }
        }
    }
}
