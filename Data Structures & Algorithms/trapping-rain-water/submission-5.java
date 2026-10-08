class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        int water = 0;

        while (l <= r) {
            if (maxL <= maxR) {
                int h = height[l++];
                if (h > maxL) maxL = h;
                else water += maxL - h;
            } else {
                int h = height[r--];
                if (h > maxR) maxR = h;
                else water += maxR - h;
            }
        }
        return water;
    }
}