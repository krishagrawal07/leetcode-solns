class Solution {
    private boolean matches(int[] a,int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
            return true;
        
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<>();
        if(p.length()>s.length()) return result; //0 return ker dega

        int[] countp=new int[26];
        int[] countwindow=new int[26];

        for(int i=0;i<p.length();i++){
            countp[p.charAt(i)-'a']++;
            countwindow[s.charAt(i)-'a']++;
        }
        if(matches(countp,countwindow)) result.add(0);

        for(int i=p.length();i<s.length();i++){
            countwindow[s.charAt(i)-'a']++;
            countwindow[s.charAt(i-p.length())-'a']--;

            if(matches(countp,countwindow)){
                result.add(i-p.length()+1); //starting index window ka
            }
        }
        return result;
    }
}