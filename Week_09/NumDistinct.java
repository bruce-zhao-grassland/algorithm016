class NumDistinct {
    public int numDistinct(String s, String t) {
        int nS = s.length() + 1, nT = t.length() + 1;
        if (nT > nS) return 0;
        int[][] dp = new int[nT][nS];
        Arrays.fill(dp[0], 1);
        char[] cS = s.toCharArray(), cT = t.toCharArray();
        for (int i = 1; i < nT; i++) {
            for (int j = 1; j < nS; ++j) {
                if (cS[j-1] == cT[i-1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[nT-1][nS-1];
    }
}