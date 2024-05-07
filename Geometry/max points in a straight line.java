https://leetcode.com/problems/max-points-on-a-line/description/

class Solution {
    public int maxPoints(int[][] points) {
        Map<Double,Integer> map = new HashMap<>();
        int n = points.length;
        
        int maxPoints=1;
        for(int i=0;i<n;i++){
            map.clear();
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=0;j<n;j++){
                if(i==j) continue;
                int x2 = points[j][0];
                int y2 = points[j][1];
                double slope=Integer.MAX_VALUE;
                if(x1!=x2){
                    slope = ((y2-y1)*1.0d) / ((x2-x1)*1.0d);
                }
                int cnt = map.getOrDefault(slope,1)+1;
                map.put(slope,cnt);
                maxPoints = Math.max(maxPoints,cnt);
            }
        }
        return maxPoints;
    }
}
