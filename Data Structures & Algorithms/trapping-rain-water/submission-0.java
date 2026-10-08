class Solution {
    public int trap(int[] height) {
        int maxL = 0;
        int maxR = 0;

        int r = height.length - 1;

        int water = 0;

        for(int l = 0; l <= r; l++) {
            if(maxL <= maxR) {
                water += Math.max(0, maxL - height[l]); 
                maxL = Math.max(maxL, height[l]);
            }
            while(maxR < maxL) {
                water += Math.max(0, maxR - height[r]);
                maxR = Math.max(maxR, height[r]);
                r--;
            }
        }

        return water;
    }
}
