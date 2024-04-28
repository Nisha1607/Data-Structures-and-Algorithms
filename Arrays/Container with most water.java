TC : O(n*n)

long maxArea(int A[], int len){
        // Code Here
        long maxArea = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                maxArea = Math.max(maxArea,(j-i)*Math.min(A[i],A[j]));
            }
        }
        return maxArea;
    }

TC : O(n)

 long maxArea(int A[], int len){
        // Code Here
        int l=0;
        int r=len-1;
        long maxArea = 0;
        while(l<=r){
            maxArea = Math.max(maxArea,(r-l)*Math.min(A[l],A[r]));
            if(A[l]<A[r]){
                l++;
            }
            else
                r--;
        }
        return maxArea;
    }
