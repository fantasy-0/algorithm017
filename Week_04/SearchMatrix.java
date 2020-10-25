package cs.com.examination.test.week04;

/**
 * Created by chenshun on 2020/10/25.
 */

public class SearchMatrix {

    /**
     * 时间复杂度为o(log(m+n))
     * 空间复杂度为o(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;//矩阵的行
        int n = matrix[0].length;//矩阵的列

        int length = matrix.length * matrix[0].length;
        int left = 0;
        int right = length - 1;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
