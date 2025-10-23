class Solution {
    private int divide(int startIndex, int endIndex, int [] nums, int target){
        if(startIndex > endIndex) return -1;
        int middleIndex = (startIndex + endIndex)/2;
        int middleElement = nums[middleIndex];
        int startElement = nums[startIndex];
        int endElement = nums[endIndex];

        // identify which part is sorted
        if(target == middleElement) return middleIndex;

        if(startElement <=  middleElement ){// left is sorted
            if(target < middleElement  && startElement<= target){
                return divide(startIndex, middleIndex -1, nums, target);
            }else{
                return divide(middleIndex+1, endIndex, nums, target );
            }
        }
        if(middleElement <= endElement){// right is sorted
            if(target > middleElement && target <= endElement){
                return divide(middleIndex+1, endIndex, nums, target);
            }else{
                return divide(startIndex, middleIndex-1, nums, target);
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
         return divide(0 , nums.length -1, nums, target);
    }
}