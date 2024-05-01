//TC : O(n*n)
static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> res= new ArrayList<>();
        int maxVal=-1;
        
        for(int i=0;i<n-k+1;i++){
            maxVal=-1;
            for(int j=i;j<i+k;j++){
                maxVal=Math.max(maxVal,arr[j]);
            }
            res.add(maxVal);
        }
         
        return res;
    }
