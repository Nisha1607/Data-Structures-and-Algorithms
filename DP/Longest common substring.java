//dp

 public static int lcs(String str1, String str2){
        // Write your code here.
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0) dp[i][j]=0;
            }
        }

        int maxValue = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                     maxValue = Math.max(maxValue,dp[i][j]);
                }
                else
                    dp[i][j]=0;
            }
        }

        return maxValue;

    }
