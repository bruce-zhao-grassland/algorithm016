问题：使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

这道题和LeetCode-153. 寻找旋转排序数组中的最小值 可以说是相同的

153题是升序数组，寻找最小值，最小值的位置就是无序开始的地方
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n-1]) {
            return nums[0];
        }

        int l = 0, r = n - 1, first = nums[0], last = nums[r];
        while (l < r) {
            int mid = (r + l) >> 1;
            if (l == mid) {
                if (nums[l] > nums[r]) {
                    l = r;
                }
                break;
            }
            if (nums[mid] > first && nums[mid] > last) {
                l = mid + 1;
            } else if (nums[mid] < first && nums[mid] < last){
                r = mid;
            } 
        }
        return nums[l];
    }
}
上面代码中，首先判断是否是乱序
返回l就是无序开始的地方
