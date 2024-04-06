public int orangesRotting(int[][] grid) {
  Queue<int[]> q= new LinkedList<>();
  int row = grid.length;
  int col = grid[0].length;
  int cntFresh=0;
  for(int i=0;i<row;i++)
  {
    for(int j=0;j<col;j++){
      if(grid[i][j] ==2)
        q.add(new int[]{i,j});
      if(grid[i][j] !=0)
        cntFresh++;
    }
  }
  int[] dx = {0,0,1,-1};
  int[] dy = {1,-1,0,0};
  int time = 0;
  while(!q.isEmpty()){
   
    cntFresh--;
    int size= q.size();
    for(int i=0;i<size;i++){
       int[] points = q.poll();
      for(int j=0;j<4;j++){
        int x = points[0] + dx[j];
        int y = points[1] + dy[j];
        if(x<0||y<0||x>=row||y>=col||grid[x][y]==2|| grid[x][y]==0) continue;
        grid[x][y] = 2;
        q.add(new int[]{x,y});
      }
    }
    time++;
  }
  return cntFresh!=0?-1:time;
}
