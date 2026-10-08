class Solution {
    public int trap(int[] height) {
        int maxL = 0;
        int maxR = 0;
        int r = height.length - 1;
        int water = 0;

        for(int l = 0; l <= r; l++) {
            if(maxL <= maxR) {
                int val = height[l];
                water += Math.max(0, maxL - val); 
                maxL = Math.max(maxL, val);
            }
            while(maxR < maxL) {
                int val = height[r];
                water += Math.max(0, maxR - val);
                maxR = Math.max(maxR, val);
                r--;
            }
        }

        return water;
    }
}
