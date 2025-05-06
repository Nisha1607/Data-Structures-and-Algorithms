https://leetcode.com/problems/jump-game-ii/description/
    public int jump(int[] nums) {
        int l=0,r=0,farthest=0;
        int n = nums.length;
        int jump=0;
        while(r<n-1){
            for(int i=l;i<=r;i++){
                farthest = Math.max(farthest,i+nums[i]);
            }
            jump++;
            l=r+1;
            r=farthest;
        }
        return jump;
    }
