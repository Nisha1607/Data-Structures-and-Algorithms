class Solution {

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
        merge(low,mid,high,nums);
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(0,n-1,nums);
        return nums;
    }
}
