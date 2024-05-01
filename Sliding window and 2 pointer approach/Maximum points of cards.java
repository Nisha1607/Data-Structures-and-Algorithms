https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

TC : O(k)
SC :O(1)

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        int leftSum=0;
        int rightSum=0;
        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
        }
        int ri = n-1;
        int maxSum=leftSum;
        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[ri--];
            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
