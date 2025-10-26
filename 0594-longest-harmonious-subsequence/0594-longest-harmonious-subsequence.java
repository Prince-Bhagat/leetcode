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

        int start =0;
        int end = start +1;

        while (start < nums.length -1){
            end = start + 1;

            int startElement = nums[start];
            int endElement = nums[end];

            while(end < nums.length && (nums[start] == nums[end] || Math.abs(nums[start] - nums[end]) == 1)){
                end++;
            }
            if((nums[end -1] - nums[start])> 0 && length < (end - start)){
                length = (end - start);
            }
            start++;
        }
        return length;

    }   
}