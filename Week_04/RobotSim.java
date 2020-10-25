package cs.com.examination.test.week04;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenshun on 2020/10/25.
 * 874. 模拟行走机器人
 */

public class RobotSim {

    /**
     * 时间复杂度,首先需要遍历指令长度为N,接着需要遍历走的每一步也就是commands[i]的大小K
     * 最坏情况下，无障碍物，commands中元素的大小相等，时间复杂度为o(NK)
     * 空间复杂度，借助了集合存储障碍物，所以空间复杂度为o(M),M代表障碍物的多少。
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        //初始化方向北
        int direction = 0;  //0:y北 1:x东 2:-y南 3:-x西
        //初始化起点(0,0)
        int[] position = new int[]{0,0};
        //障碍物
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(obstacle[0] + " " + obstacle[1]);
        }

        int max = 0;
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command == -2) {
                //向左转
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                //向右转
                direction = (direction + 1) % 4;
            } else {
                //行走
                move(position, direction, command, obstaclesSet);
            }

            int x = position[0];
            int y = position[1];
            int temp = x * x + y * y;
            max = max < temp ? temp : max;
        }


        return max;
    }

    private void move(int[] position, int direction, int command, Set<String> obstaclesSet){
        int index = direction % 2 == 0 ? 1 : 0;//方向偶数是y轴，奇数是x轴
        int step = direction > 1 ? -1 : 1;//只有y、x轴才为正数，是向前走，其余情况是向后走

        for (int i = 0; i < command; i++) {
            String temp;
            if (index == 0) {
                //x轴
                temp = (position[0] + step) + " " + position[1];
            } else {
                //y轴
                temp = position[0] + " " + (position[1] + step);
            }
            if (!obstaclesSet.contains(temp)) {
                position[index] = position[index] + step;
            } else {
                return;
            }
        }
    }
}
