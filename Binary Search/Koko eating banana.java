  int calculatehrs(int[] piles,int mid,int hr){
        int cnt=0;
        for(int i=0;i<piles.length;i++){
           cnt += Math.ceil((double)(piles[i]) / (double)(mid));
        }
        return cnt;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int hrs = 0;
        int ans =Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            hrs = calculatehrs(piles,mid,h);
            if(hrs<=h){
                ans=Math.min(ans,mid);
                high = mid-1;
            }
            if(hrs>h)
                low=mid+1;
            else
                high=mid-1;
        }
        return ans;
    }
