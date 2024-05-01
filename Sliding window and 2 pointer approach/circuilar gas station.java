// TC :O(n*n)
 public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int j=i;
             cnt=0;
            int totalGas=0;
            while(cnt<n){
                totalGas += gas[j%n] - cost[j%n];
                if(totalGas < 0) break;
                cnt++;
                j++;
            }
            if(cnt==n && totalGas>=0) return i;
        }
        return -1;
    }


// O(N)
  public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int surplus=0,gasRemaining=0;
        int start=0;
        for(int i=0;i<n;i++){
            surplus+=gas[i]-cost[i];
            gasRemaining += gas[i]-cost[i];
            if(gasRemaining<0){
                gasRemaining=0;
                start=i+1;
            }
        }
         return (surplus < 0) ? -1 : start;
    }
