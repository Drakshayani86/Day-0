class Solution{
    public ArrayList<ArrayList<Integer>> res;
    long solve(int V,int E,int[] Values,int[][] Edges){
        res = new ArrayList<ArrayList<Integer>>(V);
        for(int i=0;i<V;i++){
            res.add(new ArrayList<Integer>());
        }
        for(int i=0;i<E;i++){
            res.get(Edges[i][0]-1).add(Edges[i][1]-1);
            res.get(Edges[i][1]-1).add(Edges[i][0]-1);
        }
        boolean visited[] = new boolean[V+1];
        long score = 0;
        long maxScore = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                score = dfs(i, Values, visited);
                maxScore = Math.max(maxScore, score);
            }
        }
        return maxScore;
    }
    
    public long dfs(int i, int[] Values, boolean[] visited){
        long sum = Values[i];
        visited[i] = true;
        for(Integer adj:res.get(i)){
            if(!visited[adj]){
                sum += dfs(adj, Values, visited);
            }
        }
        return sum;
    }
}