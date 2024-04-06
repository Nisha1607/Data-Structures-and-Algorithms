 public int[][] floodFill(int[][] image, int sr, int sc, int color) {
   Queue<int[]> q = new LinkedList<>();
   int initialColor = image[sr][sc];  
    int row = image.length;
    int col = image[0].length;

    q.add(new int[]{sr,sc});
    image[sr][sc] = color;

   int[] dx = {0,0,1,-1};
   int[] dy = {1,-1,0,0};

   if(image[sr][sc]==color)
       return image;
   
    while(q.isEmpty()){
      int[] points = q.poll();
      for(int i=0;i<4;i++){
        int x = points[0] + dx[i];
        int y = points[1] + dy[i];
        if(x>=0&&y>=0&&x<=row&&y<=col&&image[sr][sc]==initialColor){
          q.add(new int[]{x,y});
          image[x][y]=color;
        }
    }
    return image;
  }
