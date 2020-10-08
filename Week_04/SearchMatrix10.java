class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean findFlag = false;
        if (0 == matrix.length || 1 == matrix.length && 0 == matrix[0].length) {
            return findFlag;
        } 
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int pos = (l + r) >> 1;
            int row = pos / n, col = pos % n;
            if (matrix[row][col] == target) {
                findFlag = true;
                break;
            } else if (matrix[row][col] < target) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }

        return findFlag;
    }
}