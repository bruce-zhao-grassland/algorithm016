class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0;
        int[] dp = new int[n];
        for (int num : nums) {
            int lo = 0, hi = maxLen;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (dp[mid] < num) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            dp[lo] = num;
            if (lo == maxLen) maxLen++;
        }
        return maxLen;
    }
}