class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0) {
            return 0;
        }

        Stack<Double> stack = new Stack<>();
        Map<Integer, Integer> cars = new TreeMap<>(Collections.reverseOrder());

        for(int i = 0; i < position.length; i++) {
            cars.put(position[i], speed[i]);
        }

        for(Map.Entry<Integer, Integer> car : cars.entrySet()) {
            int pos = car.getKey();
            int sp = car.getValue();
            double t = (double) (target - pos) / sp;

            if(stack.isEmpty() || t > stack.peek())  {
                stack.push(t);
            }
        }        
        return stack.size();
    }
}
