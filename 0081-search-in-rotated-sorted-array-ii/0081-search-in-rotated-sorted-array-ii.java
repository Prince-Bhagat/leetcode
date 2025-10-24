class Solution {
    private int divideV2(int startIndex, int endIndex, int[] nums, int target) {
        if(startIndex > endIndex) return -1;
        int middleIndex = (startIndex + endIndex)/2;
        int middleElement = nums[middleIndex];
        int startElement = nums[startIndex];
        int endElement = nums[endIndex];

        // identify which part is sorted
        if(target == middleElement) return middleIndex;
        if(startElement == endElement && startElement == middleElement){
            for (int i = startIndex; i <= endIndex ; i++) {
                if(nums[i] == target){
                    return i;
                }

            }
            return -1;
        }

        if(startElement <= middleElement && middleElement <= endElement){
            //normal
            if(target <  middleElement){
                return divideV2(startIndex, middleIndex-1, nums, target);
            }else{
                return divideV2(middleIndex+1, endIndex, nums, target);
            }
        }
        if(startElement<= middleElement && middleElement > endElement){
            // Highest is on right side
            if( target < middleElement  && target >= startElement){
                return divideV2(startIndex, middleIndex-1, nums, target);
            }else{
                return divideV2(middleIndex+1, endIndex, nums, target);
            }
        }
        if(startElement > middleElement){
            // Highest is on left side
            if(target > middleElement && target <= endElement){
                return divideV2(middleIndex+1, endIndex, nums, target);
            }else{
                return divideV2(startIndex,middleIndex-1, nums, target);
            }
        }
        return  -1;
    }
    public boolean search(int[] nums, int target) {
        int index = divideV2(0 , nums.length -1, nums, target);
        if(index < 0){
            return false;
        }else{
            return true;
        }
    }
}