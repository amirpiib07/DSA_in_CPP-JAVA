// LC 1461 - check if a string contain all binary code of size k
class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set= new HashSet<>();
        int i=0;
        int j=k;
        while(j<=s.length()){
            set.add(s.substring(i,j));
            i++;
            j++;
        }
        return set.size()==(1<<k);
    }
}
