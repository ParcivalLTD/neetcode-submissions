class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int b = i + 1;
            int c = nums.length - 1;
            int target = -nums[i];

            while(b < c) {
                int sum = nums[b] + nums[c];
                if(sum == target) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[b]);
                    triplet.add(nums[c]);
                    result.add(triplet);
                    while(b < c && nums[b] == nums[b -1]) b++;
                    while(b < c && nums[c] == nums[c - 1]) c--;
                    c--;
                } else if(sum < target) { b++; }
                else if(sum > target) {c--;}
            }            
        }
        return result;
    }
}
