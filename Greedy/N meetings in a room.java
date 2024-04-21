//Intution is to sort the arrays based on finishing time, and take one by one

class Pair{
    int start;
    int end;
    Pair(int start,int end){
        this.start=start;
        this.end=end;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Pair> meetings = new ArrayList<>();
        for(int i=0;i<n;i++){
            meetings.add(new Pair(start[i],end[i]));
        }
        Collections.sort(meetings,(a,b)->a.end-b.end);
        
        int finish = meetings.get(0).end;
        int cnt=1;
        for(int i=1;i<n;i++){
            if(meetings.get(i).start>finish){
                cnt++;
                finish = meetings.get(i).end;
            }
        }
        return cnt;
    }
}
