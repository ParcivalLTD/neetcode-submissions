class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for(String s : strs) {
            int[] occ = new int[26];
            for(int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                occ[index]++;
            }
            result.putIfAbsent(Arrays.toString(occ), new ArrayList<String>());
            result.get(Arrays.toString(occ)).add(s);
        }
        return new ArrayList<>(result.values());
    }
}
