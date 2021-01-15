class Solution{
    public class pair{
        int i, j, level;
        pair(int i, int j, int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    public boolean isValid(int x, int y, int[][] hospital){
        if(x>=0 && x<hospital.length && y>=0 && y<hospital[0].length)
            return true;
        return false;
    }
    public int helpaterp(int[][] hospital) {
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<hospital.length;i++){
            for(int j=0;j<hospital[i].length;j++){
                if(hospital[i][j]==2){
                    q.add(new pair(i, j, 0));
                }
            }
        }
        int res = 0;
        while(!q.isEmpty()){
            pair temp = q.poll();
            int x = temp.i;
            int y = temp.j;
            int level = temp.level;
            if(isValid(x-1, y, hospital) && hospital[x-1][y]==1){
                q.add(new pair(x-1, y, level+1));
                hospital[x-1][y] = 2;
            }
            if(isValid(x, y-1, hospital) && hospital[x][y-1]==1){
                q.add(new pair(x, y-1, level+1));
                hospital[x][y-1] = 2;
            }
            if(isValid(x+1, y, hospital) && hospital[x+1][y]==1){
                q.add(new pair(x+1, y, level+1));
                hospital[x+1][y] = 2;
            }
            if(isValid(x, y+1, hospital) && hospital[x][y+1]==1 ){
                q.add(new pair(x, y+1, level+1));
                hospital[x][y+1] = 2;
            }
            res = Math.max(res, level);
        }
        for(int i=0;i<hospital.length;i++){
            for(int j=0;j<hospital[0].length;j++){
                if(hospital[i][j]==1)
                    return -1;
            }
        }
        return res;
    }
}