public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        return dac(nums, 0, nums.length - 1);
    }

    private int dac(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) >> 1;
        int n1 = dac(nums, left, mid), n2 = dac(nums, mid+1, right), i = left, j = mid + 1, k = 0, count = 0;
        int[] merged = new int[right - left + 1];
        while (i <= mid) {
            while (j <= right && nums[i] / 2.0 > nums[j])
                j++;
            count += j - (mid + 1);
            i++;
        }
        i = left;
        j = mid + 1;
        while (i <= mid && j <= right) {
            merged[k++] = nums[i] > nums[j] ? nums[j++] : nums[i++];
        } 
        while (i <= mid) merged[k++] = nums[i++];
        while (j <= right) merged[k++] = nums[j++];
        System.arraycopy(merged, 0, nums, left, merged.length);
        return n1 + n2 + count;
    }
}