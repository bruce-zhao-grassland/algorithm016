class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, res = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int[] arr = new int[m];
            for (int j = i; j < n; ++j) {
                for (int z = 0; z < m; ++z) {
                    arr[z] += matrix[z][j];
                }
                res = Math.max(res, getMax(arr, k));
                if (res == k) {
                    return k;
                }
            }
        }   
        return res;
    }

    private int getMax(int[] arr, int k) {
        int sum = arr[0], max = arr[0], n = arr.length;
        for (int i = 1; i < n; ++i) {
            if (sum < 0) {
                sum = 0;
            }
            sum += arr[i];
            if (max < sum) {
                max = sum;
            }
        }
        if (max <= k) {
            return max;
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            sum = 0;
            for (int j = i; j < n; ++j) {
                sum += arr[j];
                if (max < sum && sum <= k) {
                    max = sum;
                }
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }
}