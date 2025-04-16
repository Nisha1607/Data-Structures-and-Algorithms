1) define min heap in java using PQ -  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
2) define max heap in java using PQ -  PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
3) if data type of PQ is an object then -
       i)  min heap - PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                                                                       if (a[1] > b[1])
                                                                         return 1;
                                                                       else
                                                                         return -1;
                                                                      });

        ii) max heap - PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                                                                       if (a[1] < b[1])
                                                                           return 1;
                                                                       else
                                                                           return -1;
                                                                     });



//Arrays
1. sort 2d array in asc order 
 Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));

//Sorting 2D array - 
  Arrays.sort(arr, new Comparator<int[]>(){
        public int compare(int[] i1, int[] i2) {
            return i1[1] - i2[1];
        }

//Map ->
1) Iterate map - 
 
        for(Integer itr : map.keySet()){
            arr[map.get(itr)].add(itr);
        }

         for(Integer vals : map.values()){
           res.add(vals);
        }


2) count frequencies- 
       Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(nums[i], 0) +1);
        }



2) Graph - 
  i) Create graph from arrayList of arraylist
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(ArrayList<Integer> edge : prerequisites){
            adj.get(edge.get(1)).add(edge.get(0));
        }

   ii) create it from int[][]
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = prerequisites.length;
        
        for(int i = 0; i < numCourses; i++) 
        {
            adj.add(new ArrayList());
        }
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }

    iii) when input matrix is n*n matrix , mostly 0/1 then dont convert it into adjaceny list

3) Strings -
        String[] words = s.trim().split("\\s+"); // to split string into word array containig more than one spaces.

