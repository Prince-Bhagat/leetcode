class Solution {
    public int missingNumber(int[] nums) {
        int range = nums.length;
        int sum = 0;
        int numSum = 0;
        for (int i = 0; i < range; i++) {
            sum = sum + i;
            numSum = numSum + nums[i];
        }
        return (sum + range) - numSum;
    }
}