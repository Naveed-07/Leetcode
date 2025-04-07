class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums , 0 , 0);
    }

    private int dfs(int[] nums, int idx , int CurrentXor){
        if(idx >= nums.length) return CurrentXor;

        int withElement = dfs(nums , idx + 1 , CurrentXor ^ nums[idx]);
        int withoutElement = dfs(nums , idx + 1 , CurrentXor);

        return withElement + withoutElement;
    }
}