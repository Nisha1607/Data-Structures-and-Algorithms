//recursion
  int solve(int ind1,int ind2,String word1,String word2){
        //base case
        if(ind1<0)
            return ind2+1;
        if(ind2<0)
            return ind1+1;

        if(word1.charAt(ind1) == word2.charAt(ind2)){
            return solve(ind1-1,ind2-1,word1,word2);
        }
        else{
            int insert = 1 + solve(ind1,ind2-1,word1,word2);
            int delete = 1 + solve(ind1-1,ind2,word1,word2);
            int replace = 1 + solve(ind1-1,ind2-1,word1,word2);
            return Math.min(insert,Math.min(delete,replace));
        }
    }
    public int minDistance(String word1, String word2) {
       
       return solve(word1.length()-1,word2.length()-1,word1,word2);

    }



//memoization
    int solve(int ind1,int ind2,String word1,String word2,int[][] dp){
        //base case
        if(ind1<0)
            return ind2+1;
        if(ind2<0)
            return ind1+1;

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(word1.charAt(ind1) == word2.charAt(ind2)){
          return  dp[ind1][ind2] = solve(ind1-1,ind2-1,word1,word2,dp);
        }
        else{
            int insert = 1 + solve(ind1,ind2-1,word1,word2,dp);
            int delete = 1 + solve(ind1-1,ind2,word1,word2,dp);
            int replace = 1 + solve(ind1-1,ind2-1,word1,word2,dp);
            return  dp[ind1][ind2] =  Math.min(insert,Math.min(delete,replace));
        }

    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
       int[][] dp = new int[m][n];
       for(int[] row : dp)
        Arrays.fill(row,-1);
       return solve(m-1,n-1,word1,word2,dp);

    }


//tabulation
  int solve(int ind1,int ind2,String word1,String word2,int[][] dp){
        //base case
        if(ind1==0)
            return ind2;
        if(ind2==0)
            return ind1;

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(word1.charAt(ind1-1) == word2.charAt(ind2-1)){
          return  dp[ind1][ind2] = solve(ind1-1,ind2-1,word1,word2,dp);
        }
        else{
            int insert = 1 + solve(ind1,ind2-1,word1,word2,dp);
            int delete = 1 + solve(ind1-1,ind2,word1,word2,dp);
            int replace = 1 + solve(ind1-1,ind2-1,word1,word2,dp);
            return  dp[ind1][ind2] =  Math.min(insert,Math.min(delete,replace));
        }

    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
       int[][] dp = new int[m+1][n+1];
       

        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }

        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        
        for(int i =1;i<=m;i++){
            for(int j=1;j<=n;j++){
                 if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] =  Math.min(insert,Math.min(delete,replace));                    }
                }
        }
        return dp[m][n];
    }
