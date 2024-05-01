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

//TC : O(nlogk) or O(n*k)
static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> res= new ArrayList<>();
       
        int l=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((ind1,ind2)->arr[ind2]-arr[ind1]);
       
        for(int r=0;r<n;r++){
            int start = r-k;
            if(start>=0){
                pq.remove(start);
            }
            pq.add(r);
            if(pq.size()==k)
                res.add(arr[pq.peek()]);
        }
        return res;
    }
