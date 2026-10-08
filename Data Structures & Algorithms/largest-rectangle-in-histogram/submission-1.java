class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> index = new Stack<>();
        Stack<Integer> height = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            int start = i;
            while(!height.isEmpty() && height.peek() > heights[i]) {
                int h = height.pop();
                int in = index.pop();

                maxArea = Math.max(maxArea, h * (i - in));
                start = in;
            }
            index.push(start);
            height.push(heights[i]);
        }

        while(!height.isEmpty()) {
            int h = height.pop();
            int in = index.pop();
            maxArea = Math.max(maxArea, h * (heights.length - in));
        }

        return maxArea;
    }
}
