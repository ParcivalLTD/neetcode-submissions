class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        for(int i = 0; i < heights.length; i++) {
            int height = Math.min(heights[left], heights[right]);
            int width =  right - left;
            int area = height * width;
            if(area > maxArea) {
                maxArea = area;
            }
            
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
