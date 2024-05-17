// TC : O(n!)

class Solution {
    void allPermutation(boolean[] freq,int[] nums,List<Integer> ds,List<List<Integer>> ans){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                allPermutation(freq,nums,ds,ans);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<>();
        boolean[] freq = new boolean[n];
        allPermutation(freq,nums,ds,ans);
        return ans;
    }
}
