//TC : O(N*N)
//SC : O(N*N)

class cell{
        int x,y,dist;
        cell(int x,int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        Queue<cell> q = new LinkedList<>();
        
        q.add(new cell(KnightPos[0],KnightPos[1],0));
        int[] dx = {-2,-2,-1,-1,1,1,2,2};
        int[] dy = {-1,1,-2,2,-2,2,-1,1};
        boolean[][] vis = new boolean[N+1][N+1];
        vis[KnightPos[0]][KnightPos[1]]=true;
        while(!q.isEmpty()){
            cell pos = q.remove();
            if(pos.x==TargetPos[0] && pos.y==TargetPos[1])
                return pos.dist;
            for(int i=0;i<8;i++){
                int x=pos.x+dx[i];
                int y=pos.y+dy[i];
                if((x>0&&y>0&&x<=N&&y<=N) && !vis[x][y]){
                    q.add(new cell(x,y,pos.dist+1));
                    vis[x][y]=true;
                }
            }
        }
        return -1;
    }
