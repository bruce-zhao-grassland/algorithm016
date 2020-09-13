class Solution {
    public int trap(int[] height) {
        int maxLeft = 0, maxRight = 0;
        int totalRain = 0;
        for (int left = 0, right = height.length-1; left < right;) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalRain += maxLeft - height[left];
                } 
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalRain += (maxRight - height[right]);
                }
                right--;
            }
        }
        return totalRain;
    }
}