public static int upperBound(int []arr, int x, int n){
        // Write your code here.
          int start =0;
        int end = n-1;
        int mid;
        int ans=-1;
       
        while(start<=end){
            mid = (start+end)/2;
            if(arr[mid]>x){
                  ans= mid;
                  end=mid-1;
            }
            else if(arr[mid]<=x)
                start = mid+1;
            else
                end = mid-1;
        }
     if(ans==-1)
        return n;
     else
      return ans;
    }
