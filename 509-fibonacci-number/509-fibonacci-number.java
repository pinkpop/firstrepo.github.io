class Solution {
    public int fib(int n) {
       //DP 带有备忘录的动规
        int[] memo = new int[n+1];
        return dp(memo, n);
    }
    
        int dp(int[] memo, int n){
        //base case
        if(n == 0 || n ==1){
            return n;
        }
            if(memo[n] != 0){
                return memo[n];
            }
            memo[n] = dp(memo, n-1)+dp(memo, n-2);
            return memo[n];
        }
        
    
}