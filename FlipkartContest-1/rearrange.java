class Solution
{
    public String smallestnum(String N){
        int count[] = new int[10];
        for(int i=0;i<N.length();i++){
            int digit = Integer.valueOf(String.valueOf(N.charAt(i)));
            count[digit]++;
        }
        String res = "";
        for(int i=1;i<10;i++){
            if(count[i]!=0){
                res+=i;
                count[i]--;
                break;
            }
        }
        for(int i=0;i<10;i++){
            while(count[i]-->0){
                res+=i;
            }
        }
        return res;
    }
}
