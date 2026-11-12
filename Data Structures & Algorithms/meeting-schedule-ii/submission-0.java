/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int res = 0;
        int s = 0;
        int e = 0;

        while(s < start.length) {
            if(start[s] < end[e]) {
                //increment s and increment count
                s++;
                count++;
            }
            else {
                //increment e and decrement count
                e++;
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
