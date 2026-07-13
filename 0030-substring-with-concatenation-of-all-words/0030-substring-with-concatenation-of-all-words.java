class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result =new ArrayList<>();
        if(s==null||s.length()==0||words==null||words.length==0){
            return result;
        }
        int wordlength=words[0].length();
        int wordcount=words.length;
        int totallength= wordlength*wordcount;
        Map<String,Integer> wordfreq=new HashMap<>();
        for(String word:words){
            wordfreq.put(word,wordfreq.getOrDefault(word,0)+1);
        }
        for(int i=0;i<wordlength;i++){
            int left=i;
            int right=i;
            int count=0;
            Map<String,Integer> currentfreq=new HashMap<>();
            while(right+wordlength<=s.length()){
                String word=s.substring(right,right+wordlength);
                right+=wordlength;
                if(wordfreq.containsKey(word)){
                    currentfreq.put(word,currentfreq.getOrDefault(word,0)+1);
                    count++;
                
                while(currentfreq.get(word)>wordfreq.get(word)){
                    String leftword=s.substring(left,left+wordlength);
                    currentfreq.put(leftword,currentfreq.get(leftword)-1);
                    count--;
                    left+=wordlength;
                }
                if(count==wordcount){
                    result.add(left);
                }
                }
                else{
                    currentfreq.clear();
                    count=0;
                    left=right;
                }
            }
        }
        return result;

    }
}