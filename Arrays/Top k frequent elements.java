//TC :O(nlogn)

 public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
           if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }

        int n = map.size();

        int[][] arr = new int[n][2];

        int idx=0;
        for(Integer it : map.keySet()){
            arr[idx][0] = it; //key or element in the array
            arr[idx][1] = map.get(it); // freq
            idx++;
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));

        int[] res = new int[k];

        idx=0;

        for(int i=n-1;i>n-1-k;i--){
            res[idx++] = arr[i][0];
        }

        return res;

    }


//O(n)
   public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
           if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }

        int n = map.size();

        ArrayList<Integer>[] arr = new ArrayList[nums.length+1];

        for(int i=0;i<arr.length;i++) arr[i]=new ArrayList<>();

        for(Integer itr : map.keySet()){
            arr[map.get(itr)].add(itr);
        }

        int[] res = new int[k];

        int idx=0;
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<arr[i].size();j++){
                if(idx==k) return res;
                res[idx++]=arr[i].get(j);
            }
        }
        return res;

    }
