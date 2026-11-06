//a simple solution would be to just calculate the distances for all the points, sort them in ascending order and then return the first k elements of that sorted list

//that would require O(n log n) time

//a better solution would be to use a maxHeap, then we go through the array of points. we insert our distance into the maxHeap. if the maxHeap is bigger then k, we remove the max element from it.
//that way at the end we can simply return the array with the maxHeap elements

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));

        for(int i = 0; i < points.length; i++) {
            double x = points[i][0];
            double y = points[i][1];
            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

            maxHeap.add(new double[]{distance, i});

            if(maxHeap.size() > k) maxHeap.poll();
        }

        int[][] result = new int[k][];
        for(int i = 0; i < k; i++) {
            result[i] = points[(int) maxHeap.poll()[1]];
        }
        return result;
    }
}
