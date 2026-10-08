class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        for(char c : s1.toCharArray()) {
            countS1[c - 'a']++;
        }

        int l = 0;

        for(int r = 0; r < s2.length(); r++) {
            countS2[s2.charAt(r) - 'a']++;

            if(r - l + 1 > s1.length()) {
                countS2[s2.charAt(l) - 'a']--;
                l++;
            }

            if(Arrays.equals(countS1, countS2)) return true;
        }

        return false;
    }
}
