//recusrion
//TC : O(2^m * 2^n)
SC : O(n+m)

int solve(int ind1,int ind2, String s1,String s2){
        if(ind1<0 || ind2<0) return 0;
        if(s1.charAt(ind1)==s2.charAt(ind2))
            return 1 + solve(ind1-1,ind2-1,s1,s2);
        return Math.max(solve(ind1-1,ind2,s1,s2),solve(ind1,ind2-1,s1,s2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return solve(text1.length()-1,text2.length()-1, text1, text2);
    }

//memoization
//TC : O(2^m * 2^n)
//SC : O(n+m)

 int solve(int ind1,int ind2, String s1,String s2,int[][] dp){
        if(ind1<0 || ind2<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2))
            return  dp[ind1][ind2] = 1 + solve(ind1-1,ind2-1,s1,s2,dp);
        return dp[ind1][ind2] = Math.max(solve(ind1-1,ind2,s1,s2,dp),solve(ind1,ind2-1,s1,s2,dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] rows : dp)
            Arrays.fill(rows,-1);
        return solve(text1.length()-1,text2.length()-1, text1, text2,dp);
    }


//Tabulation
 public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),n=text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
            dp[i][0] = 0;

        for(int j=0;j<=n;j++)
            dp[0][j] = 0;

        for(int ind1=1;ind1<=m;ind1++){
            for(int ind2=1;ind2<=n;ind2++){
                 if(text1.charAt(ind1-1)==text2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                 else 
                    dp[ind1][ind2] = Math.max(dp[ind1][ind2-1],dp[ind1-1][ind2]);
   
            }
        }
        return dp[m][n];
    }
    
