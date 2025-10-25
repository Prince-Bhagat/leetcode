class Solution {
    public int findMinBinarySearchForDuplicate(int startIndex, int endIndex, int[] nums) {


        if(startIndex >= endIndex ) return nums[startIndex];

        int middleIndex = (startIndex + endIndex)/2;
        int middleElement = nums[middleIndex];
        int startElement = nums[startIndex];
        int endElement = nums[endIndex];
        
        if(startElement == middleElement && middleElement == endElement){
            int min = Integer.MAX_VALUE;
            for (int i = startIndex; i <= endIndex; i++) {
                int num = nums[i];
                if(num < min){
                    min =  num;
                }
            }
            return min;
        }

        if(startElement <= middleElement && middleElement <= endElement){
            // normal BS
            return findMinBinarySearchForDuplicate(startIndex, middleIndex-1, nums);
        }



        // Lowest is on Right side of middle
        if(startElement <= middleElement && middleElement >= endElement){
            return findMinBinarySearchForDuplicate(middleIndex+1, endIndex, nums);
        }

        // Lowest is on left side of middle
        if(startElement >= middleElement && middleElement <=  endElement){

            return findMinBinarySearchForDuplicate(startIndex, middleIndex, nums);
        }

        return -1;
    }

    public int findMin(int[] array) {
        return findMinBinarySearchForDuplicate(0,array.length-1, array);
    }
}