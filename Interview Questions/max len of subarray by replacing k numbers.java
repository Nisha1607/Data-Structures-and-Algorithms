import java.util.*;
class HelloWorld {
    static int solve(int[] A,int k){
        int l=0;
        int r=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int currMaxFreq = 0;
        int maxLen=0;
        int n = A.length;
        while(r<n){
            map.put(A[r],map.getOrDefault(A[r],0)+1);
            currMaxFreq=Math.max(currMaxFreq,map.get(A[r]));
            if(r-l+1 - currMaxFreq > k){
                int freq = map.get(A[l]);
                map.put(A[l],freq-1);
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int A[] ={1,2,3,3,3,4,5,6,6,6,6,6};
        int k=3;
        int ans = solve(A,k);
        System.out.println(ans);
    }
}
