  int dfs(int[][] grid,int x,int y,int canWalk){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==-1) return 0;
        if(grid[x][y]==2)  return canWalk==-1 ?1:0;
        grid[x][y]=-1;
        canWalk--;
        int ans = dfs(grid,x+1,y,canWalk) + dfs(grid,x-1,y,canWalk) +
                    dfs(grid,x,y+1,canWalk) + dfs(grid,x,y-1,canWalk);
        grid[x][y]=0;
        canWalk++;
        return ans;
        
    }

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int canWalk=0,start_x=0,start_y=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)
                    canWalk++;
                if(grid[i][j]==1){
                    start_x=i;
                    start_y=j;
                }
            }
        }
        return dfs(grid,start_x,start_y,canWalk);
    }
