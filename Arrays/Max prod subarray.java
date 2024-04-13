// TC : O(n*n)
// SC : O(1)
   public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int maxProd = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int mul=nums[i];
             maxProd = Math.max(maxProd,mul);
            for(int j = i+1 ;j<n;j++){
                mul = mul*nums[j];
                maxProd = Math.max(maxProd,mul);
            }
             maxProd = Math.max(maxProd,mul);
        }
        return maxProd;
    }

// TC : O(n)
// SC : O(1)

public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int pref = 1;
        int suff = 1;
        int maxProd = nums[0];
        for(int i=0;i<n;i++){
            if(pref == 0)
                pref = 1;
            if(suff == 0)
                suff = 1;
            pref *= nums[i];
            suff *= nums[n-i-1];
            maxProd = Math.max(maxProd,Math.max(pref,suff));
        }
        return maxProd;
    }
