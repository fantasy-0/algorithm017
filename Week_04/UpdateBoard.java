package cs.com.examination.test.week04;

/**
 * Created by chenshun on 2020/10/27.
 */

public class UpdateBoard {

    /**
     * 深度优先遍历
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if (click == null || click.length < 2 || board == null || board.length == 0) {
            return board;
        }

        //点击区域
        int row = click[0];
        int col = click[1];
        //面板边界
        int boardR = board.length;
        int boardC= board[0].length;
        //判断点击区域是否越界，越界则游戏结束
        if (row >= boardR || col >= boardC) {
            return board;
        }

        if(board[row][col] == 'M') {
            //踩雷游戏结束,规则1
            board[row][col] = 'X';
            return board;
        }

        updateBoard(row, col, boardR, boardC, board);

        return board;
    }

    private void updateBoard(int row, int col, int boardR, int boardC, char[][] board) {
        int count = 0;
        int tempR;
        int tempC;
        //遍历点击点的上下左右以及左上、右上、左下、右下看是否有雷
        for (int i = 0; i <= 8; i++) {
            int r = i / 3;
            int c = i % 3;
            if (r < 1) {
                tempR = row - 1;
            } else if (r > 1) {
                tempR = row + 1;
            } else {
                tempR = row;
            }

            if (c < 1) {
                tempC = col - 1;
            } else if (c > 1) {
                tempC = col + 1;
            } else {
                tempC = col;
            }

            if (tempR < boardR && tempR >= 0 && tempC < boardC && tempC >= 0 && board[tempR][tempC] == 'M') {
                count++;
            }
        }

        if (count > 0) {
            //规则3
            board[row][col] = Character.forDigit(count,10);
            return;
        } else {
            //规则2
            board[row][col] = 'B';
            for (int i = 0; i <= 8; i++) {
                int r = i / 3;
                int c = i % 3;
                if (r < 1) {
                    tempR = row - 1;
                } else if (r > 1) {
                    tempR = row + 1;
                } else {
                    tempR = row;
                }

                if (c < 1) {
                    tempC = col - 1;
                } else if (c > 1) {
                    tempC = col + 1;
                } else {
                    tempC = col;
                }

                if (tempR < boardR && tempR >= 0 && tempC < boardC && tempC >= 0 && board[tempR][tempC] == 'E') {
                    updateBoard(tempR, tempC, boardR, boardC, board);
                }
            }
        }
    }
}
