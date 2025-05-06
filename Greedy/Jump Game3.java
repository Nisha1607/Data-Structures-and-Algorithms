//https://leetcode.com/problems/jump-game-iii/

public boolean canReach(int[] arr, int start) {
        if(start<0 || start>=arr.length|| arr[start]<0) return false;
        if(arr[start]==0) return true;
       
        arr[start] =-arr[start];

        boolean ans1 = canReach(arr,start+arr[start]);
        boolean ans2 = canReach(arr,start-arr[start]);

        arr[start] =-arr[start];

        return ans1||ans2;
    }
