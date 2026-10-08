class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occ = new HashMap<>();
        for (int i : nums) {
            occ.put(i, occ.getOrDefault(i, 0) + 1);
        }
        
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        for(Map.Entry<Integer, Integer> e : occ.entrySet()) {
            buckets.get(e.getValue()).add(e.getKey());

        }
        int[] result = new int[k];
        int index = 0;
        for (int c = nums.length; c > 0; c--) {
            for(int num : buckets.get(c)) {
                result[index++] = num;
                if (index == k) return result;
            }
        }
    return result;
    }
}