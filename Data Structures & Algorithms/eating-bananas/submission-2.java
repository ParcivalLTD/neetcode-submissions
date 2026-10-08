class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int i = 0; i < piles.length; i++) {
            max = Math.max(piles[i], max);
        }
        
        int res = Integer.MAX_VALUE;

        int l = 1;
        int r = max;

        while(l <= r) {
            int m = l + (r - l) / 2;
            long hours = 0;
            for(int i = 0; i < piles.length; i++) {
                hours += (int) Math.ceil((double)piles[i] / m);
            }
            if(hours <= h) {
                res = m;
                r = m - 1;
            } else if (hours > h) {
                l = m + 1;
            }
        }
        return res;
    }
}
