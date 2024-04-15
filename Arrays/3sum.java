

//TC : O(n3)

  public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0 )
                    {
                       set.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));              
                    }
                }
            }
        }
        for(ArrayList<Integer> list : set){
            res.add(list);
        }
        return res;
    }


// TC :O(n2)
 public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0;i<n-1;i++){
           int l = i+1;
           int r = n-1;
           int x = nums[i];
           while(l<r){
                if(x+nums[l]+nums[r]==0){
                    res.add(new ArrayList<>(Arrays.asList(nums[l],x,nums[r])));
                    int temp1=l,temp2=r;
                    while(l<r && nums[l] == nums[temp1]) l++;
                    while(l<r && nums[r] == nums[temp2]) r--;
                }
                else if(x+nums[l]+nums[r]<0){
                    l++;
                }
                else
                    r--;
           }
           while(i+1<n&&nums[i]==nums[i+1]) i++;
        }
        for(ArrayList<Integer> list : set){
            res.add(list);
        }
        return res;
    }
