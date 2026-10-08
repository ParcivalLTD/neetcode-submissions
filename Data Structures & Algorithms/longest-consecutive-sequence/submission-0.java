class Solution {
    public int longestConsecutive(int[] nums) {
        int maxSequence = 0;
        HashSet<Integer> numSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int tmp = 0;
            if(!numSet.contains(num - 1)) {
                int n = 0;
                while(numSet.contains(num + n)) {
                    tmp++;
                    n++;
                    maxSequence = Math.max(maxSequence, tmp);
                }
            }
        }
        return maxSequence;
    }
}
