public class Solution {
    public int wordLadderLength(String beginWord, String endWord, Set<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        int count = 0, n = beginWord.length();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i=0;i<size;i++){
                char[] ch = q.poll().toCharArray();
                for(int j=0;j<n;j++){
                    char temp = ch[j];
                    for(char c='a';c<='z';c++){
                        ch[j] = c;
                        if(String.valueOf(ch).equals(endWord))
                            return count+1;
                        if(wordList.contains(String.valueOf(ch))){
                            wordList.remove(String.valueOf(ch));
                            q.add(String.valueOf(ch));
                        }
                    }
                    ch[j] = temp;
                }
            }
        }
        return 0;
    }
}
