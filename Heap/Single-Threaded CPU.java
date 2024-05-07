https://leetcode.com/problems/single-threaded-cpu/description/


class Solution {
    class Task{
        int idx;
        int enqTime;
        int procTime;

         Task(int idx , int en , int pro){
            this.idx = idx;
            this.enqTime = en;
            this.procTime = pro;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] arr = new Task[n];

        for(int i=0;i<n;i++){
            arr[i]= new Task(i,tasks[i][0],tasks[i][1]);
        }

        Arrays.sort(arr,(a,b)->a.enqTime-b.enqTime);

        PriorityQueue<Task> pq = new PriorityQueue<>((a,b)->
                (a.procTime==b.procTime) ? a.idx-b.idx : a.procTime-b.procTime);

        int[] ans = new int[n];

        int ansIdx = 0;
        int currTime = 0;
        int taskIdx = 0;

        while(ansIdx < n){
            while(taskIdx<n && arr[taskIdx].enqTime <= currTime)
                pq.add(arr[taskIdx++]);
            
            if(pq.isEmpty()){
                currTime = arr[taskIdx].enqTime;
            }
            else{
                currTime += pq.peek().procTime;
                ans[ansIdx++] = pq.poll().idx;
            }
        }
        return ans;

    }
}
