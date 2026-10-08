class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        int result = 0;
        

        for(int r = 0; r < s.length(); r++) {
            int mostFrequent = 0;
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            
            for(char i = 'A'; i <= 'Z'; i++) {
                mostFrequent = Math.max(count.getOrDefault(i, 0), mostFrequent);
            }

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
