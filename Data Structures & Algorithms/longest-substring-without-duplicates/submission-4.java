class Solution {
    public int lengthOfLongestSubstring(String s) {
      if(s.length() == 0) return 0;
      int l = 0;
      int r = 1;
      HashMap<Character, Integer> map = new HashMap<>();
      int maxLength = 1;
      map.put(s.charAt(l), 1);
      
      while(true) {
        if(r == s.length()) break;
        char c = s.charAt(r);
        map.put(c, map.getOrDefault(c, 0) + 1);

        while (map.get(c) > 1) {
	  char out = s.charAt(l);
          map.put(out, map.get(out) - 1);
          l++;
        }

        maxLength = Math.max(r - l + 1, maxLength);
        r++;
      }

      return maxLength;
    }
}

