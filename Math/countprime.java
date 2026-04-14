class Solution {
    
    public void check(boolean[] arr, int j){
        for(int i = j * j; i < arr.length; i += j){
            arr[i] = true;
        }
    }
    
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        
        int count = 0;
        boolean[] arr = new boolean[n];
        
        for(int j = 2; j * j < n; j++){
            if(arr[j] == false){
                check(arr, j);
            }
        }
        
        for(int i = 2; i < n; i++){
            if(arr[i] == false) count++;
        }
        
        return count;
    }
}