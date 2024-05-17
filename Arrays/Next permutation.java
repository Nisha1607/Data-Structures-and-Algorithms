//Brute force TC : O(N! * N)
//Otimal TC : O(N)


class Solution {
    void swap(int[] nums,int ind1, int ind2){
        int temp = nums[ind1];
        nums[ind1]=nums[ind2];
        nums[ind2]=temp;
    }

    void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1)  reverse(nums,0);
        else{
            for(int i=n-1;i>ind;i--){
               if(nums[i]>nums[ind]){
                    swap(nums,i,ind);
                    break;
                }
            }
            reverse(nums,ind+1);   
        }
    }
}
