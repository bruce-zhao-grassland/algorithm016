class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n+1];
        for (int i = 0; i < n; ++i) {
            dp[i+1] = dp[i] + grid[0][i];
        }
        for (int i = 1; i < m; ++i) {
            dp[1] += grid[i][0];
            for (int j = 1; j < n; ++j) {
                dp[j+1] = Math.min(dp[j], dp[j+1]) + grid[i][j];
            }
        }
        return dp[n];
    }
}