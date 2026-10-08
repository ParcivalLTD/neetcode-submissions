class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null ||s.length() < t.length()) return "";

        HashMap<Character, Integer> count = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        String res = s;
        String curr = "";
        int l = 0;

        int have = 0;
        int need = tCount.size();

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for(int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);
            count.put(rChar, count.getOrDefault(s.charAt(r), 0) + 1);

            if(tCount.containsKey(rChar) && count.get(rChar).equals(tCount.get(rChar))) have++;

            while(have == need) {
                int len = r - l + 1;
                
                if(len < minLen) {
                    minLen = len;
                    minStart = l;
                }

                char lChar = s.charAt(l);
                count.put(lChar, count.get(lChar) - 1);

                if(tCount.containsKey(lChar) && count.get(lChar) < tCount.get(lChar)) have--;

                l++;
            }
                
        }
        if( minLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minStart, minStart + minLen);
        }
    }
}
