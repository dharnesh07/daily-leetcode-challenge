class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = dp[i][1] = -1;
        }
        return Fn(nums,n - 1,0);
    }
    private int Fn(int[]nums,int idx,int flag){
        if(idx < 0){
            return 0;
        }
        if(dp[idx][flag] != -1){
            return dp[idx][flag];
        }
        int x = Fn(nums,idx - 1,0);
        int y = Fn(nums,idx - 1,1) + (flag ^ 1) * nums[idx];
        return dp[idx][flag] = Math.max(x,y);
    }
}