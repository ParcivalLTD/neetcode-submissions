class Solution {
    public boolean isPalindrome(String s) {
        String pal = "";
        String revPal = "";
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                pal += Character.toLowerCase(c);
            }
        }

        for(int i = pal.length()-1; i >= 0; i--) {
            revPal += pal.charAt(i);
        }

        System.out.println(pal);
        System.out.println(revPal);

        if(pal.equals(revPal)) return true;
        return false;
    }
}
