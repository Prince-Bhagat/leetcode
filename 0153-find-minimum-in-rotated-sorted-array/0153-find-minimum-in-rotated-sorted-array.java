class Solution {
    private int findMinBinarySearch(int startIndex, int endIndex, int[] nums) {
        if(startIndex > endIndex) return -1;
        int middleIndex = (startIndex + endIndex)/2;
        int middleElement = nums[middleIndex];
        int startElement = nums[startIndex];
        int endElement = nums[endIndex];

        if(startIndex == endIndex) return nums[startIndex];

        int middleLeft = ((middleIndex -1)>=0)?nums[middleIndex -1] : middleElement;
        int middleRight = ((middleIndex + 1)< nums.length)?nums[middleIndex+1]:middleElement;
        if(middleElement <=  middleRight && middleElement <= middleLeft){
            return middleElement;
        }
        if(startElement <= middleElement && middleElement <= endElement){
            // Normal Bs
            return findMinBinarySearch(startIndex, middleIndex-1, nums);
        }
        if(startElement <=  middleElement && middleElement > endElement){
            // Right side is not normal
            return findMinBinarySearch(middleIndex +1 , endIndex, nums);
        }
        if(startElement >= middleElement && middleElement <= endElement){
            // left side is not normal
            return findMinBinarySearch(startIndex, middleIndex-1, nums);
        }

        return -1;
    }
    public int findMin(int[] nums) {
        return findMinBinarySearch(0, nums.length -1, nums);
    }
}