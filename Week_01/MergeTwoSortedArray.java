class Solution {
	/**
	 * 从后往前移动放置数组元素
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m -= 1;
        n -= 1;
        for (int i = n + m + 1; i >= 0; i--) {
            if (m < 0) {
                nums1[i] = nums2[n--];
                continue;
            }
            if (n < 0) {
                nums1[i] = nums1[m--];
                continue;
            }
            if (nums1[m] >= nums2[n]) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
        }
    }
}