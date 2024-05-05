boolean isPossible(int mid,int[] price,int k){
        int candyCnt=1;
        int lastCandy=price[0];
        for(int i=1;i<price.length;i++){
            if(price[i]-lastCandy>=mid){
                candyCnt++;
                lastCandy=price[i];
            }
                
        }
        if(candyCnt>=k)
            return true;
        return false;
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int limit = price[price.length-1];
        int l=0,r=limit;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(isPossible(mid,price,k)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        } 
        return ans;
    }
