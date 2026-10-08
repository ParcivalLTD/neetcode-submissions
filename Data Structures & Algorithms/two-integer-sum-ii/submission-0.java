class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = 0;
        int m = numbers.length - 1;
        for(int i = 0; i < numbers.length; i++) {
                int sum = numbers[n] + numbers[m];
                if(sum == target) return new int[]{n + 1, m + 1};
                if(sum > target) m--;
                if(sum < target) n++;
        }
        return null;
    }
}