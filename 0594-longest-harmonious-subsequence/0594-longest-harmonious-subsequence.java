class Solution {

    private void sort(int []nums){
        boolean isSwapped = true;
        while(isSwapped ) {
            isSwapped = false;
            for (int i = 0; i < nums.length - 1; i++) {

                if (nums[i] > nums[i + 1]) {
                    isSwapped = true;
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }
    public int findLHS(int[] nums) {
        sort(nums);
            sort(nums);
        int length = 0;

        int start = 0, middle , end = start + 1;

        while(end < nums.length){
            while( end < nums.length && nums[start] ==  nums[end]){
                end++;
            }
            middle = end -1;
            while ( end < nums.length && Math.abs(nums[start] - nums[end]) == 1){
                end++;
            }
            if(nums[middle] != nums[end -1] && (end - start ) > length){
                length = end - start;
            }
            start = middle +1 ;
        }
        return length;

    }   
}