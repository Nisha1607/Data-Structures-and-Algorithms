Complexity: 
* TC: O(NlogN) for sorting and O(NlogK) for priority queue
* SC: O(N)


 public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] players = new int[n][2];
        for (int i=0; i<n; i++) {
            players[i][0] = efficiency[i];
            players[i][1] = speed[i];
        }
		// Sort the players based on efficiency in decreasing order, as for each iteration, we'll consider only players with higher efficiency.
        Arrays.sort(players, (p1, p2) -> (p2[0] - p1[0]));

		// Priority-Queue to maintain players with highest relative speeds with efficiencies greater than the one under iteration.
        PriorityQueue<Integer> speedQueue = new PriorityQueue<>(k);
        long teamPerformance = 0, teamSpeed = 0;

        for (int i=0; i<n; i++) {
			// This is because a team can have atmost `k` players.
            if (speedQueue.size() >= k) {
                teamSpeed -= speedQueue.remove();
            }
            speedQueue.add(players[i][1]);
            teamSpeed += players[i][1];

            teamPerformance = Math.max(teamPerformance, teamSpeed * players[i][0]);
        }
        return (int) (teamPerformance % 1000000007);
    }
}


       
public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
       int[][] engineer = new int[n][2];
       for(int i=0;i<n;i++){
            engineer[i][0] = efficiency[i]; 
            engineer[i][1] = speed[i]; 
       }
       long result=0,speedSum=0;
       Arrays.sort(engineer,(int[] a,int[] b)->b[0]-a[0]);
        PriorityQueue<Integer> speedMinHeap = new PriorityQueue<>(k);
       for(int i=0;i<n;i++){
        int minEfficiency = engineer[i][0];
        speedMinHeap.add(engineer[i][1]);
        speedSum+=engineer[i][1];
        if(speedMinHeap.size()>k) speedSum-= speedMinHeap.poll();
        result = Math.max(result,(minEfficiency*speedSum));
       }
          return (int)(result % (long)(1e9 + 7));
    }
