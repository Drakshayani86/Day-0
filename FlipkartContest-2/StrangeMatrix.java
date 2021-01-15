class Solution{
    private A a;
    Solution(A a){
        this.a=a;
    }
    int get(int i,int j){
      return a.get(i,j); 
    }
    public int solve(int R,int C){
        int res = 0, index = C-1;
        for(int i=0;i<R;i++){
            while(index>=0 && get(i, index)==1){
                index--;
                res = i;
            }
        }
        return res;
    }
};