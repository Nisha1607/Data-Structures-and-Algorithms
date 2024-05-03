

// Recursion

int solve(int day, int points[][],int last){
  if(day==0){
    int maxPoints = 0;
    for(int task=0;task<3;task++){
      if(task!=last)
        maxPoints = Math.max(maxPoints,points[0][task]);
    }
    return maxPoints;
  }
  int maxPoints = 0;
   for(int task=0;task<3;task++){
      if(task!=last)
        maxPoints = Math.max(maxPoints,points[day][task]+solve(day-1,points,task));
    }
    return maxPoints;
}

 public static int ninjaTraining(int n, int points[][]) {
        int last=3;
        return solve(n-1,points,last);
}


//memoization
int solve(int day, int points[][],int last,int[][] dp){
  if(day==0){
    int maxPoints = 0;
    for(int task=0;task<3;task++){
      if(task!=last)
        maxPoints = Math.max(maxPoints,points[0][task]);
    }
    return  dp[day][last] = maxPoints;
  }
  if(dp[day][last]!=0) return dp[day][last];
  int maxPoints = 0;
   for(int task=0;task<3;task++){
      if(task!=last)
        maxPoints = Math.max(maxPoints,points[day][task]+solve(day-1,points,task,dp));
    }
    return dp[day][last] = maxPoints;
}

 public static int ninjaTraining(int n, int points[][]) {
        int last=3;
        int[][] dp = new int[n][3];
       for (int[] row : dp){
             Arrays.fill(row, -1);
       }
        return solve(n-1,points,last,dp);
}

//Tabulation 
//TC : O(N)
  public static int ninjaTraining(int n, int points[][]) {
    
       int[][] dp = new int[n][4];
     
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1]= Math.max(points[0][0],points[0][2]);
        dp[0][2]= Math.max(points[0][1],points[0][0]);
        dp[0][3]= Math.max(points[0][1],Math.max(points[0][0],points[0][2]));
         
         
         for(int day=1;day<n;day++){
             for(int last =0;last<4;last++){
                 dp[day][last]=0;
                 for(int task=0;task<3;task++){
                          if(task!=last)
                             dp[day][last] = Math.max(dp[day][last] , points[day][task]+dp[day-1][task]);
                 }
             }
         }
        return dp[n-1][3];
    }

//Space optimization
//TC : O(N*4*3)
//SC : O(4)
 public static int ninjaTraining(int n, int points[][]) {
    
      // int[][] dp = new int[n][4];
       int[] prev = new int[4];
     
       prev[0] = Math.max(points[0][1],points[0][2]);
        prev[1]= Math.max(points[0][0],points[0][2]);
        prev[2]= Math.max(points[0][1],points[0][0]);
        prev[3]= Math.max(points[0][1],Math.max(points[0][0],points[0][2]));
         
         
         for(int day=1;day<n;day++){
             int[] temp = new int[4];
             for(int last =0;last<4;last++){
                 
                 for(int task=0;task<3;task++){
                          if(task!=last)
                             temp[last] = Math.max(temp[last] , points[day][task]+prev[task]);
                 }
             }
             prev=temp;
         }
        return prev[3];
    }
