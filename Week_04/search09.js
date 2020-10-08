/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    if (0 === nums.length) {
        return -1;
    } else if (1 === nums.length && nums[0] !== target) {
        return -1;
    }
    let len = nums.length;
    let first = nums[0], last = nums[len-1], l = 0, r = len - 1;
    while (l <= r) {
        let m = (l + r) >> 1;
        if (nums[m] === target) {
            return m;
        } else if (first <= nums[m]) {
            if (target >= nums[l] && target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        } else {
            if (target > nums[m] && target <= nums[r]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }
    return -1;
};