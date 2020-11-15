class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int i = 0, j = 0;
        while (i < n && obstacleGrid[0][i] == 0) {
            i++;
        }
        if (i > 0) {
            Arrays.fill(dp[0], 0, i, 1);
        }
        while (j < m && obstacleGrid[j][0] == 0) {
            j++;
        }
        i = 1;
        while (i < j) {
            dp[i++][0] = 1;
        }
        for (j = 1; j < m; ++j) {
            for (i = 1; i < n; ++i) {
                if (obstacleGrid[j][i] == 0) {
                    dp[j][i] = dp[j-1][i] + dp[j][i-1];
                } 
            }
        }
        return dp[m-1][n-1];
    }
}