
void dfs(int i,int j,char[][] grid){
  if(i<0||j<0||i>grid.length||j>grid[0].length||grid[i][j]=='0') return;
  grid[i][j] = '0';
   dfs(i+1,j,grid);
   dfs(i,j+1,grid);
   dfs(i-1,j,grid);
   dfs(i+1,j-1,grid);
}

  public int numIslands(char[][] grid) {
    int row = grid.size();
    int col = grid[0].size();
    int cnt = 0;
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
          if(grid[i][j] == '1')
            cnt++;
          dfs(i,j,grid);
      }
    }
    return cnt;
  }
