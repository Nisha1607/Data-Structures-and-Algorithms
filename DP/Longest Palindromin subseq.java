 public int longestPalindromeSubseq(String s) {
        
        String s1 = new StringBuilder(s).reverse().toString();
        
         int m = s.length();

        int [][] dp=new int[m+1][m+1];
         for(int i=0;i<=m;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0) dp[i][j]=0;
            }
         }

        int maxVal = 0;
         for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s.charAt(j-1)){
                   dp[i][j] = 1+dp[i-1][j-1];
                   maxVal = Math.max(maxVal,dp[i][j]); 
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
         }
         return maxVal;
    }
