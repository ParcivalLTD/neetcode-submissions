class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> digits = new HashSet<>();
        for(int i : nums) {
            if(!digits.contains(i)) {
                digits.add(i);
            }
            else {
                return true;
            }
            
        }
        return false;
    }
}