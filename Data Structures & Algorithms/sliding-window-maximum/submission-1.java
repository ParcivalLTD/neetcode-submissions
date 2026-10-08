class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        int tmp = 0;

        for(int l = 0; l < nums.length; l++) {
            if(!deque.isEmpty()) {
              if(deque.getFirst() <= l - k) deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[l] > nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(l);
            if(l >= k - 1) res[tmp++] = nums[deque.getFirst()];

        }
        return res;
    }
}
