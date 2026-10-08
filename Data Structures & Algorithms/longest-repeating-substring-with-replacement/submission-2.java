class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        int result = 0;
        int mostFrequent = 0;
        

        for(int r = 0; r < s.length(); r++) {
            
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            
            mostFrequent = Math.max(mostFrequent, count.get(s.charAt(r)));

            int winLength = r - l + 1;
            if(winLength - mostFrequent <= k) {
                result = Math.max(result, winLength);
            }else {
                count.put(s.charAt(l), count.get(s.charAt(l))-1);
                l++;
            }         
        }
        return result;
    }
}
