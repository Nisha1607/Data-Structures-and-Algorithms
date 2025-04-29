class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        TreeSet<Integer> set= new TreeSet<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='|')
                set.add(i);
        }
        int[] prefixSum = new int[s.length()];
        if(s.charAt(0)=='*'){
            prefixSum[0]=1;
        }
        else{
            prefixSum[0]=0;
        }
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='*'){
                prefixSum[i]=prefixSum[i-1]+1;
            }
            else{
                prefixSum[i]=prefixSum[i-1];
            }
        }
        int k=0;
        for(int[] query : queries){
            Integer start = set.ceiling(query[0]);
            Integer end = set.floor(query[1]);
            if(start==null||end==null||start>query[1]||end<query[0]||start>=end){
                res[k++]=0;
                continue;
            }
            res[k++]=prefixSum[end]-prefixSum[start];
        }
        return res;
    }
}
