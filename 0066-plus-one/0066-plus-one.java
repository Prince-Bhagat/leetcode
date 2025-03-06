class Solution {
    public int[] plusOne(int[] array) {
        int newDigit = array[array.length -1] +1 ;
        int carryOver = newDigit / 10;
        if(carryOver == 0){
            array[array.length -1] = array[array.length -1] +1;
            return array;
        }
        array[array.length -1] = 0;
        for (int i = array.length -2; i >=0 ; i--) {
            newDigit = array[i] + carryOver;
            carryOver = newDigit /10;
            if(carryOver == 0){
                array[i] = newDigit;
                return array;
            }
            array[i] = newDigit%10;
        }
        int [] newArray = new int[array.length +1];
        System.arraycopy(array,0,newArray,1,array.length);
        newArray[0]= carryOver;
        return newArray;
    }
}