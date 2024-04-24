Complexity: 
* TC: O(NlogN) for sorting and O(NlogK) for priority queue
* SC: O(N)

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
