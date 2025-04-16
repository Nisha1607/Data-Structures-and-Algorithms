https://leetcode.com/problems/car-pooling/description/
soln 1 - https://leetcode.com/problems/car-pooling/solutions/317869/java-5ms-solution-with-sorted-array-and-priorityqueue/
soln 2 - https://leetcode.com/problems/car-pooling/solutions/6585572/car-pooling-smart-capacity-check/

// Soln 1 - PQ
public boolean carPooling(int[][] trips, int capacity) {
	// 1. sort trips by start_location
    Arrays.sort(trips, new Comparator<int[]>(){
        public int compare(int[] i1, int[] i2) {
            return i1[1] - i2[1];
        }
    });

    Queue<int[]> theQueue = new PriorityQueue<int[]>(new Comparator<int[]>(){
         public int compare(int[] t1, int[] t2) {
             return t1[2] - t2[2];
         }
    });

    for (int i = 0; i < trips.length; i++) {
        while (!theQueue.isEmpty() && theQueue.peek()[2] <= trips[i][1]) { // 2. remove dead trips
            capacity += theQueue.peek()[0];
            theQueue.poll();
        }
		// 3. update capacity
        capacity -= trips[i][0];
        theQueue.offer(trips[i]);
        if( capacity < 0 )
            return false;
    }
    return true;
}


//soln 2- Line Sweep Algorithm
    public boolean carPooling(int[][] trips, int capacity) {
        int noTrips = trips.length;
        int[] dist = new int[1002];
        for(int i=0;i<noTrips;i++){
            dist[trips[i][1]]+=trips[i][0];
            dist[trips[i][2]]-=trips[i][0];
        }
        int currCap=0;
        for(int i=0;i<1002;i++){
            currCap+=dist[i];
            if(currCap>capacity) return false;
        }
        return true;
    }
