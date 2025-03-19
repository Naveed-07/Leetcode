class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int size = nums.length;
        for(int i = 0; i < size -2; i++){
            if(nums[i] == 0){
                count ++;
                nums[i] = 1;
                nums[i+1] = 1 - nums[i+1];
                nums[i+2] = 1 - nums[i+2];
            }
        }
        return nums[size-1] == 1 && nums[size-2] == 1 ? count : -1;
    }
}