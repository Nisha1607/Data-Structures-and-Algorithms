class Solution {
     int cnt=0;
     void countPairs(int low,int mid,int high,int[] nums){
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && 0.5*nums[i] > nums[right]) right++;
            cnt+=right-(mid+1);
        }
     }

     void merge(int low,int mid,int high,int[] nums){
        ArrayList<Integer> tmp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                tmp.add(nums[left]);
                left++;
            }
            else{
                tmp.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            tmp.add(nums[left]);
            left++;
        }
        while(right<=high){
            tmp.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=tmp.get(i-low);
        }
    }

    void mergeSort(int low,int high,int[] nums){
        if(low==high) return;
        int mid = (low+high)/2;
        mergeSort(low,mid,nums);
        mergeSort(mid+1,high,nums);
         countPairs(low,mid,high,nums);
        merge(low,mid,high,nums);
         
    }

    public int reversePairs(int[] nums) {
        mergeSort(0,nums.length-1,nums);
        return cnt;
    }
}
