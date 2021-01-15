class Solution 
{ 
    void nextPermutation(int perm[], int N){
        int i;
        for(i=N-1;i>0;i--){
            if(perm[i]>perm[i-1])
                break;
        }
        if(i==0){
            Arrays.sort(perm);
        }
        else{
            int x = perm[i-1], min = i;
            for(int j=i+1;j<N;j++){
                if(perm[j]>x && perm[j]<perm[min]){
                    min = j;
                }
            }
            int temp = perm[i-1];
            perm[i-1] = perm[min];
            perm[min] = temp;
            Arrays.sort(perm, i, N);
        }
    }
} 
