class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int a = 0; a <  nums.length; a++){
                if(i != a && nums[i] + nums[a] == target) {
                   int[] result = {i, a};
                    return result;
                }
            }
        }
        return null;
    }
}
